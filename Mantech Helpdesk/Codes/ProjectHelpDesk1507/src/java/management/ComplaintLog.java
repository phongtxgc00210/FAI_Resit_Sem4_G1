/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import database.ComplaintConnection;
import entities.Complaint;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jun
 */
public class ComplaintLog extends ActionSupport {
    
    private List<Complaint> listComplaints = new ArrayList<>();
    
    public ComplaintLog() {
    }
    
    @Override
    public String execute() throws Exception {
        
        Map session = ActionContext.getContext().getSession();
        int userID = Integer.parseInt(session.get("userid").toString());
        
        ComplaintConnection complaintConnection = new ComplaintConnection();
        listComplaints = complaintConnection.getListComplaint(userID);
        
        return SUCCESS;
    }

    public List<Complaint> getListComplaints() {
        return listComplaints;
    }

    public void setListComplaints(List<Complaint> listComplaints) {
        this.listComplaints = listComplaints;
    }
    
}
