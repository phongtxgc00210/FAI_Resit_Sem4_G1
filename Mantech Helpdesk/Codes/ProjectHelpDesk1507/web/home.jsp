<%-- 
    Document   : home
    Created on : Jul 26, 2015, 3:49:00 PM
    Author     : Jun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/general.css" />
        <link rel="stylesheet" href="css/homecss.css" />
        <title>Mantech Limited</title>
    </head>
    <body>
        <div class="login-card">
            <h1>Mantech Limited</h1><br />
            <form action="loginAction" method="post">
                <input type="text" name="account" placeholder="Account" required="required" />
                <input type="password" name="password" placeholder="Password" required="required"/><br/>
                <input type="submit" value="Login" name="login" class="login login-submit"/>		
            </form>
            <div class="login-help">
                • <a href="#">Forgot Password</a> •
            </div>
            <s:if test="hasActionMessages()">
                <div class="welcome" style="color: red">
                    <s:actionmessage/>
                </div>
            </s:if>
        </div>
    </body>
</html>
