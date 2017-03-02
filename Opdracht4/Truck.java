import java.util.Random;
public class Truck extends Thread{
    private Container container;
    private Dock dock;
    private Ship ship;
    private int truckNumber;
    private int getContainerTime;
    private Random rnd;
    public Truck(Dock dock, Ship ship, int truckNumber){
        this.dock = dock;
        this.ship = ship;
        this.truckNumber = truckNumber;
    }
    public void run(){
        while(true){
            rnd = new Random();
            getContainerTime = rnd.nextInt(5000) + 1000;
            System.out.println("Truck " + truckNumber + ": wil container ophalen.");
            container = dock.loadOnTruck(truckNumber);
            try{
                sleep(10000);
                dock.editTrucksSleeping("--");
            }
            catch(InterruptedException e){}
        }
    }
}
