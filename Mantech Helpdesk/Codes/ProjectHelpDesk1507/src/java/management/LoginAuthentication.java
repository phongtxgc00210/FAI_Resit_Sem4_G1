/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Jun
 */
public class LoginAuthentication extends ActionSupport {

    public LoginAuthentication() {
    }
    
    @Override
    public String execute() throws Exception {
//        Map session = ActionContext.getContext().getSession();
//
//        ActionContext ctx = ActionContext.getContext();
//        HttpServletRequest hsr = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
//        String account = hsr.getParameter("account");
//        String password = hsr.getParameter("password");
//        String role = hsr.getParameter("role");
//        if (account != null && !"".equals(account)) {
//            return SUCCESS;
//        } else {
//            session.clear();
//        }
        return SUCCESS;
    }

}
