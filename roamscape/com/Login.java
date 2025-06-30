package roamscape.com;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton login , signup , fp;
    JTextField tfusername;
    JPasswordField tfpassword;
    Login(){
        // Frame creation
        setSize(900,400);
        setLocation(200,150);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        // Panel Creation
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0 , 0 , 400 ,400);
        p1.setLayout(null);
        add(p1);

        // Insert image on panel
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("roamscape/icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100,120,200,200);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400 , 30,450,300);
        add(p2);

        // Username panel
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60,20,100,25);
        lblusername.setFont(new Font("SAN SERLE",Font.PLAIN, 20));
        p2.add(lblusername);

        // Add Username box
        tfusername = new JTextField();
        tfusername.setBounds(60,60,300,30);
        tfusername.setFont(new Font("Tahoma",Font.PLAIN,12));
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);

        // Password panel
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(60,110,100,25);
        lblpassword.setFont(new Font("SAN SERLE",Font.PLAIN, 20));
        p2.add(lblpassword);

        // Add Password box
        tfpassword = new JPasswordField();
        tfpassword.setBounds(60,150,300,30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);

        // Create  Login Button
        login = new JButton("Login");
        login.setBounds(60,200,130,30);
        login.setBackground(new Color(133,193,233));
        login.setForeground(Color.black);
        login.setBorder(new LineBorder(new Color(133,193,233)));
        login.addActionListener(this);
        p2.add(login);

        // Create Signup Button
        signup = new JButton("Sign Up");
        signup.setBounds(230,200,130,30);
        signup.setBackground(new Color(133,193,233));
        signup.setForeground(Color.black);
        signup.setBorder(new LineBorder(new Color(133,193,233)));
        signup.addActionListener(this);
        p2.add(signup);

        // Create Forget Password Button
        fp = new JButton("Forget Password");
        fp.setBounds(130,250,130,30);
        fp.setBackground(new Color(133,193,233));
        fp.setForeground(Color.black);
        fp.setBorder(new LineBorder(new Color(133,193,233)));
        fp.addActionListener(this);
        p2.add(fp);

        // Problem in signup
        JLabel text  = new JLabel("Trouble in Login.....");
        text.setBounds(300,250,150,20);
        text.setForeground(Color.BLACK);
        p2.add(text);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            try{
                String username = tfusername.getText();
                String password = tfpassword.getText();

                String query = "select * from account where username = '"+username+"' or password = '" + password+" '";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Loading(username);
                } else {
                    JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup();

        }else {
            setVisible(false);
            new ForgetPassword();
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
