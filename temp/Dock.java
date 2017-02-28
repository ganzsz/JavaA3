public class Dock{
    private Container[] container;
    private boolean available;
    public Dock(){
        container = new Container[5];
        available = false;
    }
    public synchronized void placeContainer(Container containerCrane){
        while(available){
            try{
                System.out.println("Kraan wacht");
                wait();
            }
            catch(InterruptedException e){}
        }
        checkForEmptySpots(containerCrane);
        while(isFull()){}
        available = true;
        notifyAll();
        System.out.println("NU IS DE KRAAN AAN DE BEURT.");
    }
    public synchronized void loadOnTruck(){
        while(!available){
            try{
                System.out.println("Truck wacht");
                wait();
            }
            catch(InterruptedException e){}
        while(isEmpty()){}
        }
        for(int i = 0; i < container.length; i++){
            if(container[i] == null){}
                else{
                    Container temp = container[i];
                    System.out.println("Truck: container opgehaald...wegrijden");
                    container[i] = null;
                }
        }
        available = false;
        notifyAll();
    }







    private boolean isFull(){
        for(int i = 0; i < container.length; i++){
            if(container[i] == null) return false;
        }
        return true;
    }
    private boolean isEmpty(){
        int counter = 0;
        for(int i = 0; i < container.length; i++){
            if(container[i] == null){
                counter++;
            }
        }
        if(counter == container.length){
            //System.out.println(counter);
            return true;
        }
        System.out.println("counter " + counter);
    return false;
    }
    private void checkForEmptySpots(Container temp){
        for(int i = 0; i < container.length; i++){     //check for empty spots.
            if(container[i] == null){
                container[i] = temp;
                System.out.println("Dock : Container " + temp.getContainerid() + " ontvangen op plaats " + i);
                break;
            }
            else{
                System.out.println("Plek " + i + " is vol.");
            }
        }
    }
}
