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
        for(int i = 0; i < 100; i++){
             dock.loadOnTruck();
             try{
                 sleep(5000);
             }
             catch(InterruptedException e){}
        }
    }
}
