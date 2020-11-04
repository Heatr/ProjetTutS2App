/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logindatabase;
import java.sql.*;
import javax.swing.*;


/**
  * class that deals with the User information of the database
 * @author Alexandre
 * @version 11.2
 */
public class UserDao {
    private Connection conn=null;
    private PreparedStatement pst=null;
    private ResultSet rs=null;
    
    public static Connection ConnectDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","root");
            //JOptionPane.showMessageDialog(null,"Connected to database");
            return conn;
            
            
        }
    catch (Exception e){
    JOptionPane.showMessageDialog(null,e);
    return null;
    }
    
    }  
}
