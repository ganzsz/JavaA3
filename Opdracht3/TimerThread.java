public class TimerThread extends Thread{

    public long difference;
    public boolean pause;
    private boolean stop;
    public void run(){

    long starttime = System.currentTimeMillis();
        while(difference < 1000000){
        try{
            difference = System.currentTimeMillis() - starttime;
            System.out.println(difference);
            if(difference > 90000){
                throw new InterruptedException();
            }
        }
        catch(InterruptedException e){
            System.out.println("EXIT PROGRAM");
            break;
        }
    }
}

    public void sleep(){
        while(difference < 1000000){
        }
    }
}
