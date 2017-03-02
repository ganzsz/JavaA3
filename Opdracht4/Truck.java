import java.util.Random;
public class Truck extends Thread{
    private Container container;
    private Dock dock;
    private int truckNumber;
    private boolean run;
    private int getContainerTime;
    private Random rnd;
    public Truck(Dock dock, int truckNumber){
        this.dock = dock;
        this.truckNumber = truckNumber;
        run = true;
    }
    public void run(){
        while(run){
            rnd = new Random();
            getContainerTime = rnd.nextInt(5000) + 1000;
            System.out.println("Truck " + truckNumber + ": wil container ophalen.");
            container = dock.loadOnTruck(truckNumber);
            try{
                sleep(20000);
                dock.editTrucksSleeping("--");
            }
            catch(InterruptedException e){}
        }
    }
}
