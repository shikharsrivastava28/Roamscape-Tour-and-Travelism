package roamscape.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class ViewPackage extends JFrame implements ActionListener {
    JLabel labelusername , labelid,labelnumber,labelpackage,labelperson,labelprice,labelcontactno;
    JButton back;

    ViewPackage(String username){
        // Frame Creation
        setBounds(230,100,900,450);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        JLabel text = new JLabel("VIEW PACKAGE DETAILS");
        text.setFont(new Font("tahoma",Font.BOLD,20));
        text.setBounds(60,0,300,30);
        add(text);
        // Labels username
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        // Labels package name
        JLabel lblpackname = new JLabel("Package");
        lblpackname.setBounds(30,90,150,25);
        add(lblpackname);
        labelpackage = new JLabel();
        labelpackage.setBounds(220,90,150,25);
        add(labelpackage);
        // Labels number of person
        JLabel lblperson = new JLabel("Total Number of Persons");
        lblperson.setBounds(30,130,150,25);
        add(lblperson);
        labelperson = new JLabel();
        labelperson.setBounds(220,130,150,25);
        add(labelperson);
        // Labels id
        JLabel lblid = new JLabel("National ID Type");
        lblid.setBounds(30,170,150,25);
        add(lblid);
        labelid = new JLabel();
        labelid.setBounds(220,170,150,25);
        add(labelid);
        // Labels number
        JLabel lblnumber = new JLabel("National ID Number");
        lblnumber.setBounds(30,210,150,25);
        add(lblnumber);
        labelnumber = new JLabel();
        labelnumber.setBounds(220,210,150,25);
        add(labelnumber);
        // Labels contact
        JLabel lblcontact = new JLabel("Contact No");
        lblcontact.setBounds(30,250,150,25);
        add(lblcontact);
        labelcontactno = new JLabel();
        labelcontactno.setBounds(220,250,150,25);
        add(labelcontactno);
        // Labels price
        JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(30,290,150,25);
        add(lblprice);
        labelprice = new JLabel();
        labelprice.setBounds(220,290,150,25);
        add(labelprice);
        //button
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130,350,100,25);
        back.addActionListener(this);
        add(back);
        // Add Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("roamscape/icons/load.gif"));
        Image i2 = i1.getImage().getScaledInstance(500,350,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(350,20,500,350);
        add(image);
        // DBMS
        try{
            Conn con = new Conn();
            String query = "select * from bookpackage where username = '" +username+ "'";
            ResultSet rs = con.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelpackage.setText(rs.getString("package"));
                labelperson.setText(rs.getString("person"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelcontactno.setText(rs.getString("contact"));
                labelprice.setText(rs.getString("price"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    public static void main(String[] args) {
        new ViewPackage("");
    }

}
