/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logindatabase;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * class that deals with the Activity information of the database
 * @author Alexandre
 * @version 11.2
 */
public class ActivityDao {
    private Connection conn= UserDao.ConnectDB();
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    
    /**
     * fonction that return all the description of the task of a given technician
     * @param id id of the technician
     * @return description of the tasks of a technician
     */
    public ArrayList<String> readProject(int id){
        
        ArrayList<String> strs = new ArrayList<>();
        ArrayList<Integer> ids = new ArrayList<>();
        String Sql="Select activitéID from affecté where (technicienID = ?)";
        try{
            pst=conn.prepareStatement(Sql);
            pst.setString(1,Integer.toString(id));
            rs=pst.executeQuery();
            while (rs.next()){
                ids.add(rs.getInt("activitéID"));
            }
            pst.close();
            
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
            
        }
    
        String Sql2="Select résumé FROM activité where (ID = ?) ";
         try{
            pst=conn.prepareStatement(Sql2);
            for (Integer i:ids){
                pst.setString(1,Integer.toString(i));
                rs=pst.executeQuery();
                if (rs.next()){
                    strs.add(rs.getString("résumé"));
                }
            }
            pst.close();
            
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
            
        }
         
        return strs;
    }
}
