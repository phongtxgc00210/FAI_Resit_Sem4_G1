/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import entities.Users;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jun
 */
public class UserConnection {

    private ConnectionUtil connectionUtil;

    public UserConnection() {
        this.connectionUtil = new ConnectionUtil();
    }

    public boolean createUser(Users user) {
        boolean result = false;
        try {
            Connection conn = this.connectionUtil.getConnection();
            String insert = "INSERT INTO Users(UserAccount,UserPassword,UserName,UserEmail) VALUES('";
            insert += user.getUserAccount() + "','";
            insert += user.getUserPassword() + "','";
            insert += user.getUserAccount() + "','";
            insert += user.getUserEmail() + "')";
            CallableStatement callableStatement = conn.prepareCall(insert);
            callableStatement.executeUpdate();
            callableStatement.close();
            result = true;
        } catch (SQLException ex) {
            Logger.getLogger(HomeConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public Users loginAction(String account, String password) {
        Users user = null;
        try {
            Connection conn = this.connectionUtil.getConnection();
            CallableStatement csmt = conn.prepareCall("SELECT * FROM Users WHERE UserAccount='" + account + "' AND UserPassword='" + password + "'");
            ResultSet rs = csmt.executeQuery();
            if (rs.next()) {
                int userID = rs.getInt("UserID");
                String userAccount = rs.getNString("UserAccount");
                String userPassword = rs.getNString("UserPassword");
                String userName = rs.getNString("UserName");
                String userEmail = rs.getNString("UserEmail");
                int userRole = rs.getInt("UserRole");

                user = new Users(userID, userAccount, userPassword, userName, userEmail, userRole);
            } else {
                user = null;
            }
            rs.close();
            csmt.close();
            return user;
        } catch (SQLException ex) {
//            Logger.getLogger(HomeConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean isExistAccount(String account, String email) {
        boolean result = true;
        try {
            Connection conn = this.connectionUtil.getConnection();
            CallableStatement csmt = conn.prepareCall("SELECT * FROM Users WHERE UserAccount='" + account + "' OR UserEmail='" + email + "'");
            ResultSet rs = csmt.executeQuery();
            if (rs.next()) {
                result = true;
            } else {
                result = false;
            }
            rs.close();
            csmt.close();
        } catch (SQLException ex) {
//            Logger.getLogger(HomeConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
