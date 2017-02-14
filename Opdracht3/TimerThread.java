public class TimerThread extends Thread{

    public long difference;
    public boolean pause;
    public void run(){

    long starttime = System.currentTimeMillis();

        while(difference < 200000000){
            try{
                difference = System.currentTimeMillis() - starttime;
                System.out.println(difference);
                if(pause){
                    throw new InterruptedException();
                }
            }
            catch(InterruptedException e){
                difference = 0;
                break;
            }
        }
    }
}
