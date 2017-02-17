import javax.swing.*;
import java.awt.event.*;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class App{
    public static void main(String [] args){
        CustomFrame x = new CustomFrame();
        new Thread(){
            public void run(){
                while(!Thread.currentThread().isInterrupted()) {
                    while(x.pause == false){
                        long time = 0;
                        LocalTime startTime = LocalTime.now();
                        while(time < 90000){
                            LocalTime countTime = LocalTime.now();
                            time = startTime.until(countTime, ChronoUnit.MILLIS);
                            x.lapModel.setElementAt(Long.toString(time), 0);
                            if(x.reset){
                                x.lapModel.setElementAt("00:00:00", 0);
                                x.reset = false;
                                x.pause = true;
                                break;
                            }
                        }
                    }
                }
            }
        }.start();
    }
}
