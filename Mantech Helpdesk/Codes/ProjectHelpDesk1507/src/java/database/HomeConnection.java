/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import entities.Users;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.struts2.interceptor.RequestAware;

/**
 *
 * @author Jun
 */
public class HomeConnection extends ActionSupport implements RequestAware {

    private final ConnectionUtil connectionUtil;
    private String account;
    private String password;
    private String ret = ERROR;
    Map<String, Object> requestMap;

    public HomeConnection() {
        this.connectionUtil = new ConnectionUtil();
    }

    public Users loginAction() {
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
            Logger.getLogger(HomeConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void setRequest(Map<String, Object> map) {
        this.requestMap = map;
    }

    @Override
    public void validate() {
        // Check User exist!
        Users u = loginAction();
        if (u != null) {
            Map session = ActionContext.getContext().getSession();
            String userName = u.getUserName();
            String userAccount = u.getUserAccount();
            session.put("username", userName);
            session.put("useraccount", userAccount);
            session.put("userid", u.getUserID());
            if (u.getUserRole() == 1) {
                this.ret = "admin";
                session.put("userrole", "admin");
            } else if (u.getUserRole() == 3) {
                this.ret = "technical";
                session.put("userrole", "technical");
            } else {
                this.ret = "user";
                session.put("userrole", "user");
            }
        } else {
            addActionMessage("Incorrect account or password!");
        }
    }

    @Override
    public String execute() throws Exception {
        return this.ret;
    }

    // Properties
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
