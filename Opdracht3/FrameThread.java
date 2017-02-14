

public class FrameThread extends Thread{

    public void run(){

        CustomFrame i = new CustomFrame();
        i.update();
    }
}
