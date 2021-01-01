package gui;

import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;

class ComboBoxFrame extends JFrame
{
    private JComboBox imageJComboBox;
    private JLabel label;

    private String names[] =
            {"bug1.gif", "bug2.gif", "bug3.gif", "bug4.gif"};

    private JLabel icons[] = {
            new JLabel("bug1.gif"),
            new JLabel("bug2.gif"),
            new JLabel("bug3.gif"),
            new JLabel("bug4.gif")
    };

    public ComboBoxFrame()
    {
        super("Testing JComboBox");
        setLayout(new FlowLayout());

        imageJComboBox = new JComboBox(names);
        imageJComboBox.setMaximumRowCount(3);

        /*
        imageJComboBox.addItemListener(
                event -> {
                    if(event.getStateChange() == ItemEvent.SELECTED)
                    {
                        label.setText(names[imageJComboBox.getSelectedIndex()]);
                    }
                }
        );
        
         */



        imageJComboBox.addItemListener(
                new ItemListener()
                {
                    public void itemStateChanged(ItemEvent event)
                    {
                        if(event.getStateChange() == ItemEvent.SELECTED)
                        {
                            label.setText(names[imageJComboBox.getSelectedIndex()]);
                        }
                    }
                }
        );
        add(imageJComboBox);
        label = new JLabel(names[0]);
        add(label);
    }

}

public class ComboBox {
    public static void main(String args[]) {
        ComboBoxFrame frame = new ComboBoxFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 150);
        frame.setVisible(true);
    }
}