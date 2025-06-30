package roamscape.com;

import javax.swing.*;
import java.awt.*;

public class Checkpackage extends JFrame {

    Checkpackage(){
        String[] package1 = {"Goldern Package"," > 11 Days & 12 Nights"," > Airport Assistance"," > Full Day City Tour"," > Daily Buffet"," > 1 Night Camping"," > Full Day 3 Island Cruise"," > Mountain Tracking","BOOK NOW","Seasonal  Special","Rs.12000/-"};
        String[] package2 = {"Silver Package"," > 7 Days & 8 Nights"," > Airport Assistance"," > Full Day City Tour"," > Daily Buffet"," > 1 Night Camping"," > Full Day 2 Island Cruise","> DJ Night","BOOK NOW","Seasonal  Special","Rs.9000/-"};
        String[] package3 = {"Bronze Package"," > 4 Days & 5 Nights"," > Airport Assistance"," > Full Day City Tour"," > Daily Buffet"," > Full Day 1 Island Cruise","> Jungle Safari","> Roof Top Dinner","BOOK NOW","Seasonal  Special","Rs.6000/-"};
        // Frame
        setBounds(200,50,900,600);
        // Tabs
        JTabbedPane tab = new JTabbedPane();
        JPanel p1 = createPackage(package1);
        // Tab 1
        tab.addTab("Package 1",null,p1);
        add(tab);
        JPanel p2 = createPackage(package2);
        tab.addTab("Package 2",null,p2);
        add(tab);
        JPanel p3 = createPackage(package3);
        tab.addTab("Package 3",null,p3);
        add(tab);


        setVisible(true);
    }
    public JPanel createPackage(String[] pack){
        //Panel
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(250,249,246));
        // JLabels
        JLabel l1 = new JLabel(pack[0]);
        l1.setBounds(30,5,300,35);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(l1);
        // Features Labels
        JLabel l2 = new JLabel(pack[1]);
        l2.setBounds(30,60,300,30);
        l2.setForeground(new Color(50,50,50));
        l2.setFont(new Font("Tahoma",Font.PLAIN,20));
        p1.add(l2);
        JLabel l3 = new JLabel(pack[2]);
        l3.setBounds(30,110,300,30);
        l3.setForeground(new Color(50,50,50));
        l3.setFont(new Font("Tahoma",Font.PLAIN,20));
        p1.add(l3);
        JLabel l4 = new JLabel(pack[3]);
        l4.setBounds(30,160,300,30);
        l4.setForeground(new Color(50,50,50));
        l4.setFont(new Font("Tahoma",Font.PLAIN,20));
        p1.add(l4);
        JLabel l5 = new JLabel(pack[4]);
        l5.setBounds(30,210,300,30);
        l5.setForeground(new Color(50,50,50));
        l5.setFont(new Font("Tahoma",Font.PLAIN,20));
        p1.add(l5);
        JLabel l6 = new JLabel(pack[5]);
        l6.setBounds(30,260,300,30);
        l6.setForeground(new Color(50,50,50));
        l6.setFont(new Font("Tahoma",Font.PLAIN,20));
        p1.add(l6);
        JLabel l7 = new JLabel(pack[6]);
        l7.setBounds(30,310,300,30);
        l7.setForeground(new Color(50,50,50));
        l7.setFont(new Font("Tahoma",Font.PLAIN,20));
        p1.add(l7);
        JLabel l8 = new JLabel(pack[7]);
        l8.setBounds(30,360,300,30);
        l8.setForeground(new Color(50,50,50));
        l8.setFont(new Font("Tahoma",Font.PLAIN,20));
        p1.add(l8);
        JLabel l9 = new JLabel(pack[8]);
        l9.setBounds(60,430,300,30);
        l9.setForeground(new Color(139,0,0));
        l9.setFont(new Font("Tahoma",Font.BOLD,25));
        p1.add(l9);
        JLabel l10 = new JLabel(pack[9]);
        l10.setBounds(60,480,300,30);
        l10.setForeground(new Color(139,0,0));
        l10.setFont(new Font("Tahoma",Font.BOLD,25));
        p1.add(l10);
        JLabel l11 = new JLabel(pack[10]);
        l11.setBounds(480,480,300,30);
        l11.setForeground(new Color(139,0,0));
        l11.setFont(new Font("Tahoma",Font.BOLD,25));
        p1.add(l11);
        // Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("roamscape/icons/newhomes.gif"));
        Image i2 = i1.getImage().getScaledInstance(480,444,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel j12 = new JLabel(i3);
        j12.setBounds(350,20,480,444);
        p1.add(j12);
        return p1;
    }
    public static void main(String[] args) {
        new Checkpackage();
    }
}
