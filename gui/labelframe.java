//package gui;

import javax.swing.*;
import java.awt.FlowLayout;


class LabelFrame extends JFrame
{
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;

    public LabelFrame()
    {

        super("Testing JLabel");
        setLayout(new FlowLayout());

        label1 = new JLabel("Label with Text");
        label1.setToolTipText("This is label1");
        add(label1);

        Icon bug = new ImageIcon(getClass().getResource("ym.png"));
        label2 = new JLabel("Label with text and icon",bug,SwingConstants.LEFT);
        label2.setToolTipText("This is label2");
        add(label2);
        //System.out.println(getClass().getResource("ym.png"));

        label3 = new JLabel();
        label3.setText("Label with icon and text at bottom");
        label3.setIcon(bug);
        label3.setHorizontalTextPosition(SwingConstants.CENTER);
        label3.setVerticalTextPosition(SwingConstants.BOTTOM);
        label3.setToolTipText("This is label3");
        add(label3);
    }
}

public class labelframe{
    public static void main(String args[])
    {
        JFrame fr = new JFrame("Test");
        fr.setLayout(new FlowLayout());
        JLabel lab = new JLabel("Hello!");
        lab.setToolTipText("Hello!");
        fr.add(lab);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(275, 180);
        fr.setVisible(true);
//        String val1 = JOptionPane.showInputDialog("Enter message: ");
//        JOptionPane.showMessageDialog(null, val1,"Information Message",JOptionPane.INFORMATION_MESSAGE);
//        JOptionPane.showMessageDialog(null, val1,"Error Message",JOptionPane.ERROR_MESSAGE);
//        JOptionPane.showMessageDialog(null, val1,"Warning Message",JOptionPane.WARNING_MESSAGE);
//        JOptionPane.showMessageDialog(null, val1,"Question Message",JOptionPane.QUESTION_MESSAGE);
//        JOptionPane.showMessageDialog(null, val1,"Plain Message",JOptionPane.PLAIN_MESSAGE);

        LabelFrame frame = new LabelFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(275, 180);
        frame.setVisible(true);



    }
}