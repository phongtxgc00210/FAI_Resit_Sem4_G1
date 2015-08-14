<%-- 
    Document   : complaint-log
    Created on : Aug 1, 2015, 9:39:43 PM
    Author     : Jun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <link rel="stylesheet" href="css/admin.css" />
        <link rel="stylesheet" href="css/complaint-log.css"/>
        <title>Registration's page</title>
    </head>
    <body>
        <div id="page" class="container">
            <div id="header">
                <div id="logo">
                    <img src="http://i.imgur.com/zHJ64Cg.jpg" alt="" />
                    <h1><a href="#">${username}</a></h1>
                    <span><a href="<s:url action="logoutAction"/>">log out</a></span>
                </div>
                <div id="menu">
                    <ul>
                        <li><a href="user.jsp" accesskey="1" title="">Welcome</a></li>
                        <li><a href="new-complaint.jsp" accesskey="2" title="">Lodge a new complaint</a></li>
                        <li class="current_page_item"><a href="displayComplaintLog.action" accesskey="3" title="">Complaint log</a></li>
                        <li><a href="#" accesskey="4" title="">Profiles</a></li>
                    </ul>
                </div>
            </div>
            <div id="main">
                <div class="complaint-info">
                    <h1>Pending complaint log</h1><br />
                    <table border="1" >
                        <tr>
                            <td>Complaint ID</td>
                            <td>Title</td> 
                            <td>Complaint Details</td>
                            <td>Create Date</td>
                            <td>Status</td>
                        </tr>
                        <s:iterator value="listComplaints">
                            <tr>
                                <td>
                                    <s:property value="complaintID" />
                                </td>
                                <td>
                                    <s:property value="complaintTitle" />
                                </td>
                                <td>
                                    <s:property value="complaintDetails" />
                                </td>
                                <td>
                                    <s:property value="createDate" />
                                </td>
                                <td>
                                    <s:property value="complaintStatus" />
                                </td>
                            </tr>
                        </s:iterator>
                    </table>
                </div>
                <div id="copyright">
                    <span>Copyright © 2015 <a href="#">FGR's Group</a> | Project sem 4</span>
                </div>
            </div>
        </div>
    </body>
</html>
