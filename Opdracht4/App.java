import java.util.Random;

public class App{
    public static void main(String [] args) throws InterruptedException {
        Dock dock = new Dock();
        Ship ship = new Ship();
        Crane crane1 = new Crane(ship, dock, 1);
        Crane crane2 = new Crane(ship, dock, 2);
        crane1.start();
        crane2.start();

        try{
            crane1.join();
            crane2.join();
        }
        catch(InterruptedException e){}
    }
}
