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
public class Complaint {

    private int complaintID;
    private String complaintTitle;
    private String complaintDetails;
    private String createDate;
    private String complaintStatus;
    private int userID;

    public Complaint() {
    }

    public Complaint(int complaintID, String complaintTitle, String complaintDetails, String createDate, String complaintStatus, int userID) {
        this.complaintID = complaintID;
        this.complaintTitle = complaintTitle;
        this.complaintDetails = complaintDetails;
        this.createDate = createDate;
        this.complaintStatus = complaintStatus;
        this.userID = userID;
    }

    public Complaint(String complaintTitle, String complaintDetails, int userID) {
        this.complaintTitle = complaintTitle;
        this.complaintDetails = complaintDetails;
        this.userID = userID;
    }

    public int getComplaintID() {
        return complaintID;
    }

    public void setComplaintID(int complaintID) {
        this.complaintID = complaintID;
    }

    public String getComplaintTitle() {
        return complaintTitle;
    }

    public void setComplaintTitle(String complaintTitle) {
        this.complaintTitle = complaintTitle;
    }

    public String getComplaintDetails() {
        return complaintDetails;
    }

    public void setComplaintDetails(String complaintDetails) {
        this.complaintDetails = complaintDetails;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getComplaintStatus() {
        return complaintStatus;
    }

    public void setComplaintStatus(String complaintStatus) {
        this.complaintStatus = complaintStatus;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    
}
