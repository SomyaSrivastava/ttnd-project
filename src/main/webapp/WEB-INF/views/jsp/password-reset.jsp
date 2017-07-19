<%--
  Created by IntelliJ IDEA.
  User: Lenovo-1
  Date: 18-07-2017
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reset password</title>
</head>
<body>

<h1>RESET PASSWORD</h1>
<form method="post" action="/email-notification">
    <span>
    <label>Enter registered Email Address : </label>
    <input type="text" name="email"/>
    </span>
    <input type="hidden" value="${email}" />
    <input type="submit"/>
    ${msg}
</form>
</body>
</html>
