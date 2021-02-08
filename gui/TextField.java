//package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JButton;


class TextFieldFrame extends JFrame
{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JButton computeJButton;
    private JButton resetJButton;

    public TextFieldFrame()
    {
        super("Testing JTextField nad JPasswordField");
        setLayout(new FlowLayout());

        label1 = new JLabel("Length:   ");
        add(label1);
        textField1 = new JTextField(10);
        add(textField1);

        label2 = new JLabel("Breadth:  ");
        add(label2);
        textField2 = new JTextField(10);
        add(textField2);

        label3 = new JLabel("Area:     ");
        add(label3);
        textField3 = new JTextField(10);
        add(textField3);

        label4 = new JLabel("Perimeter:");
        add(label4);
        textField4 = new JTextField(10);
        add(textField4);

        computeJButton = new JButton("Compute");
        add(computeJButton);

        TextFieldHandler handler = new TextFieldHandler();
        textField1.addActionListener(handler);
        textField2.addActionListener(handler);
        textField3.addActionListener(handler);
        textField4.addActionListener(handler);


    }

    private class TextFieldHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            System.out.println(event.getID());
            String string = "";

            if(event.getSource() == textField1)
            {
                string = String.format("textField1: %s", event.getActionCommand());
            }

            else if(event.getSource() == textField2)
            {
                string = String.format("textField2: %s",event.getActionCommand());
            }
            else if(event.getSource()==textField3)
            {
                string = String.format("textField3: %s",event.getActionCommand());
            }
            else if(event.getSource() == textField4)
            {
                string = String.format("passWordField: %s",event.getActionCommand());
            }

            JOptionPane.showMessageDialog(null, string);
        }
    }
}

public class TextField
{
    public static void main(String args[])
    {
        TextFieldFrame frame = new TextFieldFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200,200);
        frame.setVisible(true);
    }
}