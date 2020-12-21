package gui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

class CheckBoxFrame extends JFrame
{
    private JTextField textField;
    private JCheckBox boldJCheckBox;
    private JCheckBox italicJCheckBox;

    public CheckBoxFrame()
    {
        super("JCheckBox Test");
        setLayout(new FlowLayout());

        textField = new JTextField("Watch the font style change", 20);
        textField.setFont(new Font("Serif", Font.PLAIN, 14));
        add(textField);

        boldJCheckBox = new JCheckBox("Bold");
        add(boldJCheckBox);
        italicJCheckBox = new JCheckBox("italic");
        add(italicJCheckBox);

        CheckBoxHandler handler = new CheckBoxHandler();
        boldJCheckBox.addItemListener(handler);
        italicJCheckBox.addItemListener(handler);
    }

    private class CheckBoxHandler implements ItemListener
    {
        private int valBold = Font.PLAIN;
        private int valItalic = Font.PLAIN;

        public void itemStateChanged(ItemEvent event)
        {
            if(event.getSource() == boldJCheckBox)
            {
                valBold = boldJCheckBox.isSelected()? Font.BOLD : Font.PLAIN;
            }
            if(event.getSource() == italicJCheckBox)
            {
                valItalic = italicJCheckBox.isSelected()?Font.ITALIC : Font.PLAIN;
            }

            textField.setFont(new
                    Font("Serif", valBold + valItalic,14));
        }
    }
}

public class CheckBox
{
    public static void main(String args[])
    {
        CheckBoxFrame frame = new CheckBoxFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(275, 100);
        frame.setVisible(true);
    }
}