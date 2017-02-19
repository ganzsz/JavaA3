import javax.swing.*;
import java.awt.event.*;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class App{
    private static LocalTime displayTime = LocalTime.MIN;
    private static LocalTime baseTime = LocalTime.MIN;
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
                    while(!x.getPause()){
                        if(pauseCounter){
                            pauseDuration2 += pauseDuration1;
                            pauseCounter = false;
                        }
                        calculateTime(x);
                        if(x.getReset()){
                            resetAction(x);
                            break;
                        }
                        if(x.getLapTimeRecord()){
                            lapTimeAction(x);
                        }
                        if(x.getPause()){
                            pauseTime = System.currentTimeMillis();
                        }
                        while(x.getPause()){
                            if(x.getReset()){
                                resetAction(x);
                                break;
                            }
                            if(x.getLapTimeRecord()){
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
        displayTime = LocalTime.MIN;
        pauseTime = 0;
        pauseDuration1 = 0;
        pauseDuration2 = 0;
        x.setLapModel("00:00:00.000", 0);
        x.setPause(true);
        x.setReset(false);
    }
    public static void lapTimeAction(CustomFrame x){
        String [] temp = new String[4];
        for(int i = 0;  i < temp.length; i++){
            temp[i] = x.getLapModel(i+2);
        }
        for(int i = 0;  i < temp.length; i++){
            x.setLapModel(displayTime.toString(), 2);
            x.setLapModel(temp[i], i + 3);
        }
        x.setPause(true);
        x.setLapTimeRecord(false);
    }
    public static void calculateTime(CustomFrame x){
            currentTime = System.currentTimeMillis();
            displayTime = baseTime.plus(currentTime - pauseDuration2 - startTime, ChronoUnit.MILLIS);
            x.setLapModel(displayTime.toString(), 0);
    }
}
