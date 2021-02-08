//package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

class ButtonFrame extends JFrame
{
    private JButton plainJButton;
    private JButton fancyJButton;

    public ButtonFrame()
    {
        super("Testing Buttons");
        setLayout(new FlowLayout());

        plainJButton = new JButton("Plain Button");
        add(plainJButton);

        ImageIcon bug1 = new ImageIcon(getClass().getResource("correct.png"));
        Icon bug2 = new ImageIcon(getClass().getResource("cross.png"));

        fancyJButton = new JButton("Fancy Button", bug1);
        fancyJButton.setRolloverIcon(bug2);
        add(fancyJButton);

        ButtonHandler handler = new ButtonHandler();
        fancyJButton.addActionListener(handler);
        plainJButton.addActionListener(handler);


    }
    private class ButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            JOptionPane.showMessageDialog(ButtonFrame.this, String.format("You pressed: %s",event.getActionCommand()));
        }
    }
}

public class ButtonTest
{
    public static void main(String args[])
    {
        ButtonFrame frame = new ButtonFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(275, 210);
        frame.setVisible(true);
    }
}