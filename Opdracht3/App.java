import javax.swing.*;
import java.awt.event.*;

public class App{

    private static JButton startStop;
    private static JButton reset;
    private static boolean alive;
    private static boolean pause;
    private static boolean startOrStop;
    private static JLabel display;
    private static Thread countdown;

    public static void main(String [] args){
        startOrStop = true;
        alive = true;
        pause = true;

        //interface
        JFrame frame = new JFrame("assignment 3");
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new java.awt.FlowLayout());
        startStop = new JButton("START/PAUSE");
        reset = new JButton("RESET");
        display = new JLabel("00:00:00");
        JPanel buttonPanel = new JPanel();
        JPanel timerPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
        timerPanel.setLayout(new BoxLayout(timerPanel, BoxLayout.PAGE_AXIS));
        buttonPanel.add(startStop);
        buttonPanel.add(reset);
        timerPanel.add(display);
        frame.add(buttonPanel);
        frame.add(timerPanel);
        frame.setVisible(true);

        startStop.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent evt)
            {
                buttonPressed(evt);
            }
        });
        reset.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent evt)
            {
                buttonPressed(evt);
            }
        });
        countdown = new Thread(){
            public void run(){
                long time = 0;
                while(!Thread.currentThread().isInterrupted()) {
                    while(pause == false){
                        long startTime = System.currentTimeMillis();
                        while(time < 90000){
                            time = System.currentTimeMillis() - startTime;
                            //System.out.println(time);
                            display.setText(Long.toString(time));
                        }
                    }
                }
            }
        };
    countdown.start();
}

    private static void buttonPressed(MouseEvent e){
        if(e.getSource() == startStop){
            pause = false;
            System.out.println(pause);
        }
        if(e.getSource() == reset){
            pause = true;
            System.out.println(pause);

        }
    }
}
