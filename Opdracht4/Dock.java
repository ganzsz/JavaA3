import java.util.Random;
public class Dock{
    private Container[] container;
    private boolean available;
    private int getContainerTime;
    private Random rnd = new Random();
    public Dock(){
        container = new Container[5];
        for(int i = 0; i < container.length; i++){
            container[i] = null;
            available = false;
        }
    }
    public synchronized void placeContainer(Container containerFromCrane){
        if(isFull()){
            System.out.println("TEST");
            available = true;
            notifyAll();
        }
        while(available){
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
        while(!available){
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
