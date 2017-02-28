public class App{
    public static void main(String [] args) throws InterruptedException {
        Dock dock = new Dock();
        Ship ship = new Ship();
        Crane [] crane = new Crane[2];
        Truck [] truck = new Truck[3];
        for(int i = 0; i < crane.length; i++){
            crane[i] = new Crane(ship,dock,i+1);
            crane[i].start();
        }
        for(int i = 0; i < truck.length; i++){
            truck[i] = new Truck(dock,i+1);
            truck[i].start();
        }
    }
}
