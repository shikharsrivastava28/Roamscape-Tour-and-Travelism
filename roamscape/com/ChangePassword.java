package roamscape.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ChangePassword extends JFrame implements ActionListener {
    JLabel  labelname,labelquestion;
    JTextField  tfusername ,tfanswer,tfpassword;
    JButton jserch,jupdate ,jback;
    ChangePassword(){
        // Frame Creation
        setBounds(200,175,650,360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Adding image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("roamscape/icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 70, 200,200);
        add(image);
        // Lable username
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        // Label text field
        tfusername = new JTextField();
        tfusername.setBounds(200,50,150,25);
        add(tfusername);
        // name label
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,90,150,25);
        add(lblname);
        // Label Text Field
        labelname = new JLabel();
        labelname.setBounds(200,90,150,25);
        add(labelname);
        // question label
        JLabel lblquestion = new JLabel("Question");
        lblquestion.setBounds(30,130,150,25);
        add(lblquestion);
        // Label Text Field
        labelquestion = new JLabel();
        labelquestion.setBounds(200,130,150,25);
        add(labelquestion);
        // answer
        JLabel lblanswer = new JLabel("New Answer");
        lblanswer.setBounds(30,170,150,25);
        add(lblanswer);
        // Label text field
        tfanswer = new JTextField();
        tfanswer.setBounds(200,170,150,25);
        add(tfanswer);
        // Password
        JLabel lblpassword = new JLabel("New Password");
        lblpassword.setBounds(30,210,150,25);
        add(lblpassword);
        tfpassword = new JTextField();
        tfpassword.setBounds(200,210,150,25);
        add(tfpassword);

        // Search Button
        jserch = new JButton("Search");
        jserch.setBackground(Color.black);
        jserch.setForeground(Color.WHITE);
        jserch.setBounds(40,250,100,25);
        jserch.addActionListener(this);
        add(jserch);
        setVisible(true);
        // update Button
        jupdate = new JButton("Update");
        jupdate.setBackground(Color.black);
        jupdate.setForeground(Color.WHITE);
        jupdate.setBounds(170,250,100,25);
        jupdate.addActionListener(this);
        add(jupdate);
        // back Button
        jback = new JButton("Back");
        jback.setBackground(Color.black);
        jback.setForeground(Color.WHITE);
        jback.setBounds(300,250,100,25);
        jback.addActionListener(this);
        add(jback);

    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == jserch) {
            try {
                String query = "select * from account where username = '" + tfusername.getText() + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    labelname.setText(rs.getString("name"));
                    labelquestion.setText(rs.getString("question"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == jupdate) {
            String username = tfusername.getText();
            String name = labelname.getText();
            String question = labelquestion.getText();
            String answer = tfanswer.getText();
            String password = tfpassword.getText();
            try{
                Conn c = new Conn();
                String query = "update account set answer = '" + answer +"',password = '"+password+"' where username = '"+username+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Changed Password Successfully");
            }catch(Exception e){
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args) {
        new ChangePassword();
    }
}
