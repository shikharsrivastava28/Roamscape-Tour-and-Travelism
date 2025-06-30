package roamscape.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payments extends JFrame implements ActionListener {
    JButton pay , back;
    Payments(){
        setBounds(220,50,800,600);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("roamscape/icons/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,800,600);
        add(l1);

        pay = new JButton("Pay");
        pay.setBounds(520,0,80,30);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        l1.add(pay);

        back = new JButton("Back");
        back.setBounds(620,0,80,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        l1.add(back);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == pay){
            setVisible(false);
            new Paytm();
        }else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Payments();
    }
}
