

public class FrameThread extends Thread{

    public void run(){

        CustomFrame i = new CustomFrame();
        while(i.counter == false){

        i.update();
        }
    }
}
