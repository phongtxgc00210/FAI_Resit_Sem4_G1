<%-- 
    Document   : user
    Created on : Jul 26, 2015, 3:55:50 PM
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
        <title>User's page</title>
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
                        <li class="current_page_item"><a href="user.jsp" accesskey="1" title="">Welcome</a></li>
                        <li><a href="#" accesskey="2" title="">Lodge a new complaint</a></li>
                        <li><a href="#" accesskey="3" title="">Complaint log</a></li>
                        <li><a href="#" accesskey="4" title="">Profiles</a></li>
                    </ul>
                </div>
            </div>
            <div id="main">
                <div id="banner">
                    <img src="http://i.imgur.com/oGwbV9D.png" alt="" class="image-full" />
                </div>
                <div id="welcome">
                    <div class="title">
                        <h2>Welcome to Mantech Help Desk</h2>
                        <span class="byline">Chúng ta cùng tận hưởng một hệ thống Help Desk tuyệt vời</span>
                    </div>
                    <p>the news</p>
                </div>
                
                <div id="copyright">
                    <span>Copyright © 2015 <a href="#">FGR's Group</a> | Project sem 4</span>
                </div>
            </div>
        </div>
    </body>
</html>
