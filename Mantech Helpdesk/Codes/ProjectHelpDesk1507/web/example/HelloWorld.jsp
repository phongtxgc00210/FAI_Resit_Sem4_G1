<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
        
    </head>

    <body>
        <form action="loginAction" method="post">
            Account: <br/><input type="text" name="account"/><br/>
            Password:<br/><input type="password" name="password"/><br/>
            <input type="submit" value="Login"/>		
        </form>
    </body>
</html>

