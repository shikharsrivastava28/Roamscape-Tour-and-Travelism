package roamscape.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteDetails extends JFrame implements ActionListener{
    String username;
    JLabel labelusername , labelid,labelnumber,labelname,labelgender,labelcountry,labeladdress,labelcontactno,labelemail;
    JButton delete , back;

    DeleteDetails(String username){
        this.username = username;
        // Frame Creation
        setBounds(50,60,1200,450);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        // Labels username
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        // Labels id
        JLabel lblid = new JLabel("National ID Type");
        lblid.setBounds(30,110,150,25);
        add(lblid);
        labelid = new JLabel();
        labelid.setBounds(220,110,150,25);
        add(labelid);
        // Labels number
        JLabel lblnumber = new JLabel("National ID Number");
        lblnumber.setBounds(30,170,150,25);
        add(lblnumber);
        labelnumber = new JLabel();
        labelnumber.setBounds(220,170,150,25);
        add(labelnumber);
        // Labels name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,230,150,25);
        add(lblname);
        labelname = new JLabel();
        labelname.setBounds(220,230,150,25);
        add(labelname);
        // Labels gender
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30,290,150,25);
        add(lblgender);
        labelgender = new JLabel();
        labelgender.setBounds(220,290,150,25);
        add(labelgender);
        // Labels country
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(500,50,150,25);
        add(lblcountry);
        labelcountry = new JLabel();
        labelcountry.setBounds(690,50,150,25);
        add(labelcountry);
        // Labels address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(500,110,150,25);
        add(lbladdress);
        labeladdress = new JLabel();
        labeladdress.setBounds(690,110,150,25);
        add(labeladdress);
        // Labels contact number
        JLabel lblcontactno = new JLabel("Contact Number");
        lblcontactno.setBounds(500,170,150,25);
        add(lblcontactno);
        labelcontactno = new JLabel();
        labelcontactno.setBounds(690,170,150,25);
        add(labelcontactno);
        // Labels email
        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(500,230,150,25);
        add(lblemail);
        labelemail = new JLabel();
        labelemail.setBounds(690,230,150,25);
        add(labelemail);
        //button
        delete = new JButton("Delete");
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.setBounds(300,350,100,25);
        delete.addActionListener(this);
        add(delete);
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(450,350,100,25);
        back.addActionListener(this);
        add(back);
        // Add Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("roamscape/icons/delete.gif"));
        Image i2 = i1.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(600,30,700,400);
        add(image);
        // DBMS
        try{
            Conn con = new Conn();
            String query = "select * from customer where username = '" +username+ "'";
            ResultSet rs = con.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labeladdress.setText(rs.getString("address"));
                labelcontactno.setText(rs.getString("contact"));
                labelemail.setText(rs.getString("email"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == delete){
            try{
                Conn cn = new Conn();
                cn.s.executeUpdate("delete from account where username = '" +username+ "'");
                cn.s.executeUpdate("delete from customer where username = '"+username+"'");
                cn.s.executeUpdate("delete from bookpackage where username = '"+username+"'");
                cn.s.executeUpdate("delete from bookhotel where username = '"+username+"'");
                JOptionPane.showMessageDialog(null,"Data Deleted Successfully");
                setVisible(false);
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
         new DeleteDetails("");
    }
}
