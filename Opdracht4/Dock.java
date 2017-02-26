public class Dock{
    private Container[] container;
    private int containerCount;
    public Dock(){
        container = new Container[100];
        containerCount = 0;
    }
    public synchronized void placeContainer(Container container, int i){
        System.out.println("Dock : Container " + i + " ontvangen op plaats " + i);
        System.out.println("");
        this.container[i] = container;
        containerCount++;
    }
    public synchronized int getContainerCount(){
        return containerCount;
    }
    public Container loadOnTruck(int i){
        Container temp = container[i];
        container[i] = null;
        return temp;
    }
}
