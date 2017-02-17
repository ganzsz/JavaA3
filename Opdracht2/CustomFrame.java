import javax.swing.*;
import java.awt.event.*;
import java.text.ParseException;
import java.awt.*;

/**
* @author Tommie Terhoeve
* @version 1.0
* Deze classe is voor het initialiseren van frame objecten.
*/
public class CustomFrame extends JFrame {
    private JTextField bday1Input;
    private JTextField bday2Input;
    private JLabel output;
    private JLabel info;
    private JButton calculateAge;
    private JButton calculateDifference;
    private String [] StringList = {"Milliseconds", "Seconds", "Minutes" , "Hours", "Days", "Years"};
    private JComboBox <String> differenceList;
    private int i;
    private String birthDay1String;
    private String birthDay2String;
    private JFrame f;
    private String solution;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JPanel inputPanel;
    /**
    *Constructor
    */
    public CustomFrame(){
        MyMouse x = new MyMouse();
        setLayout(new java.awt.FlowLayout());
        setSize(300,300);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Assignment 2");
        //initialiseer componenten
        info = new JLabel("Format : dd MM yyyy");
        bday1Input = new JTextField(11);
        bday2Input = new JTextField(11);
        output  = new JLabel("Welcome to the Date Calculator");
        calculateAge = new JButton("Calcate your age");
        calculateDifference = new JButton("Calculate the difference between 2 dates");
        topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.PAGE_AXIS));
        inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.PAGE_AXIS));
        calculateAge.addMouseListener(x);
        calculateDifference.addMouseListener(x);
        differenceList = new JComboBox<String>(StringList);
        topPanel.add(differenceList);
        inputPanel.add(bday1Input);
        inputPanel.add(bday2Input);
        bottomPanel.add(calculateAge);
        bottomPanel.add(calculateDifference);
        bottomPanel.add(info);
        bottomPanel.add(output);
        add(topPanel);
        add(inputPanel);
        add(bottomPanel);
        setVisible(true);
        }

    private class MyMouse extends MouseAdapter{
        public void mouseReleased(MouseEvent e){
            if(e.getSource() == calculateAge){
                birthDay1String = bday1Input.getText();
                solution = Calculations.calculateAge(birthDay1String, differenceList.getSelectedIndex());
                output.setText(solution);
            }
            else if(e.getSource() == calculateDifference){
                birthDay1String = bday1Input.getText();
                birthDay2String = bday2Input.getText();
                solution = Calculations.calculateDifference(birthDay1String, birthDay2String, differenceList.getSelectedIndex());
                output.setText(solution);
            }
        }
    }
}
