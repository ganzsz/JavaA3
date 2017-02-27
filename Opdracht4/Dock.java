public class Dock{
    private Container[] container;
    private boolean available;
    public Dock(){
        container = new Container[5];
    }
    public synchronized void placeContainer(Container containerFromCrane){
        while(available){
            try{
                wait();
            }
            catch(InterruptedException e){
            }
        }
        checkForEmptySpots(containerFromCrane);
        while(isFull()){
            try{
                System.out.println("VOL");
                Crane.sleep(10);
            }
            catch(InterruptedException e){}
        }
        available = false;
        notifyAll();
        System.out.println("");
    }
    public synchronized Container loadOnTruck(){
        while(!available){
            try{
                wait();
            }
            catch(InterruptedException e){}
        }
        while(isEmpty()){
            try{
                //System.out.println("SLAAPIE");
                Truck.sleep(10);
            }
            catch(InterruptedException e){}
        }
        for(int i = 0; i < container.length; i++){
            if(container[i] == null){}
            else{
                Container temp = container[i];
                container[i] = null;
                return temp;
            }
        }
        available = false;
        notifyAll();
        return null;
    }
    public boolean isFull(){
        for(int i = 0; i < container.length; i++){
            if(container[i] == null) return false;
        }
        return true;
    }
    public boolean isEmpty(){
        int counter = 0;
        for(int i = 0; i < container.length; i++){
            if(container[i] == null){
                counter++;
            }
        }
        if(counter == container.length){
            System.out.println(counter);
            return true;
        }
        System.out.println("counter " + counter);
        return false;
    }
    public void checkForEmptySpots(Container containerCrane){
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
