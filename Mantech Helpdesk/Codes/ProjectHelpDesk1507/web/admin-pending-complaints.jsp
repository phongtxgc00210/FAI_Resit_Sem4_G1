<%-- 
    Document   : admin-pending-complaints
    Created on : Aug 8, 2015, 4:27:02 AM
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
        <title>Admin's page</title>
    </head>
    <body>
        <s:action name="authentication" executeResult="true"/>
        <div id="page" class="container">
            <div id="header">
                <div id="logo">
                    <img src="http://i.imgur.com/zHJ64Cg.jpg" alt="" />
                    <h1><a href="#">${username}</a></h1>
                    <span><a href="<s:url action="logoutAction"/>">log out</a></span>
                </div>
                <div id="menu">
                    <ul>
                        <li><a href="admin.jsp" accesskey="1" title="">Welcome</a></li>
                        <li><a href="registration.jsp" accesskey="2" title="">Create Account</a></li>
                        <li class="current_page_item"><a href="pendingComplaintsLog" accesskey="3" title="">Pending-Complaints</a></li>
                        <li><a href="#" accesskey="4" title="">Reports</a></li>
                    </ul>
                </div>
            </div>
            <div id="main">
                <div class="complaint-info">
                    <h1>Your complaint log</h1><br />
                    <table border="1" >
                        <tr>
                            <td>Complaint ID</td>
                            <td>Title</td> 
                            <td>Complaint Details</td>
                            <td>Create Date</td>
                            <td>Status</td>
                            <td></td>
                        </tr>
                        <s:iterator value="listComplaintsPending">
                            <tr>
                            <form action="registrationAction" method="post">
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
                                <td>
                                    <input type="submit" value="Assign" name="assign" class="create create-submit" />
                                </td>
                            </form>
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