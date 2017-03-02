import java.util.Random;
public class Dock{
    private Container[] container;
    private boolean available;
    private long startTime;
    private int cranesSleeping;
    private int trucksSleeping;
    private int loadRandomContainer;
    private Random rnd;
    public Dock(){
        container = new Container[5];
        rnd = new Random();
        for(int i = 0; i < container.length; i++){
            cranesSleeping = 0;
            trucksSleeping = 0;
            container[i] = null;
            available = false;
        }
    }
    public synchronized void placeContainer(Container containerFromCrane, int craneNumber){
        System.out.println("Kraan " + craneNumber + " : Container " + containerFromCrane.getContainerid() + " opgehaald...overladen");
        System.out.println("Kraan " + craneNumber + " : wil container " + containerFromCrane.getContainerid() + " plaatsen");
        while(available && trucksSleeping < 2 || isFull()){
            try{
                wait();
            }
            catch(InterruptedException e){}
        }
        checkForEmptySpots(containerFromCrane);
        displaySpotStatus();
        available = true;
        notifyAll();
        editCranesSleeping("++");
    }
    public synchronized Container loadOnTruck(int truckNumber){
        while(!available && cranesSleeping < 3 || isEmpty()){
            try{
                wait();
            }
            catch(InterruptedException e){}
        }
        for(int i = 0; i < container.length; i++){
            if(container[i] == null){}
            else{
                Container temp = container[i];
                container[i] = null;
                available = false;
                notifyAll();
                editTrucksSleeping("++");
                System.out.println("Truck " + truckNumber + ": container " + temp.getContainerid() + " opgehaald...wegrijden");
                return temp;
            }
        }
        return null;
    }
    private boolean isFull(){
        for(int i = 0; i < container.length; i++){
            if(container[i] == null) return false;
        }
        available = true;
        notifyAll();
        return true;
    }
    private boolean isEmpty(){
        int counter =0;
        for(int i = 0; i < container.length; i++){
            if(container[i] == null) counter++;
        }
        if(counter == container.length){
            available = false;
            notifyAll();
            return true;
        }
        else return false;
    }
    private void checkForEmptySpots(Container containerCrane){
        for(int i = 0; i < container.length; i++){     //check for empty spots.
            if(container[i] == null){
                container[i] = containerCrane;
                System.out.println("Kade : Container " + containerCrane.getContainerid() + " ontvangen op plaats " + i);
                break;
            }
        }
    }
    private void displaySpotStatus(){
        System.out.println("");
        for(int i = 0; i < container.length; i++){
            if(container[i] == null){
                System.out.println("Plaats " + i + ": leeg");
            }
            else{
                System.out.println("Plaats " + i + ": container " + container[i].getContainerid());
            }
        }
        System.out.println("");
    }
    public synchronized void editCranesSleeping(String i){
        if(i == "--"){
            cranesSleeping--;
        }
        if(i == "++"){
            cranesSleeping++;
        }
    }
    public synchronized void editTrucksSleeping(String i){
        if(i == "--"){
            trucksSleeping--;
        }
        if(i == "++"){
            trucksSleeping++;
        }
    }
}
