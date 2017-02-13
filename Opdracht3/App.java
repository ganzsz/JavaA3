public class App{

    public static void main(String [] args) throws InterruptedException{

        TimerThread x = new TimerThread();
        x.run();
        System.out.println(x.getDifference());
        x.sleep(1000);

    }
}
