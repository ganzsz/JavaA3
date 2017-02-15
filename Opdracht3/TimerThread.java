public class TimerThread extends Thread{

    public long difference;
    public boolean reset;
    long starttime;

    public TimerThread(){
        reset = true;
        difference = 0;
    }

    public void run(){
        while(difference < 900000){
            starttime = System.currentTimeMillis();
            while(reset == false){
                System.out.println(reset);
                difference = System.currentTimeMillis() - starttime;
                //System.out.println(difference);
            }
            while(reset == true){
                difference = 0;
            }
        }
    }
}
