/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Jun
 */
public class Users {
    
    private int userID;
    private String userAccount;
    private String userPassword;
    private String userName;
    private String userEmail;
    private int userRole;

    public Users() {
    }

    public Users(String userPassword, String userName) {
        this.userPassword = userPassword;
        this.userName = userName;
    }

    public Users(int userID, String userAccount, String userPassword, String userName, String userEmail, int userRole) {
        this.userID = userID;
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userRole = userRole;
    }

    public Users(String userAccount, String userPassword, String userName, String userEmail) {
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userEmail = userEmail;
    }
    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }
}
