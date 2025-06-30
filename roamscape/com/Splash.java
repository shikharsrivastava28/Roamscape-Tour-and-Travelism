package roamscape.com;
import javax.swing.*;
import java.awt.*;
// Swing contain JFRAME class
public class Splash extends JFrame implements Runnable{
    Thread thread;
    Splash(){
        // Define Frame size by setSize
        setSize(800,600);
        // Change Location by setLocation function
        setLocation(230,65);
        // Insert image by ImageIcon object
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("roamscape/icons/travel.gif"));
        Image i2 = i1.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        // Lables
        JLabel image = new JLabel(i3);
        //add image on frame
        add(image);
        // Can see Frame
        setVisible(true);
        thread = new Thread(this);
        thread.start();
    }
    public void run(){
        try{
            Thread.sleep(5000);
            new Login();
            setVisible(false);

        } catch(Exception e){

        }
    }
    public static void main(String[] args) {
       Splash frame = new Splash();
    }
}
