/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import DB.DBContext;
import Model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author admin's
 */
public class SignUpDAO extends DBContext {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public Account checkAccountExist(String mail) {
        try {
            String query = "Select * from Account where email = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, mail);
            rs = ps.executeQuery();
            
            while(rs.next()){
                return new Account(rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getInt(5),
                                rs.getInt(6));
            }
        } catch(Exception e) {
            
        }
        return null;
    }
    
    public void signup(String name, String mail, String pass, String checkTeacher){
        String query= "insert into Account(name, email, password, isStudent, isTeacher) values(?,?,?,0,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, mail);
            ps.setString(3, pass);
            ps.setString(4, checkTeacher);
            ps.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
