package roamscape.com;
import javax.swing.*;
import java.awt.*;
public class Destination extends JFrame implements Runnable{
    Thread t1;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JLabel[] jlabel = new JLabel[]{l1,l2,l3,l4,l5,l6,l7,l8,l9,l10};
    //JLabel caption;
    public void run(){
        //String[] text = new String[]{"The Grand Budapest Hotel","The Plaza","The Butterfly Mention","The Ace Hotel","Super 8 Hotel","Red Roof In","The Jane Hotel","The Four Seasons","MoonLight Hotel","The Standard House"};
        try{
            for(int i = 0 ; i < 7; i++){
                jlabel[i].setVisible(true);
                //caption.setText(text[i]);
                Thread.sleep(2500);
                jlabel[i].setVisible(false);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    Destination(){
        setBounds(150,50,1000,600);
//        caption = new JLabel("");
//        caption.setBounds(50,500,1000,70);
//        caption.setFont(new Font("tahoma",Font.BOLD,40));
//        caption.setForeground(Color.WHITE);
//        add(caption);

        ImageIcon pi1 = null,pi2 = null,pi3 = null ,pi4 = null,pi5 = null,pi6 = null,pi7 = null,pi8 = null,pi9  = null , pi10 = null;
        ImageIcon[] image = new ImageIcon[]{pi1,pi2,pi3,pi4,pi5,pi6,pi7,pi8,pi9,pi10};

        Image j1 = null,j2 = null,j3 = null ,j4 = null,j5 = null,j6 = null,j7 = null,j8 = null,j9  = null , j10 = null;
        Image[] jimage = new Image[]{j1,j2,j3,j4,j5,j6,j7,j8,j9,j10};

        ImageIcon k1 = null,k2 = null,k3 = null ,k4 = null,k5 = null,k6 = null,k7 = null,k8 = null,k9  = null , k10 = null;
        ImageIcon[] kimage = new ImageIcon[]{k1,k2,k3,k4,k5,k6,k7,k8,k9,k10};

        for(int i = 0 ; i < 7; i++){
            image[i] = new ImageIcon(ClassLoader.getSystemResource("roamscape/icons/dest" + (i + 1) + ".jpg"));
            jimage[i] = image[i].getImage().getScaledInstance(1000,600,Image.SCALE_DEFAULT);
            kimage[i] = new ImageIcon(jimage[i]);
            jlabel[i] = new JLabel(kimage[i]);
            jlabel[i].setBounds(0,0,1000,600);
            add(jlabel[i]);
        }
        t1 = new Thread(this);
        t1.start();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Destination();
    }
}
