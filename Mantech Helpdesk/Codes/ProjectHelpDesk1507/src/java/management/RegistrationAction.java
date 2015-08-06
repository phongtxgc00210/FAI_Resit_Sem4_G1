/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import static com.opensymphony.xwork2.Action.ERROR;
import com.opensymphony.xwork2.ActionSupport;
import database.ConnectionUtil;
import database.UserConnection;
import entities.Users;
import java.util.Map;
import org.apache.struts2.interceptor.RequestAware;

/**
 *
 * @author Jun
 */
public class RegistrationAction extends ActionSupport{
    
    private String account;
    private String password;
    private String repassword;
    private String fullname;
    private String email;
    private String ret = ERROR;
    
    public RegistrationAction() {
    }
    
    @Override
    public String execute() throws Exception {
        return this.ret;
    }

    @Override
    public void validate() {
        Users user = new Users(account, password, fullname, email);
        UserConnection userConnection = new UserConnection();
        if (!password.equals(repassword)) {
            addActionMessage("Password and re-password is not same!");
        }else  if (userConnection.isExistAccount(account, email)) {
            addActionMessage("Account or email is exsit!");
        }else {
            if (userConnection.createUser(user)) {
                this.ret = SUCCESS;
            }else {
                addActionMessage("Unable to create account, please try again later!");
            }
        }
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

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }
   
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
