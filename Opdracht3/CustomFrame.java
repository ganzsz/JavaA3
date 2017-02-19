import javax.swing.*;
import java.awt.event.*;
public class CustomFrame extends JFrame {
    private String [] laps;
    private boolean lapTimeRecord;
    private boolean reset;
    private boolean pause;
    private boolean startOrStop;
    private JButton startStop;
    private JButton resetButton;
    private JButton laptimeButton;
    private JPanel buttonPanel;
    private JPanel timerPanel;
    private DefaultListModel<String> lapModel;
    private JList<String> lapTime;

    public CustomFrame(){
        pause = true;
        lapModel = new DefaultListModel<String>();
        lapTime = new JList<String>(lapModel);
        //interface
        buttonPanel = new JPanel();
        timerPanel = new JPanel();
        startStop = new JButton("START/PAUSE");
        laptimeButton = new JButton("LAPTIME");
        resetButton = new JButton("RESET");
        setSize(300,200);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLayout(new java.awt.FlowLayout());
        setTitle("Assignment 3");
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
        timerPanel.setLayout(new BoxLayout(timerPanel, BoxLayout.PAGE_AXIS));
        buttonPanel.add(startStop);
        buttonPanel.add(laptimeButton);
        buttonPanel.add(resetButton);
        timerPanel.add(lapTime);
        add(buttonPanel);
        add(timerPanel);
        setVisible(true);
        for(int i = 0; i < 7; i++){
            lapModel.addElement("00:00:00.000");
        }
        lapModel.setElementAt("Laptimes", 1);
        //buttonlisteners
        startStop.addMouseListener(new MouseAdapter()
        {
            public void mouseReleased(MouseEvent evt)
            {
                reset = false;
                pause = !pause;
                System.out.println(pause);
            }
        });
        resetButton.addMouseListener(new MouseAdapter()
        {
            public void mouseReleased(MouseEvent evt)
            {
                reset = true;
                System.out.println(pause);;
            }
        });
        laptimeButton.addMouseListener(new MouseAdapter()
        {
            public void mouseReleased(MouseEvent evt)
            {
                lapTimeRecord = true;
                System.out.println(pause);
            }
        });
    }
    public String getLapModel(int i){
        return lapModel.getElementAt(i);
    }
    public void setLapModel(String x, int i){
        lapModel.setElementAt(x, i);
    }
    public boolean getReset(){
        return reset;
    }
    public void setReset(boolean reset){
        this.reset = reset;
    }
    public boolean getPause(){
        return pause;
    }
    public void setPause(boolean pause){
        this.pause = pause;
    }
    public boolean getLapTimeRecord(){
        return lapTimeRecord;
    }
    public void setLapTimeRecord(boolean lapTimeRecord){
        this.lapTimeRecord = lapTimeRecord;
    }
}
