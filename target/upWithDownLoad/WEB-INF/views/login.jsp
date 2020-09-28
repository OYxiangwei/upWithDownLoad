<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-09-28
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/login" method="post" name="loginForm">
        <font color="red">${requestScope.message}</font>
        <table border="1" title="登录" >
            <tr>
                <td> 用户名：</td>
                <td><input type="text" name="inputUsername"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input name="inputPassword" type="password"></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input name="submit" type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
</body>
</html>
