package roamscape.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class UpdateDetails extends JFrame implements ActionListener {
    JLabel labelusername ;
    JTextField tfname,tfnumber , tfcountry , tfaddress, tfemail , tfcontactno,tfid,tfgender;
    JButton jbupdate , jbback ;
    UpdateDetails(String username){
        // Frame Creation
        setBounds(200,75,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // JLabel
        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(50,0,300,25);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);

        // Lable username
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        // Label text field
        labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        //Label ID
        JLabel lblid = new JLabel("National ID Type");
        lblid.setBounds(30,90,150,25);
        add(lblid);
        // Drop Down
        tfid = new JTextField();
        tfid.setBounds(220,90,150,25);
        add(tfid);
        //ID Number
        JLabel idnumber = new JLabel("National ID Number");
        idnumber.setBounds(30,130,150,25);
        add(idnumber);
        // Number Text Field
        tfnumber = new JTextField();
        tfnumber.setBounds(220,130,150,25);
        add(tfnumber);
        // Name label
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,170,150,25);
        add(lblname);
        // Label Text Field
        tfname = new JTextField();
        tfname.setBounds(220,170,150,25);
        add(tfname);
        // Label Gender
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30,210,150,25);
        add(lblgender);
        // gender text field
        tfgender = new JTextField();
        tfgender.setBounds(220,210,150,25);
        add(tfgender);
        // Country Label
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(30,250,150,25);
        add(lblcountry);
        // Text Field
        tfcountry = new JTextField();
        tfcountry.setBounds(220,250,150,25);
        add(tfcountry);
        // Address Label
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(30,290,150,25);
        add(lbladdress);
        // Text Field
        tfaddress = new JTextField();
        tfaddress.setBounds(220,290,150,25);
        add(tfaddress);
        // Contact no Label
        JLabel lblcontactno = new JLabel("Contact Number");
        lblcontactno.setBounds(30,330,150,25);
        add(lblcontactno);
        // Text Field
        tfcontactno = new JTextField();
        tfcontactno.setBounds(220,330,150,25);
        add(tfcontactno);
        // Emailid Label
        JLabel lblemailid = new JLabel("Email Id");
        lblemailid.setBounds(30,370,150,25);
        add(lblemailid);
        // Text Field
        tfemail = new JTextField();
        tfemail.setBounds(220,370,150,25);
        add(tfemail);
        // Add Button
        jbupdate = new JButton("Update");
        jbupdate.setBackground(Color.BLACK);
        jbupdate.setForeground(Color.WHITE);
        jbupdate.setBounds(70,420,100,25);
        jbupdate.addActionListener(this);
        add(jbupdate);
        // Back Button
        jbback = new JButton("Back");
        jbback.setBackground(Color.BLACK);
        jbback.setForeground(Color.WHITE);
        jbback.setBounds(370,420,100,25);
        jbback.addActionListener(this);
        add(jbback);

        // Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("roamscape/icons/newupdate.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,100,450,300);
        add(image);
        // Database
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                tfname.setText(rs.getString("name"));
                tfid.setText(rs.getString("id"));
                tfnumber.setText(rs.getString("number"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfcontactno.setText(rs.getString("contact"));
                tfemail.setText(rs.getString("email"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == jbupdate){
            String username = labelusername.getText();
            String id = tfid.getText();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = tfgender.getText();
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String contact = tfcontactno.getText();
            String email = tfemail.getText();

            try{
                Conn c = new Conn();
                String query = "update customer set id = '"+id+"',number = '"+number+"',name = '"+name+"',gender = '"+gender+"',country = '"+country+"',address = '"+address+"',contact = '"+contact+"',email ='"+email+"' where username = '"+username+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Updated Customer Details Added Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
            try{
                Conn c = new Conn();
                String query = "update account set name = '"+name+"' where username = '"+username+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Updated Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new UpdateDetails("");
    }
}
