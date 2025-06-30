package roamscape.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BookHotel extends JFrame implements ActionListener{
    String username;
    Choice chotel,cac,cfood;
    JLabel labelusername,labelid,labelnumber,labelcontact,labelsum;
    JTextField tfperson,tfdays;
    JButton checkprice , book,back
            ;
    BookHotel(String username){
        this.username = username;
        setBounds(120,20,1000,650);
        setLayout(null);
        JLabel text = new JLabel("BOOK HOTEL");
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
        JLabel lbHotel = new JLabel("Select Hotel");
        lbHotel.setBounds(30,100,150,25);
        add(lbHotel);
        chotel = new Choice();
        chotel.setBounds(220,100,170,25);
        add(chotel);
        try{
            Conn cn = new Conn();
            ResultSet rs = cn.s.executeQuery("select * from hotels");
            while(rs.next()){
                chotel.add(rs.getString("name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        // total person
        JLabel lblperson = new JLabel("Total Person");
        lblperson.setBounds(30,150,150,25);
        add(lblperson);
        tfperson = new JTextField("1");
        tfperson.setBounds(220,150,170,25);
        add(tfperson);
        // Labels id
        JLabel lbldays = new JLabel("Number of Days");
        lbldays.setBounds(30,200,150,25);
        add(lbldays);
        tfdays = new JTextField("1");
        tfdays.setBounds(220,200,170,25);
        add(tfdays);
        // Labels number
        JLabel lblacnonac = new JLabel("AC & Non-AC Room");
        lblacnonac.setBounds(30,250,150,25);
        add(lblacnonac);

        cac = new Choice();
        cac.add("Ac");
        cac.add("Non-AC");
        cac.setBounds(220,250,170,25);
        add(cac);
        // Labels name
        JLabel lblfood = new JLabel("Food Included");
        lblfood.setBounds(30,300,150,25);
        add(lblfood);
        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(220,300,170,25);
        add(cfood);
        JLabel lblid = new JLabel("National ID Type");
        lblid.setBounds(30,350,150,25);
        add(lblid);
        labelid = new JLabel();
        labelid.setBounds(220,350,150,25);
        add(labelid);
        // Labels number
        JLabel lblnumber = new JLabel("National ID Number");
        lblnumber.setBounds(30,400,150,25);
        add(lblnumber);
        labelnumber = new JLabel();
        labelnumber.setBounds(220,400,150,25);
        add(labelnumber);
        // Labels name
        JLabel lblcontact = new JLabel("Contact No.");
        lblcontact.setBounds(30,450,150,25);
        add(lblcontact);
        labelcontact = new JLabel();
        labelcontact.setBounds(220,450,150,25);
        add(labelcontact);
        JLabel lblsum = new JLabel("Total Amount");
        lblsum.setBounds(30,500,150,25);
        add(lblsum);
        labelsum = new JLabel();
        labelsum.setBounds(220,500,150,25);
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
        checkprice = new JButton("Total Price");
        checkprice.setForeground(Color.WHITE);
        checkprice.setBackground(Color.BLACK);
        checkprice.setBounds(60,550,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        // Book Button
        book = new JButton("Book Hotel");
        book.setForeground(Color.WHITE);
        book.setBackground(Color.BLACK);
        book.setBounds(200,550,120,25);
        book.addActionListener(this);
        add(book);
        // Back Button
        back = new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(340,550,120,25);
        back.addActionListener(this);
        add(back);
        // Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("roamscape/icons/bookhotel.gif"));
        Image i2 = i1.getImage().getScaledInstance(500,550,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel j1 = new JLabel(i3);
        j1.setBounds(500,50,500,550);
        add(j1);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkprice){
            try{
            Conn cn = new Conn();
            ResultSet rs = cn.s.executeQuery("select * from hotels where name = '"+ chotel.getSelectedItem()+"'");
            while(rs.next()){
                int cost = Integer.parseInt(rs.getString("costperperson"));
                int food = Integer.parseInt(rs.getString("food"));
                int ac = Integer.parseInt(rs.getString("nonacroom"));

                int person = Integer.parseInt(tfperson.getText());
                int days = Integer.parseInt(tfdays.getText());

                String acselected = cac.getSelectedItem();
                String foodselected = cfood.getSelectedItem();

                if(person * days > 0 ){
                    int total = 0;
                    total += acselected.equals("AC") ? ac: 0 ;
                    total += foodselected.equals("Yes") ? food : 0 ;
                    total += cost;
                    total = total * person * days;
                    labelsum.setText("Rs. " + total);
                } else {
                    JOptionPane.showMessageDialog(null,"Please Enter a Valid Choice");
                }
            }
                } catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == book) {
            try{
                Conn cn = new Conn();
                cn.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"','"+chotel.getSelectedItem()+"','"+tfperson.getText()+"','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelcontact.getText()+"','"+labelsum.getText()+"')");
                JOptionPane.showMessageDialog(null,"Hotel Booked Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        } else{
            setVisible(false);
        }

    }
    public static void main(String[] args) {
        new BookHotel("");
    }
}
