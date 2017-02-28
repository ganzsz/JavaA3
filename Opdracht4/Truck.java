public class Truck extends Thread{
    private Container container;
    private Dock dock;
    private int truckNumber;
    private boolean run;
    public Truck(Dock dock, int truckNumber){
        this.dock = dock;
        this.truckNumber = truckNumber;
        run = true;
    }
    public void run(){
        while(run){
            System.out.println("Truck " + truckNumber + ": wil container ophalen.");
            container = dock.loadOnTruck();
            System.out.println("Truck " + truckNumber + ": container " + container.getContainerid() + " opgehaald...wegrijden");
        }
    }
}
