import javax.swing.*;
import java.awt.event.*;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class App{
    private static LocalTime temp = LocalTime.MIN;
    private static LocalTime baseTime = LocalTime.MIN;
    private static int counter = 2;
    private static boolean pauseCounter;
    private static long startTime;
    private static long pauseTime;
    private static long pauseDuration1;
    private static long pauseDuration2;
    private static long currentTime;
    private static long difference;
    public static void main(String [] args){
        CustomFrame x = new CustomFrame();
        new Thread(){
            public void run(){
                while(!Thread.currentThread().isInterrupted()) {
                    startTime = System.currentTimeMillis();
                    while(!x.pause){
                        if(pauseCounter){
                            pauseDuration2 += pauseDuration1;
                            pauseCounter = false;
                        }
                        calculateTime(x);
                        if(x.reset){
                            resetAction(x);
                            break;
                        }
                        if(x.lapTimeRecord){
                            lapTimeAction(x);
                        }
                        if(x.pause){
                            pauseTime = System.currentTimeMillis();
                        }
                        while(x.pause){
                            if(x.reset){
                                resetAction(x);
                                break;
                            }
                            if(x.lapTimeRecord){
                                lapTimeAction(x);
                            }
                            pauseDuration1 = System.currentTimeMillis() - pauseTime;
                            pauseCounter = true;
                            System.out.println(pauseDuration2);
                        }
                    }
                }
            }
        }.start();
    }
    public static void resetAction(CustomFrame x){
        temp = LocalTime.MIN;
        x.lapModel.setElementAt(temp.toString(), 0);
        pauseDuration2 = 0;
        x.reset = false;
        //x.pause = true;
    }
    public static void lapTimeAction(CustomFrame x){
        x.lapTimeRecord = false;
        x.pause = true;
        x.lapModel.setElementAt(temp.toString(),counter);
        x.lapTimeRecord = false;
        if(counter == 6){
            counter = 2;
        }
        else{
            counter++;
        }
    }
    public static void calculateTime(CustomFrame x){
            currentTime = System.currentTimeMillis();
            temp = baseTime.plus(currentTime - pauseDuration2 - startTime, ChronoUnit.MILLIS);
            x.lapModel.setElementAt(temp.toString(), 0);
    }
}
