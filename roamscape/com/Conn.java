package roamscape.com;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Pass name and password of database
            c = DriverManager.getConnection("jdbc:mysql:///travel","root","raj28");
            s = c.createStatement();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
