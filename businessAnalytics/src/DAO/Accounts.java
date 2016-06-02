package DAO;


import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Geraldine Atayan
 */
public class Accounts {
    
    /**
     * Register User
     */
    public boolean register(User user) {
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            String query = "insert into accounts"
//                    + "(employeeID,lastName,firstName,email,position,gender,birthDate,leftDate,entryDate,password) "
//                    + "values (?,?,?,?,?,?,?,?,?,password(?))";
                    + "IdAccounts, FirstName, LastName, Division, Birthdate, Type";
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            boolean type = false;
            //Type is true if not part of any division
            if(user.getDivision().equalsIgnoreCase("Others"));
                type = true;

            pstmt.setInt(1, user.getUserID());
            pstmt.setString(2, user.getFirstName());
            pstmt.setString(3, user.getLastName());
            pstmt.setString(4, user.getDivision());
            pstmt.setDate(5, user.getBirthdate());
            pstmt.setBoolean(6, type);
      
             //username, password, employmentdate, etc.
            
            int rows = pstmt.executeUpdate();
            conn.close();
            return rows == 1;
        } catch (SQLException ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     * Login
     * @param User
     * @return 
     */
    public boolean authenticate(User User) {
        boolean valid = false;
        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();

            String query = "select * from accounts where FirstName = ? and LastName = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, User.getEmail());
            pstmt.setString(2, User.getPassword());

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                valid = true;
            }

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valid;
    }
    
    public User getUser(String username, String password) throws ParseException {
        User User = new User();

        try {
            DBConnectionFactory myFactory = DBConnectionFactory.getInstance();
            Connection conn = myFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select * from accounts where "
//                    + "FirstName= ? and LastName= password(?)");
                    + "FirstName = ? and LastName = ?");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                User.setUserID(rs.getInt("employeeID"));
                User.setLastName(rs.getString("lastName"));
                User.setFirstName(rs.getString("firstName"));
                User.setBirthdate(rs.getDate("birthdate"));
                User.setEmail(rs.getString("email"));
                User.setPassword(rs.getString("password"));
            }

            pstmt.close();
            rs.close();
            conn.close();

            return User;
        } catch (SQLException ex) {
            Logger.getLogger(Accounts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
