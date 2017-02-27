import java.util.Random;
public class Crane extends Thread{
    private Ship ship;
    private Container container;
    private Dock dock;
    private int craneNumber;
    private int getContainerTime;
    Random rnd = new Random();
    public Crane(Ship ship, Dock dock, int craneNumber){
        this.ship = ship;
        this.dock = dock;
        this.craneNumber = craneNumber;
    }
    public void run(){
        try{
            for(int i = 0; i < 100; i++){
                System.out.println("Kraan " + craneNumber + " : wil container halen");
                getContainerTime = rnd.nextInt(5000) + 1000;
                Crane.sleep(getContainerTime);
                container = ship.getContainer();
                System.out.println("Kraan " + craneNumber + " : Container " + container.getContainerid() + " opgehaald...overladen");
                System.out.println("Kraan " + craneNumber + " : wil container " + container.getContainerid() + " plaatsen");
                dock.placeContainer(container);
            }
        }
        catch(InterruptedException e){}
    }
}
