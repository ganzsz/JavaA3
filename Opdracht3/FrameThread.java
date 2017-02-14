
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
    private boolean counter;
    private TimerThread stopwatch;
    private MyMouse x;
    private boolean stop;

    public FrameThread(){
        stop = false;
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
        while(stopwatch.difference < 1000000)
        time.setText(Long.toString(stopwatch.difference));
    }

    private class MyMouse extends MouseAdapter{

        public void mouseClicked(MouseEvent e ){

            if(e.getSource() == start){

                stopwatch.start();

            }

            if(e.getSource() == reset){
                stop = true;
            }
        }
    }
}
