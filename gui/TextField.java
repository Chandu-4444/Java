package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

class TextFieldFrame extends JFrame
{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JPasswordField passwordField;

    public TextFieldFrame()
    {
        super("Testing JTextField nad JPasswordField");
        setLayout(new FlowLayout());

        textField1 = new JTextField(10);
        add(textField1);

        textField2 = new JTextField("Enter your text here");
        add(textField2);

        textField3 = new JTextField("Uneditable text field", 21);
        textField3.setEditable(false);
        add(textField3);

        passwordField = new JPasswordField("Hiddden Text");
        add(passwordField);

        TextFieldHandler handler = new TextFieldHandler();
        textField1.addActionListener(handler);
        textField2.addActionListener(handler);
        textField3.addActionListener(handler);
        passwordField.addActionListener(handler);


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
            else if(event.getSource() == passwordField)
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
        System.out.println(frame.getClass().getMethods().length);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350,100);
        frame.setVisible(true);
    }
}