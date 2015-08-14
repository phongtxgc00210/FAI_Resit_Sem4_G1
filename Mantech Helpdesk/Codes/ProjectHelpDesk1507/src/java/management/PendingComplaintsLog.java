/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import static com.opensymphony.xwork2.Action.SUCCESS;
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
public class PendingComplaintsLog extends ActionSupport {
    
    private List<Complaint> listComplaintsPending = new ArrayList<>();
    
    public PendingComplaintsLog() {
    }
    
    @Override
    public String execute() throws Exception {        
        ComplaintConnection complaintConnection = new ComplaintConnection();
        listComplaintsPending = complaintConnection.getListComplaintPending();
        
        return SUCCESS;
    }

    public List<Complaint> getListComplaintsPending() {
        return listComplaintsPending;
    }

    public void setListComplaintsPending(List<Complaint> listComplaintsPending) {
        this.listComplaintsPending = listComplaintsPending;
    }
    
}
