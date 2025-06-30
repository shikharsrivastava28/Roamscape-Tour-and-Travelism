package roamscape.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    String username;
    JButton personaldetails,destinations,payment,about,calculator,deletepersonaldetails,viewpersonaldetails,updatepersonaldetails,checkpackage,bookpackage,viewPackage,viewHotels,bookHotel,viewBookedHotel,exit;
    Dashboard(String username){
        this.username = username;
        // Frame
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        // Panel
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(50,50,50));
        p1.setBounds(0,0,1600,65);
        add(p1);

        // add image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("roamscape/icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5,0,70,70);
        p1.add(icon);

        // Labels
        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(heading);

        // new Panel
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(50,50,50));
        p2.setBounds(0,65,300,900);
        add(p2);

        // Add  Personal Details Buttons
        personaldetails = new JButton("Add Details");
        personaldetails.setBounds(0,0,300,40);
        personaldetails.setBackground(new Color(50,50,50));
        personaldetails.setForeground(Color.WHITE);
        personaldetails.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,20));
        personaldetails.setMargin(new Insets(0,0,0,60));
        personaldetails.addActionListener(this);
        p2.add(personaldetails);

        //Update Personal Details
        updatepersonaldetails = new JButton("Update Details");
        updatepersonaldetails.setBounds(0,40,300,40);
        updatepersonaldetails.setBackground(new Color(50,50,50));
        updatepersonaldetails.setForeground(Color.WHITE);
        updatepersonaldetails.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,20));
        updatepersonaldetails.setMargin(new Insets(0,0,0,60));
        updatepersonaldetails.addActionListener(this);
        p2.add(updatepersonaldetails);

        //View Personal Details
        viewpersonaldetails = new JButton("View Details");
        viewpersonaldetails.setBounds(0,80,300,40);
        viewpersonaldetails.setBackground(new Color(50,50,50));
        viewpersonaldetails.setForeground(Color.WHITE);
        viewpersonaldetails.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,20));
        viewpersonaldetails.setMargin(new Insets(0,0,0,60));
        viewpersonaldetails.addActionListener(this);
        p2.add(viewpersonaldetails);

        //Delete Personal Details
        deletepersonaldetails = new JButton("Delete Details");
        deletepersonaldetails.setBounds(0,120,300,40);
        deletepersonaldetails.setBackground(new Color(50,50,50));
        deletepersonaldetails.setForeground(Color.WHITE);
        deletepersonaldetails.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,20));
        deletepersonaldetails.setMargin(new Insets(0,0,0,60));
        deletepersonaldetails.addActionListener(this);
        p2.add(deletepersonaldetails);

        //Check Package
        checkpackage = new JButton("Check Packages");
        checkpackage.setBounds(0,160,300,40);
        checkpackage.setBackground(new Color(50,50,50));
        checkpackage.setForeground(Color.WHITE);
        checkpackage.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,20));
        checkpackage.setMargin(new Insets(0,0,0,60));
        checkpackage.addActionListener(this);
        p2.add(checkpackage);

        // Book Package
        bookpackage = new JButton("Book Package");
        bookpackage.setBounds(0,200,300,40);
        bookpackage.setBackground(new Color(50,50,50));
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,20));
        bookpackage.setMargin(new Insets(0,0,0,60));
        bookpackage.addActionListener(this);
        p2.add(bookpackage);

        // View Package
        viewPackage = new JButton("View Package");
        viewPackage.setBounds(0,240,300,40);
        viewPackage.setBackground(new Color(50,50,50));
        viewPackage.setForeground(Color.WHITE);
        viewPackage.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,20));
        viewPackage.setMargin(new Insets(0,0,0,60));
        viewPackage.addActionListener(this);
        p2.add(viewPackage);

        // view Hotels
        viewHotels = new JButton("View Hotels");
        viewHotels.setBounds(0,280,300,40);
        viewHotels.setBackground(new Color(50,50,50));
        viewHotels.setForeground(Color.WHITE);
        viewHotels.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,20));
        viewHotels.setMargin(new Insets(0,0,0,60));
        viewHotels.addActionListener(this);
        p2.add(viewHotels);

        //Book Hotel
        bookHotel = new JButton("Book Hotel");
        bookHotel.setBounds(0,320,300,40);
        bookHotel.setBackground(new Color(50,50,50));
        bookHotel.setForeground(Color.WHITE);
        bookHotel.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,20));
        bookHotel.setMargin(new Insets(0,0,0,60));
        bookHotel.addActionListener(this);
        p2.add(bookHotel);

        // View Booked Hotel
        viewBookedHotel = new JButton("View Booked Hotel");
        viewBookedHotel.setBounds(0,360,300,40);
        viewBookedHotel.setBackground(new Color(50,50,50));
        viewBookedHotel.setForeground(Color.WHITE);
        viewBookedHotel.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,20));
        viewBookedHotel.setMargin(new Insets(0,0,0,60));
        viewBookedHotel.addActionListener(this);
        p2.add(viewBookedHotel);

        // Destination
        destinations = new JButton("Destinations");
        destinations.setBounds(0,400,300,40);
        destinations.setBackground(new Color(50,50,50));
        destinations.setForeground(Color.WHITE);
        destinations.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,20));
        destinations.setMargin(new Insets(0,0,0,60));
        destinations.addActionListener(this);
        p2.add(destinations);

        // Payments
        payment = new JButton("Payment");
        payment.setBounds(0,440,300,40);
        payment.setBackground(new Color(50,50,50));
        payment.setForeground(Color.WHITE);
        payment.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,20));
        payment.setMargin(new Insets(0,0,0,60));
        payment.addActionListener(this);
        p2.add(payment);

        // Calculators
        calculator = new JButton("Calculator");
        calculator.setBounds(0,480,300,40);
        calculator.setBackground(new Color(50,50,50));
        calculator.setForeground(Color.WHITE);
        calculator.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,20));
        calculator.setMargin(new Insets(0,0,0,60));
        calculator.addActionListener(this);
        p2.add(calculator);

        // About
        about = new JButton("About");
        about.setBounds(0,520,300,40);
        about.setBackground(new Color(50,50,50));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,20));
        about.setMargin(new Insets(0,0,0,60));
        about.addActionListener(this);
        p2.add(about);

        // exit
        exit = new JButton("Log Out");
        exit.setBounds(0,560,300,40);
        exit.setBackground(new Color(50,50,50));
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,20));
        exit.setMargin(new Insets(0,0,0,60));
        exit.addActionListener(this);
        p2.add(exit);

        // ADD Image
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("roamscape/icons/hotels.gif"));
        Image i5 = i4.getImage().getScaledInstance(1200,800,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image  = new JLabel(i6);
        image.setBounds(100,65,1200,800);
        add(image);

        // Text
        JLabel text = new JLabel("The RoamScape Travel & Tourism");
        text.setBounds(400,10,700,50);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,40));
        p1.add(text);
        JLabel u1 = new JLabel(username);
        u1.setBounds(1200,10,110,40);
        u1.setForeground(Color.WHITE);
        u1.setFont(new Font("Raleway",Font.PLAIN,15));
        p1.add(u1);

        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource() == personaldetails){
           new AddCustomer(username);
       } else if (ae.getSource() == viewpersonaldetails) {
           new ViewCustomer(username);
       } else if (ae.getSource() == updatepersonaldetails) {
           new UpdateDetails(username);
       } else if (ae.getSource() == checkpackage) {
           new Checkpackage();
       } else if(ae.getSource() == bookpackage){
           new BookPackage(username);
       } else if (ae.getSource() == viewPackage) {
           new ViewPackage(username);
       } else if (ae.getSource() == viewHotels) {
           new CheckHotels();
       } else if (ae.getSource() == bookHotel) {
           new BookHotel(username);
       } else if(ae.getSource() == viewBookedHotel){
           new ViewHotel(username);
       } else if(ae.getSource() == destinations){
           new Destination();
       } else if (ae.getSource() == deletepersonaldetails) {
           new DeleteDetails(username);
       } else if (ae.getSource() == payment) {
           new Payments();
       }else if(ae.getSource() == calculator){
           try{
               Runtime.getRuntime().exec("calc.exe");
           } catch (Exception e){
               e.printStackTrace();
           }
       } else if(ae.getSource() == about){
           new About();
       }
       else {
           JOptionPane.showMessageDialog(null,username + " Logged Out Successfully");
           System.exit(0);
       }
    }
    public static void main(String[] args) {
        new Dashboard("");
    }
}
