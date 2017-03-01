import java.util.Random;
public class Dock{
    private Container[] container;
    private boolean available;
    private int getContainerTime;
    private long startTime;
    private Random rnd = new Random();
    public int cranesSleeping;
    public int trucksSleeping;
    public Dock(){
        container = new Container[5];
        for(int i = 0; i < container.length; i++){
            cranesSleeping = 0;
            trucksSleeping = 0;
            container[i] = null;
            available = false;
        }
    }
    public synchronized void placeContainer(Container containerFromCrane){
        getContainerTime = rnd.nextInt(5000) + 1000;
        if(isFull()){
            available = true;
            notifyAll();
        }
        while(available && trucksSleeping < 2){
            try{
                wait();
            }
            catch(InterruptedException e){}
        }
        checkForEmptySpots(containerFromCrane);
        available = true;
        notifyAll();
    }
    public synchronized Container loadOnTruck(){
        getContainerTime = rnd.nextInt(10000) + 10000;
        while(!available && cranesSleeping < 3){
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
                return temp;
            }
        }
        return null;
    }
    private boolean isFull(){
        for(int i = 0; i < container.length; i++){
            if(container[i] == null) return false;
        }
        return true;
    }
    private void checkForEmptySpots(Container containerCrane){
        for(int i = 0; i < container.length; i++){     //check for empty spots.
            if(container[i] == null){
                container[i] = containerCrane;
                System.out.println("Dock : Container " + containerCrane.getContainerid() + " ontvangen op plaats " + i);
                break;
            }
            else{
                System.out.println("Plek " + i + " is vol.");
            }
        }
    }
}
