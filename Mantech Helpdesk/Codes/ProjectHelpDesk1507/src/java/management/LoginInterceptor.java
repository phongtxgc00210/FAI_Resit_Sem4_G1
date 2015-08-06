/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import java.util.Map;

/**
 *
 * @author Jun
 */
public class LoginInterceptor implements Interceptor {

    @Override
    public void destroy() {
        System.out.println("Destroying MyLoggingInterceptor...");
    }

    @Override
    public void init() {
        System.out.println("Initializing MyLoggingInterceptor...");
    }

    @Override
    public String intercept(ActionInvocation ai) throws Exception {
        Map<String, Object> sessionAttributes = ai
                .getInvocationContext().getSession();
        if (sessionAttributes == null
                || sessionAttributes.get("account") == null
                || sessionAttributes.get("account").equals("")) {

            return "login";
        } else {
            if (!((String) sessionAttributes.get("account")).equals(null)
                    || !((String) sessionAttributes.get("account")).equals("")) {

                return ai.invoke();
            } else {

                return "login";
            }
        }
    }

}
