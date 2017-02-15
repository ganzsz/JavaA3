public class CounterThread extends Thread{
    public long time = 0;

    public void run(){
        boolean pause = false;
        time = 0;
        long timeStart;
        while (!Thread.currentThread().isInterrupted()) {
            if(pause == false){
                timeStart = System.currentTimeMillis();
                while(time < 60000 ){
                    time = System.currentTimeMillis() - timeStart;
                    //System.out.println(time);
                    if(time == 5000){
                        pause = true;
                        break;
                    }
                }
                while(pause){
                    System.out.println("DER UUT");
                    time = 0;
                    System.out.println(time);
                    pause = false;
                    break;
                }
            }
        }
    }
}
