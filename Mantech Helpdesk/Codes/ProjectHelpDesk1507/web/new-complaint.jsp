<%-- 
    Document   : new-complaint
    Created on : Aug 1, 2015, 3:05:21 PM
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
        <link rel="stylesheet" href="css/new-complaint.css"/>
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
                        <li class="current_page_item"><a href="new-complaint.jsp" accesskey="2" title="">Lodge a new complaint</a></li>
                        <li><a href="displayComplaintLog" accesskey="3" title="">Complaint log</a></li>
                        <li><a href="#" accesskey="4" title="">Profiles</a></li>
                    </ul>
                </div>
            </div>
            <div id="main">
                <div class="complaint-info">
                    <h1>Create new complaint</h1><br />
                    <form action="createComplaintAction" method="post">
                        <input type="text" name="title" placeholder="Input your complaint title" required="required" />
                        <textarea name="complaintDetails" required="required"></textarea>
                        <br/>
                        <br/>
                        <input type="submit" value="Create new complaint" name="create" class="create create-submit"/>
                    </form>
                    <s:if test="hasActionMessages()">
                        <div style="color: red">
                            <s:actionmessage/>
                        </div>
                    </s:if>
                </div>
                <div id="copyright">
                    <span>Copyright © 2015 <a href="#">FGR's Group</a> | Project sem 4</span>
                </div>
            </div>
        </div>
    </body>
</html>
