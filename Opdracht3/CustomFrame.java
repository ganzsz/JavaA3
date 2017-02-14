

import javax.swing.*;
import java.awt.event.*;
import java.text.ParseException;
import java.awt.*;

public class CustomFrame extends JFrame{
    private JLabel time;
    private JButton start;
    private JButton pause;
    private JButton reset;
    private JFrame f;
    private String solution;
    public boolean counter;
    TimerThread stopwatch;
    MyMouse x;

    /**
    *Constructor
    */
    public CustomFrame(){
        x = new MyMouse();
        stopwatch = new TimerThread();
        counter = false;
        setLayout(new java.awt.GridLayout(4,3));
        setSize(600,400);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //initialiseer componenten
        time  = new JLabel();
        start = new JButton("START");
        pause = new JButton("PAUSE");
        reset = new JButton("RESET");
        start.addMouseListener(x);
        pause.addMouseListener(x);
        reset.addMouseListener(x);


        add(time);
        add(start);
        add(reset);

        setVisible(true);
        }

        public void update(){
            time.setText(Long.toString(stopwatch.difference));
        }

    private class MyMouse extends MouseAdapter{

        public void mouseClicked(MouseEvent e ){

            if(e.getSource() == start){
                stopwatch.start();

            }

            if(e.getSource() == reset){
                stopwatch.interrupt();
            }
        }
    }
}
