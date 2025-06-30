package roamscape.com;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{
    String username;
    Thread t;
    JProgressBar bar;
    public void run(){
        try{
            for(int i = 1 ; i <= 101 ; i++){
                int max = bar.getMaximum();
                int value = bar.getValue(); // current value

                if(value < max){
                    bar.setValue(bar.getValue() + 1);
                } else {
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(50);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    Loading(String username){
        this.username = username;

        // thread class object
        t = new Thread(this);
        // Frame creation
        setBounds(300,175,650,400);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);

        // Label
        JLabel text = new JLabel("The RoamScape Travel & Tourism");
        text.setBounds(50,20,600,40);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.ITALIC,35));
        add(text);

        //Progress bar
        bar = new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);

        // Please Wait label
        JLabel loading = new JLabel("Working on it..Please Wait...");
        loading.setBounds(150,140,400,30);
        loading.setForeground(Color.WHITE);
        loading.setFont(new Font("Raleway",Font.PLAIN,25));
        add(loading);

        // user name Label
        JLabel customer = new JLabel("Welcome Customer " + username);
        customer.setBounds(20,310,400,35);
        customer.setForeground(Color.WHITE);
        customer.setFont(new Font("Raleway",Font.ROMAN_BASELINE,20));
        add(customer);

        t.start();
        setVisible(true);
    }
    public static void main(String[] args) {
        new Loading("");
    }
}
