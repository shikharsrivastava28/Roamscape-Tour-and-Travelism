package roamscape.com;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener {
    JTextField tfusername , tfname , tfquestion , tfanswer , tfpassword;
    JButton search , fetch ,change ,back;
    ForgetPassword(){
        // Frame Creation
        setBounds(200,175,850,380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Adding Image to frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("roamscape/icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 70, 200,200);
        add(image);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(40,20,500,300);
        add(p1);

        // Lables Creation
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,20,100,25);
        lblusername.setFont(new Font("ahoma",Font.BOLD,14));
        p1.add(lblusername);

        // Username Text Field
        tfusername = new JTextField();
        tfusername.setBounds(220,20,150,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        // Search Button
        search = new JButton("Search");
        search.setBackground(Color.black);
        search.setForeground(Color.WHITE);
        search.setBounds(80,230,100,25);
        search.addActionListener(this);
        p1.add(search);

        // Name Lables Creation
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40,60,100,25);
        lblname.setFont(new Font("ahoma",Font.BOLD,14));
        p1.add(lblname);

        // Name Text Field
        tfname = new JTextField();
        tfname.setBounds(220,60,150,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        // Security Lables Creation
        JLabel lblquestion = new JLabel("Security Question");
        lblquestion.setBounds(40,100,150,25);
        lblquestion.setFont(new Font("ahoma",Font.BOLD,14));
        p1.add(lblquestion);

        // Security Text Field
        tfquestion = new JTextField();
        tfquestion.setBounds(220,100,150,25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);

        //  Answer Lables Creation
        JLabel lblanswer = new JLabel("Security Answer");
        lblanswer.setBounds(40,140,150,25);
        lblanswer.setFont(new Font("ahoma",Font.BOLD,14));
        p1.add(lblanswer);

        // Answer Text Field
        tfanswer = new JTextField();
        tfanswer.setBounds(220,140,150,25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);

        // Fetch Button
        fetch = new JButton("Retrieve");
        fetch.setBackground(Color.black);
        fetch.setForeground(Color.WHITE);
        fetch.setBounds(220,230,100,25);
        fetch.addActionListener(this);
        p1.add(fetch);

        //  Password Lables Creation
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40,180,150,25);
        lblpassword.setFont(new Font("ahoma",Font.BOLD,14));
        p1.add(lblpassword);

        // Password Text Field
        tfpassword = new JTextField();
        tfpassword.setBounds(220,180,150,25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        // back Button
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.setBounds(360,230,100,25);
        back.addActionListener(this);
        p1.add(back);
        // Change Button
        change = new JButton("Change Password");
        change.setBackground(Color.black);
        change.setForeground(Color.WHITE);
        change.setBounds(200,270,150,25);
        change.addActionListener(this);
        p1.add(change);

        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            try{
                String query = "select * from account where username = '"+tfusername.getText()+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    tfname.setText(rs.getString("name"));
                    tfquestion.setText(rs.getString("question"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == fetch) {
            try{
                String query = "select * from account where answer = '"+tfanswer.getText()+"' or username = '"+tfusername.getText()+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    tfpassword.setText(rs.getString("password"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == change) {
            setVisible(false);
            new ChangePassword();
        } else {
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args) {
        new ForgetPassword();
    }
}
