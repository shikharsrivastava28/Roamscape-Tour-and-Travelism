package roamscape.com;

import javax.swing.*;
import java.awt.event.*;

public class Paytm extends JFrame implements ActionListener {
    JButton back;
    Paytm(){
//        setBounds(220,50,800,600);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);
        try{
            pane.setPage("https://paytm.com/rent-payment");
        }catch(Exception e) {
            pane.setContentType("text/html");
            pane.setText("<html> Could not Load, Error 404. </html>");
        }
        JScrollPane sp =new JScrollPane(pane);
        getContentPane().add(sp);

        back = new JButton("Back");
        back.setBounds(1200,20,50,25);
        back.addActionListener(this);
        pane.add(back);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Paytm();
    }
}
