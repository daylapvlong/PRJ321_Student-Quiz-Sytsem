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
public class LoginDAO extends DBContext {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public Account checkLogin(String mail, String pass) {
        try {
            String query = "Select * from Account where email = ? and password = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, mail);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            
            while(rs.next()){
//                System.out.println(rs.getInt(1));
//                return null;
                return new Account(rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getInt(5),
                                rs.getInt(6));
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public static void main(String[] args) {
        System.out.println(new LoginDAO().checkLogin("johndoe@example.com", "password123"));
    }
}
