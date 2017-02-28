import java.util.Random;
public class Crane extends Thread{
    private Ship ship;
    private Container container;
    private Dock dock;
    private int craneNumber;
    private int getContainerTime;
    private Random rnd = new Random();
    public Crane(Ship ship, Dock dock, int craneNumber){
        this.ship = ship;
        this.dock = dock;
        this.craneNumber = craneNumber;
    }
    public void run(){
            for(int i = 0; i < 100; i++){
                container = ship.getContainer();
                System.out.println("Kraan " + craneNumber + " : Container " + container.getContainerid() + " opgehaald...overladen");
                try{
                    sleep(3000);
                }
                catch(InterruptedException e){}
                System.out.println("Kraan " + craneNumber + " : wil container " + container.getContainerid() + " plaatsen");
                dock.placeContainer(container);
            }
    }
}
