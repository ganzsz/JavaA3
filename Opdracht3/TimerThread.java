public class TimerThread extends Thread{

    public long difference;
    public boolean pause;
    public void run(){

    long starttime = System.currentTimeMillis();
        while(difference < 20000){
                difference = System.currentTimeMillis() - starttime;
                System.out.println(difference);
            }
    }
}
