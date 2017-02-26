import java.util.Random;
public class Crane extends Thread{
    private Ship ship;
    private Container container;
    private Dock dock;
    private int craneNumber;
    Random rnd = new Random();
    public Crane(Ship ship, Dock dock, int craneNumber){
        this.ship = ship;
        this.dock = dock;
        this.craneNumber = craneNumber;
    }
    public void run(){
        try{
            for(int i = 0; i < 100; i++){
                System.out.println("Kraan " + craneNumber + " wil container halen");
                int getContainerTime = rnd.nextInt(5000) + 1000;
                Crane.sleep(getContainerTime);
                container = ship.getContainer();
                System.out.println("Kraan " + craneNumber + " Container" + ship.getContainerID() + " opgehaald...overladen");
                dock.placeContainer(container, ship.getContainerID());
            }
        }
        catch(InterruptedException e){
        }
    }
}
