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
            getContainerTime = rnd.nextInt(7000) + 1000; //staat niet specifiek bij hoe lang het moet duren.
            System.out.println("Truck " + truckNumber + ": wil container ophalen.");
            container = dock.loadOnTruck(truckNumber);
            try{
                sleep(getContainerTime); //7000 is de "sweetspot zodat de vakken vullen maar de kranen niet hoeven te wachten."
                dock.editTrucksSleeping("--");
            }
            catch(InterruptedException e){}
        }
    }
}
