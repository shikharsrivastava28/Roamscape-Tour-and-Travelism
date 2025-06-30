package roamscape.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener {
    JButton back;
    About(){
        setBounds(220,70,800,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        JLabel l1 = new JLabel("ABOUT ");
        l1.setBounds(50,20,200,50);
        l1.setBackground(Color.BLACK);
        l1.setFont(new Font("tahoma",Font.BOLD,50));
        add(l1);
        TextArea area = new TextArea("Heya........",10,TextArea.SCROLLBARS_VERTICAL_ONLY);
        area.setEditable(false);
        area.setBounds(20,100,450,300);
        add(area);
        back = new JButton("Back");
        back.setBounds(220,420,80,25);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new About();
    }
}
