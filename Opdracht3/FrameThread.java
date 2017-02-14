
import javax.swing.*;
import java.awt.event.*;
import java.text.ParseException;
import java.awt.*;

public class FrameThread extends Thread{

    private JLabel time;
    private JButton start;
    private JButton pause;
    private JButton reset;
    private JFrame f;
    private String solution;
    public boolean counter;
    TimerThread stopwatch;
    MyMouse x;

    public FrameThread(){
        f = new JFrame("Assignment 3");
        x = new MyMouse();
        stopwatch = new TimerThread();
        f.setLayout(new java.awt.GridLayout(4,3));
        f.setSize(600,400);
        f.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //initialiseer componenten
        time  = new JLabel();
        start = new JButton("START");
        pause = new JButton("PAUSE");
        reset = new JButton("RESET");
        start.addMouseListener(x);
        pause.addMouseListener(x);
        reset.addMouseListener(x);
        counter = false;

        f.add(time);
        f.add(start);
        f.add(reset);

        f.setVisible(true);
        }

    public void run(){
        while(stopwatch.difference < 10000)
        time.setText(Long.toString(stopwatch.difference));
    }

    private class MyMouse extends MouseAdapter{

        public void mouseClicked(MouseEvent e ){

            if(e.getSource() == start){

                stopwatch.start();

            }

            if(e.getSource() == reset){
                try{
                stopwatch.sleep(2000);
                }

                catch(InterruptedException error){
                }
            }
        }
    }
}
