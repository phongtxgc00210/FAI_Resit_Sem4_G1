<%-- 
    Document   : registration
    Created on : Jul 26, 2015, 11:05:11 PM
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
        <link rel="stylesheet" href="css/registration.css"/>
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
                        <li class="current_page_item"><a href="admin.jsp" accesskey="1" title="">Welcome</a></li>
                        <li><a href="registration.jsp" accesskey="2" title="">Create Account</a></li>
                        <li><a href="pendingComplaintsLog" accesskey="3" title="">Pending-Complaints</a></li>
                        <li><a href="#" accesskey="4" title="">Reports</a></li>
                    </ul>
                </div>
            </div>
            <div id="main">
                <div class="account-info">
                    <h1>Create new account for employees</h1><br />
                    <form action="registrationAction" method="post">
                        <input type="text" name="account" placeholder="Account" required="required" />
                        <input type="password" name="password" placeholder="Password" required="required"/>
                        <input type="password" name="repassword" placeholder="Re-Password" required="required"/>
                        <input type="text" name="fullname" placeholder="Full Name" required="required" />
                        <input type="email" name="email" placeholder="Email" required="required" />
                        <br/>
                        <input type="submit" value="Create" name="create" class="create create-submit"/>
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
