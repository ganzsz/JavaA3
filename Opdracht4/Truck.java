import java.util.Random;
public class Truck extends Thread{
    private Container container;
    private Dock dock;
    private int truckNumber;
    private int getContainerTime;
    private boolean run;
    Random rnd = new Random();
    public Truck(Dock dock, int truckNumber){
        this.dock = dock;
        this.truckNumber = truckNumber;
        run = true;
    }
    public void run(){
        while(run){
            getContainerTime = rnd.nextInt(10000) + 10000; //staat niet duidelijk in de opdracht hoe lang het maximaal duurt.
            System.out.println("Truck " + truckNumber + ": wil container ophalen.");
            container = dock.loadOnTruck();
            System.out.println("Truck " + truckNumber + ": container " + container.getContainerid() + " opgehaald...wegrijden");
            try{
                Thread.sleep(10000);
            }
            catch(InterruptedException e){}
        }
    }
}
