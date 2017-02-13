public class TimerThread extends Thread{

    private long difference;

    public void run(){
        long starttime = System.currentTimeMillis();
        difference = System.currentTimeMillis() - starttime;

        try{

            while(difference < 9999){

                difference = System.currentTimeMillis() - starttime;
                System.out.println(difference);
            }

            throw new InterruptedException();
        }

        catch (InterruptedException e){
            System.out.println("Doe iets anders");
            }
    }

    public void sleep(){

        try{
            throw new InterruptedException();
    }

        catch(InterruptedException e){
        }
    }

    public long getDifference(){
        return difference;
    }

}
