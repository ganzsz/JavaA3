import javax.swing.*;
import java.awt.event.*;
public class CustomFrame extends JFrame {
    private String [] laps;
    public boolean reset;
    public boolean pause;
    private boolean startOrStop;
    private JButton startStop;
    private JButton resetButton;
    private JButton laptimeButton;
    private JPanel buttonPanel;
    private JPanel timerPanel;
    public DefaultListModel<String> lapModel;
    public JList<String> lapTime;

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
            lapModel.addElement("00:00:00");
        }
        lapModel.setElementAt("Laptimes", 1);
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
    }
    private void buttonPressed(MouseEvent e){
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
