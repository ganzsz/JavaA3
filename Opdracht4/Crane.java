import java.util.Random;
public class Crane extends Thread{
    private Ship ship;
    private Container container;
    private Dock dock;
    private int craneNumber;
    private int getContainerTime;
    private Random rnd;
    public Crane(Ship ship, Dock dock, int craneNumber){
        this.ship = ship;
        this.dock = dock;
        this.craneNumber = craneNumber;
    }
    public void run(){
        rnd = new Random();
        getContainerTime = rnd.nextInt(5000) + 1000;
        while(!ship.isEmpty()){
            System.out.println("Kraan " + craneNumber + " : wil container halen");
            container = ship.getContainer();
            dock.placeContainer(container, craneNumber);
            try{
                sleep(getContainerTime);
                dock.editCranesSleeping("--");
            }
            catch(InterruptedException e){}
        }
    }
}
