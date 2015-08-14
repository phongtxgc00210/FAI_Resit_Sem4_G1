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
import java.util.Map;

/**
 *
 * @author Jun
 */
public class CreateComplaint extends ActionSupport {
    
    String title;
    String complaintDetails;
    private String ret = ERROR;
    
    public CreateComplaint() {
    }
    
    @Override
    public String execute() throws Exception {
        return ret;
    }

    @Override
    public void validate() {
        Map session = ActionContext.getContext().getSession();
        int userID = Integer.parseInt(session.get("userid").toString());
        Complaint c = new Complaint(title, complaintDetails, userID);
        
        if (c.getComplaintTitle().length() < 5) {
            addActionMessage("Minimum length of title is 5 character");
        }else if (c.getComplaintDetails().length() < 10) {
            addActionMessage("Minimum length of complaint is 10 character");
        }else {
            ComplaintConnection complaintConnection = new  ComplaintConnection();
            if (complaintConnection.createComplaint(c)) {
                this.ret = SUCCESS;
            }else {
                addActionMessage("Unable to create create new complaint, please try again later.");
            }
        }
    } 

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComplaintDetails() {
        return complaintDetails;
    }

    public void setComplaintDetails(String complaintDetails) {
        this.complaintDetails = complaintDetails;
    }
}
