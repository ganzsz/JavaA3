public class Truck extends Thread{
    private Container container;
    private Dock dock;
    private int truckNumber;
    public Truck(Dock dock, int truckNumber){
        this.dock = dock;
        this.truckNumber = truckNumber;
    }
    public void run(){
        try{
            for(int i = 0; i < 100; i++){
                System.out.println("Truck " + truckNumber + "wil container ophalen.");
                container = dock.loadOnTruck(i);
                Truck.sleep(1000);
                System.out.println("Truck " + truckNumber + ": container" + i + "opgehaald...wegrijden");
            }
        }
        catch(InterruptedException e){
        }
    }
}
