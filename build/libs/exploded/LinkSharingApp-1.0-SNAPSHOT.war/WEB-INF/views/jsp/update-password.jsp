<%--
  Created by IntelliJ IDEA.
  User: Lenovo-1
  Date: 18-07-2017
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Link Sharing</title>
</head>
<body>
<h3>Update password</h3>
<form action="/password_update" method="post">
    <label>New Password : </label>
    <input type="password" name="pswd"/>
    <label>Confirm Password : </label>
    <input type="password" name="cpswd"/>
    <input type="hidden" name="email" value="${email}"/>
    <input type="submit"/>
</form>
</body>
</html>
