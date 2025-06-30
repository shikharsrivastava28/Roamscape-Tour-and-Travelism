package roamscape.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener {
    String username;
    Choice cpack;
    JLabel labelusername,labelid,labelnumber,labelcontact,labelsum;
    JTextField tfperson;
    JButton checkprice , book,back;
    BookPackage(String username){
        this.username = username;

        setBounds(100,50,1000,500);
        setLayout(null);
        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        getContentPane().setBackground(Color.WHITE);
        // Labels username
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        //Select Package
        JLabel lbpack = new JLabel("Select Package");
        lbpack.setBounds(30,100,150,25);
        add(lbpack);
        cpack = new Choice();
        cpack.add("Goldern Package");
        cpack.add("Silver Package");
        cpack.add("Bronze Package");
        cpack.setBounds(220,100,150,25);
        add(cpack);
        // total person
        JLabel lblperson = new JLabel("Total Person");
        lblperson.setBounds(30,150,150,25);
        add(lblperson);
        tfperson = new JTextField("1");
        tfperson.setBounds(220,150,150,25);
        add(tfperson);
        // Labels id
        JLabel lblid = new JLabel("National ID Type");
        lblid.setBounds(30,200,150,25);
        add(lblid);
        labelid = new JLabel();
        labelid.setBounds(220,200,150,25);
        add(labelid);
        // Labels number
        JLabel lblnumber = new JLabel("National ID Number");
        lblnumber.setBounds(30,250,150,25);
        add(lblnumber);
        labelnumber = new JLabel();
        labelnumber.setBounds(220,250,150,25);
        add(labelnumber);
        // Labels name
        JLabel lblcontact = new JLabel("Contact No.");
        lblcontact.setBounds(30,300,150,25);
        add(lblcontact);
        labelcontact = new JLabel();
        labelcontact.setBounds(220,300,150,25);
        add(labelcontact);
        // Labels gender
        JLabel lblsum = new JLabel("Total Amount");
        lblsum.setBounds(30,350,150,25);
        add(lblsum);
        labelsum = new JLabel();
        labelsum.setBounds(220,350,150,25);
        add(labelsum);
        try{
            Conn con = new Conn();
            String query = "select * from customer where username = '" +username+ "'";
            ResultSet rs = con.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelcontact.setText(rs.getString("contact"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        // Check Button
        checkprice = new JButton("Check Price");
        checkprice.setForeground(Color.WHITE);
        checkprice.setBackground(Color.BLACK);
        checkprice.setBounds(60,400,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        // Book Button
        book = new JButton("Book Package");
        book.setForeground(Color.WHITE);
        book.setBackground(Color.BLACK);
        book.setBounds(200,400,120,25);
        book.addActionListener(this);
        add(book);
        // Back Button
        back = new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(340,400,120,25);
        back.addActionListener(this);
        add(back);
        // Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("roamscape/icons/booking.gif"));
        Image i2 = i1.getImage().getScaledInstance(400,350,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel j1 = new JLabel(i3);
        j1.setBounds(550,50,400,350);
        add(j1);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkprice){
          String pack = cpack.getSelectedItem();
          int cost = 0;
          if(pack.equals("Goldern Package")){
              cost = cost + 12000;
          }else if(pack.equals("Silver Package")){
              cost = cost + 9000;
          }else{
              cost = cost + 6000;
          }
          int persons = Integer.parseInt(tfperson.getText());
          cost = cost * persons;
          labelsum.setText("Rs " + cost);
        } else if (ae.getSource() == book) {
            try{
                Conn cn = new Conn();
                cn.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"','"+cpack.getSelectedItem()+"','"+tfperson.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelcontact.getText()+"','"+labelsum.getText()+"')");
                JOptionPane.showMessageDialog(null,"Package Booked Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        } else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new BookPackage("");
    }
}
