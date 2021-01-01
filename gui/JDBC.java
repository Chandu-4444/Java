package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;


    class credentialHandler implements ActionListener
    {
        private JTextField userName;
        private JPasswordField userPassword;
        private JButton submitButton;
        private JFrame frame;
        private JLabel userLabel;
        private JLabel passwordLabel;
        Connection conn;

        public void CreateUI()
        {
            frame = new JFrame("Credentials");

            userLabel =  new JLabel("Username: ");
            frame.add(userLabel);

            userName = new JTextField(10);
            frame.add(userName);

            passwordLabel = new JLabel("Password: ");
            frame.add(passwordLabel);

            userPassword = new JPasswordField(10);
            frame.add(userPassword);

            submitButton = new JButton("Submit");
            frame.add(submitButton);

            //credentialHandler handler = new credentialHandler();
            submitButton.addActionListener(this);

            frame.setLayout(new FlowLayout());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(200,200);
            frame.setVisible(true);

        }

        public void actionPerformed(ActionEvent event)
        {

            if(event.getSource() == submitButton)
            {

                try {

                   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", userName.getText(), String.valueOf(userPassword.getPassword()));
                    Statement stm = conn.createStatement();
                    ResultSet db = stm.executeQuery("show databases");
                    String dbstr="";
                    submitButton= (JButton)event.getSource();
                    frame.dispose();
                    while(db.next())
                    {
                        dbstr = dbstr+db.getString(1)+"\n";

                    }
                    JOptionPane.showMessageDialog(null,dbstr,"Databases",JOptionPane.PLAIN_MESSAGE);
                    String DataBase = JOptionPane.showInputDialog("Enter Database Name: ");
                    db = stm.executeQuery("use "+DataBase);
                    JOptionPane.showMessageDialog(null, "Database "+DataBase+" Selected!","Success!", JOptionPane.PLAIN_MESSAGE);
                    ResultSet rs = stm.executeQuery("select * from test");
                    int cou= 0;
                    String output="";
                    while (rs.next())
                    {
                        cou++;
                        output = output+rs.getInt(1)+" "+rs.getString(2)+"\n";
                    }
                    JOptionPane.showMessageDialog(null, output,"Details" ,JOptionPane.PLAIN_MESSAGE);
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
            }

        }
    }





public class JDBC{
    public static void main(String args[])
    {
//
//        String output="";
//        String UserName = JOptionPane.showInputDialog("Enter User Name: ");
//        String Password = JOptionPane.showInputDialog("Enter Password: ");
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306",UserName, Password);
            credentialHandler frame = new credentialHandler();
            frame.CreateUI();
//            Connection conn = frame.conn;
//            Statement stm = conn.createStatement();
//            ResultSet db = stm.executeQuery("show databases");
//            String dbstr="";
//            while(db.next())
//            {
//                dbstr = dbstr+db.getString(1)+"\n";
//
//            }
//            JOptionPane.showMessageDialog(null,dbstr,"Databases",JOptionPane.PLAIN_MESSAGE);
//            String DataBase = JOptionPane.showInputDialog("Enter Database Name: ");
//            db = stm.executeQuery("use "+DataBase);
//            JOptionPane.showMessageDialog(null, "Database "+DataBase+" Selected!","Success!", JOptionPane.PLAIN_MESSAGE);
//            ResultSet rs = stm.executeQuery("select * from test");
//            int cou= 0;
//            String output="";
//            while (rs.next())
//            {
//                cou++;
//                output = output+rs.getInt(1)+" "+rs.getString(2)+"\n";
//            }
//            JOptionPane.showMessageDialog(null, output,"Details" ,JOptionPane.PLAIN_MESSAGE);



        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,e,"Error!",JOptionPane.ERROR_MESSAGE);
        }


    }
}