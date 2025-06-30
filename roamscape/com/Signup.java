package roamscape.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener {

    JButton create , back;
    JTextField tfusername , tfname , tfpass, tfanswer;
    Choice security;
    Signup(){
        // Used to Create Frame
        setBounds(200,175,900,360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Panel
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(0,0 ,500,400);
        p1.setLayout(null);
        add(p1);

        // Labels Username
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(50,20,125,25);
        lblusername.setFont(new Font("Taboma",Font.BOLD,14));
        p1.add(lblusername);

        // Add TextField
        tfusername = new JTextField();
        tfusername.setBounds(190,20,150,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        // Labels name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,60,125,25);
        lblname.setFont(new Font("Taboma",Font.BOLD,14));
        p1.add(lblname);

        // Add TextField
        tfname = new JTextField();
        tfname.setBounds(190,60,150,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        // Labels Password
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(50,100,125,25);
        lblpassword.setFont(new Font("Taboma",Font.BOLD,14));
        p1.add(lblpassword);

        // Add TextField
        tfpass = new JTextField();
        tfpass.setBounds(190,100,150,25);
        tfpass.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpass);

        // Labels Security
        JLabel lblsecurity = new JLabel("Security Question");
        lblsecurity.setBounds(50,140,125,25);
        lblsecurity.setFont(new Font("Taboma",Font.BOLD,14));
        p1.add(lblsecurity);

        // Choice
        security = new Choice();
        security.add("Fav K-Drama");
        security.add("Fav Book");
        security.add("Fav Song");
        security.add("Yours Lucky Number");
        security.add("Chai or Coffee");
        security.setBounds(190,140,150,25);
        p1.add(security);

        // Labels Answer
        JLabel lblans = new JLabel("Security Answer");
        lblans.setBounds(50,180,125,25);
        lblans.setFont(new Font("Taboma",Font.BOLD,14));
        p1.add(lblans);

        // Add TextField
        tfanswer = new JTextField();
        tfanswer.setBounds(190,180,150,25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);

        // Add Create Buttons
        create = new JButton("Create");
        create.setForeground(new Color(133,193,223));
        create.setBackground(Color.WHITE);
        create.setFont(new Font("aboma",Font.BOLD,14));
        create.setBounds(80,250,100,30);
        create.addActionListener(this);
        p1.add(create);

        // Add Back Buttons
        back = new JButton("Back");
        back.setForeground(new Color(133,193,223));
        back.setBackground(Color.WHITE);
        back.setFont(new Font("aboma",Font.BOLD,14));
        back.setBounds(250,250,100,30);
        back.addActionListener(this);
        p1.add(back);

        // Add Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("roamscape/icons/signupimages.png"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,80,200,200);
        add(image);


        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == create){
            String username = tfusername.getText();
            String name = tfname.getText();
            String password = tfpass.getText();
            String question = security.getSelectedItem();
            String answer = tfanswer.getText();

            String query = "insert into account values('" + name + " ','" + username + "','" + password + "' ,'"+question+"','"+answer+"')";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Account Create Successfully");

                setVisible(false);
                new Login();
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args) {

        new Signup();
    }
}
