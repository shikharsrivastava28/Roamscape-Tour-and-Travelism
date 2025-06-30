package roamscape.com;

import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer  extends JFrame implements ActionListener {
    JLabel labelusername , labelname;
    JComboBox comboid;
    JTextField tfnumber , tfcountry , tfaddress, tfemail , tfcontactno;
    JRadioButton rmale , rfemale;
    JButton jbadd , jbback;
    AddCustomer(String username){
        // Frame Creation
        setBounds(200,75,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

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
        comboid = new JComboBox(new String[]{"Passport","Aadhar Card ","Pan Card","Driving License"});
        comboid.setBounds(220,90,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);
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
        labelname = new JLabel();
        labelname.setBounds(220,170,150,25);
        add(labelname);
        // Label Gender
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30,210,150,25);
        add(lblgender);
        // Radio Button
        rmale = new JRadioButton("Male");
        rmale.setBounds(220,210,70,25);
        rmale.setBackground(Color.WHITE);
        add(rmale);
        rfemale = new JRadioButton("Female");
        rfemale.setBounds(300,210,70,25);
        rfemale.setBackground(Color.WHITE);
        add(rfemale);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale); bg.add(rfemale);

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
        jbadd = new JButton("Add");
        jbadd.setBackground(Color.BLACK);
        jbadd.setForeground(Color.WHITE);
        jbadd.setBounds(70,420,100,25);
        jbadd.addActionListener(this);
        add(jbadd);
        // Back Button
        jbback = new JButton("Back");
        jbback.setBackground(Color.BLACK);
        jbback.setForeground(Color.WHITE);
        jbback.setBounds(220,420,100,25);
        jbback.addActionListener(this);
        add(jbback);
        // Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("roamscape/icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,40,450,420);
        add(image);
        // Database
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from account where username = '"+username+"'");
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == jbadd){
            String username = labelusername.getText();
            String id = (String)comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = null;
            if(rmale.isSelected()){
                gender = "Male";
            } else {
                gender = "Female";
            }
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String contact = tfcontactno.getText();
            String email = tfemail.getText();

            try{
                Conn c = new Conn();
                String query = "insert into customer values('"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+contact+"','"+email+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new AddCustomer("");
    }
}
