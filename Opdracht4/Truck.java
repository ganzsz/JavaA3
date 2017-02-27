import java.util.Random;
public class Truck extends Thread{
    private Container container;
    private Dock dock;
    private int truckNumber;
    private int getContainerTime;
    Random rnd = new Random();
    public Truck(Dock dock, int truckNumber){
        this.dock = dock;
        this.truckNumber = truckNumber;
    }
    public void run(){
        try{
            for(int i = 0; i < 100; i++){
                getContainerTime = rnd.nextInt(60000) + 5000; //staat niet duidelijk in de opdracht hoe lang het maximaal duurt.
                System.out.println("Truck " + truckNumber + ": wil container ophalen.");
                container = dock.loadOnTruck();
                Truck.sleep(60000);
                if(container == null){
                    System.out.println("Geen containers");
                }
                else{
                    System.out.println("Truck " + truckNumber + ": container " + container.getContainerid() + " opgehaald...wegrijden");
                }
            }
        }
        catch(InterruptedException e){}
    }
}
