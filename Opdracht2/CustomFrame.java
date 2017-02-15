
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

    /**
    *Constructor
    */
    public CustomFrame(){
        MyMouse x = new MyMouse();
        setLayout(new java.awt.GridLayout(4,3));
        setSize(600,400);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //initialiseer componenten
        info = new JLabel("Format : dd-MMM-yyyy");
        bday1Input = new JTextField(11);
        bday2Input = new JTextField(11);
        output  = new JLabel("");
        calculateAge = new JButton("Calcate your age");
        calculateDifference = new JButton("Calculate the difference between 2 dates");
        calculateAge.addMouseListener(x);
        calculateDifference.addMouseListener(x);
        calculateAge.setBackground(Color.gray);
        calculateAge.setForeground(Color.red);
        calculateAge.setOpaque(true);

        calculateDifference.setBackground(Color.gray);
        calculateDifference.setForeground(Color.red);
        calculateDifference.setOpaque(true);

        differenceList = new JComboBox<String>(StringList);
        output = new JLabel();
        output.setOpaque(true);
        output.setForeground(Color.blue);

        add(output);
        add(differenceList);
        add(bday1Input);
        add(bday2Input);
        add(calculateAge);
        add(calculateDifference);
        add(info);

        setVisible(true);
        }

    private class MyMouse extends MouseAdapter{

        public void mouseClicked(MouseEvent e){

            int i = 0;
            String eenheid = differenceList.getSelectedItem().toString();

            if(eenheid == "Seconds"){
                i = 1;
            }
            if(eenheid == "Minutes"){
                i = 2;
            }
            if(eenheid == "Hours"){
                i = 3;
            }
            if(eenheid == "Days"){
                i = 4;
            }
            if(eenheid == "Years"){
                i = 5;
            }

            if(e.getSource() == calculateAge){
                birthDay1String = bday1Input.getText();
                solution = Calculations.calculateAge(birthDay1String, i);
                output.setText(solution);

            }
            else if(e.getSource() == calculateDifference){
                birthDay1String = bday1Input.getText();
                birthDay2String = bday2Input.getText();
                solution = Calculations.calculateDifference(birthDay1String, birthDay2String, i);
                output.setText(solution);
            }
        }
    }
}
