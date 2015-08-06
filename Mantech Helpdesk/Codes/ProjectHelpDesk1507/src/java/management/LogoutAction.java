/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

/**
 *
 * @author Jun
 */
public class LogoutAction extends ActionSupport {
    
    public LogoutAction() {
    }
    
    @Override
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        session.clear();
        return SUCCESS;
    }
    
}
