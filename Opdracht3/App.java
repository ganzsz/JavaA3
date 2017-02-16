import javax.swing.*;
import java.awt.event.*;

public class App{

    private static int lapCounter;
    private static String [] laps;
    private static boolean reset;
    private static boolean pause;
    private static boolean startOrStop;
    private static JButton startStop;
    private static JButton resetButton;
    private static JPanel buttonPanel;
    private static JPanel timerPanel;

    public static void main(String [] args){
        DefaultListModel<String> lapModel = new DefaultListModel<String>();
        JList<String> lapTime = new JList<String>(lapModel);
        lapCounter = 2;
        laps = new String[6];
        for(int i = 0; i < 7; i++){
            lapModel.addElement("00:00:00");
        }
        lapModel.setElementAt("Laptimes", 1);
        startOrStop = true;
        pause = true;
        reset = false;
        //interface
        JFrame frame = new JFrame("assignment 3");
        buttonPanel = new JPanel();
        timerPanel = new JPanel();
        startStop = new JButton("START/PAUSE");
        resetButton = new JButton("RESET");
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new java.awt.FlowLayout());
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
        timerPanel.setLayout(new BoxLayout(timerPanel, BoxLayout.PAGE_AXIS));
        buttonPanel.add(startStop);
        buttonPanel.add(resetButton);
        timerPanel.add(lapTime);
        frame.add(buttonPanel);
        frame.add(timerPanel);
        frame.setVisible(true);
        //buttonlisteners
        startStop.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent evt)
            {
                buttonPressed(evt);
            }
        });
        resetButton.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent evt)
            {
                buttonPressed(evt);
            }
        });
        //thread for the stopwatch.
        new Thread(){
            public void run(){
                long time = 0;
                while(!Thread.currentThread().isInterrupted()) {
                    while(pause == false){
                        long startTime = System.currentTimeMillis();
                        while(time < 90000){
                            time = System.currentTimeMillis() - startTime;
                            //System.out.println(time);
                            lapModel.setElementAt(Long.toString(time), 0);

                            if(reset){
                                if(lapCounter < 7){
                                    lapModel.setElementAt(Long.toString(time), lapCounter);
                                    lapCounter++;
                                    reset = false;
                                }
                                else{
                                    lapCounter = 2;
                                    lapModel.setElementAt(Long.toString(time), lapCounter);
                                    lapCounter++;
                                    reset = false;
                                }
                                pause = true;
                                break;
                            }
                            if(pause){

                            }
                        }
                    }
                }
            }
        }.start();

}

    private static void buttonPressed(MouseEvent e){
        if(e.getSource() == startStop){
            reset = false;
            pause = false;
            System.out.println(pause);
        }
        if(e.getSource() == resetButton){
            reset = true;
            System.out.println(pause);

        }
    }
}
