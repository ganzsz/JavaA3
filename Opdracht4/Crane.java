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
            System.out.println("Kraan " + craneNumber + " : Container " + container.getContainerid() + " opgehaald...overladen");
            System.out.println("Kraan " + craneNumber + " : wil container " + container.getContainerid() + " plaatsen");
            dock.placeContainer(container);
            try{
                dock.cranesSleeping++;
                sleep(getContainerTime);
                dock.cranesSleeping--;
            }
            catch(InterruptedException e){}
        }
    }
}
