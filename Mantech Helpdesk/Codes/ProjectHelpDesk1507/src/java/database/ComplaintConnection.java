/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import entities.Complaint;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jun
 */
public class ComplaintConnection {

    private ConnectionUtil connectionUtil;

    public ComplaintConnection() {
        this.connectionUtil = new ConnectionUtil();
    }

    public boolean createComplaint(Complaint complaint) {
        boolean result = false;
        try {
            Connection conn = this.connectionUtil.getConnection();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("INSERT INTO Complaints(ComplaintTitle,ComplaintDetails,UserID) VALUES(N'");
            stringBuilder.append(complaint.getComplaintTitle());
            stringBuilder.append("',N'");
            stringBuilder.append(complaint.getComplaintDetails());
            stringBuilder.append("','");
            stringBuilder.append(complaint.getUserID());
            stringBuilder.append("')");
            String insert = stringBuilder.toString();

            CallableStatement callableStatement = conn.prepareCall(insert);
            callableStatement.executeUpdate();
            callableStatement.close();
            result = true;
        } catch (SQLException ex) {
//            Logger.getLogger(HomeConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public List<Complaint> getListComplaint(int userID) {
        List<Complaint> l = new ArrayList<>();
        try {
            Connection conn = this.connectionUtil.getConnection();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SELECT * FROM Complaints");
            if (userID > 0) {
                stringBuilder.append(" WHERE UserID='");
                stringBuilder.append(userID);
                stringBuilder.append("'");
            }
            String callStr = stringBuilder.toString();

            CallableStatement csmt = conn.prepareCall(callStr);
            ResultSet rs = csmt.executeQuery();
            while (rs.next()) {
                int complaintID = rs.getInt("ComplaintID");
                String complaintTitle = rs.getNString("ComplaintTitle");
                String complaintDetails = rs.getNString("ComplaintDetails");

                Date d = rs.getDate("CreateDate");
                DateFormat df = new SimpleDateFormat("dd MMMM yyyy");
                String createDate = df.format(d);

                String complaintStatus = rs.getNString("ComplaintStatus");
                int userSentComplaint = rs.getInt("UserID");
                Complaint complaint = new Complaint(complaintID, complaintTitle, complaintDetails, createDate, complaintStatus, userSentComplaint);
                l.add(complaint);
            }
            rs.close();
            csmt.close();
        } catch (SQLException ex) {
//            Logger.getLogger(HomeConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public List<Complaint> getListComplaintPending() {
        List<Complaint> l = new ArrayList<>();
        try {
            Connection conn = this.connectionUtil.getConnection();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SELECT * FROM Complaints");
            stringBuilder.append(" WHERE ComplaintStatus='pending' ORDER BY CreateDate DESC");
            String callStr = stringBuilder.toString();

            CallableStatement csmt = conn.prepareCall(callStr);
            ResultSet rs = csmt.executeQuery();
            while (rs.next()) {
                int complaintID = rs.getInt("ComplaintID");
                String complaintTitle = rs.getNString("ComplaintTitle");
                String complaintDetails = rs.getNString("ComplaintDetails");

                Date d = rs.getDate("CreateDate");
                DateFormat df = new SimpleDateFormat("dd MMMM yyyy");
                String createDate = df.format(d);

                String complaintStatus = rs.getNString("ComplaintStatus");
                int userSentComplaint = rs.getInt("UserID");
                Complaint complaint = new Complaint(complaintID, complaintTitle, complaintDetails, createDate, complaintStatus, userSentComplaint);
                l.add(complaint);
            }
            rs.close();
            csmt.close();
        } catch (SQLException ex) {
//            Logger.getLogger(HomeConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }
}
