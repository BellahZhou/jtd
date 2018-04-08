<%--
  Created by IntelliJ IDEA.
  User: xyc
  Date: 2016/8/21 0021
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body style="text-align: center;margin-top: 300px;">
<form method="post" action="${pageContext.request.contextPath}/login">
    <h4>登录模块</h4>
    <div>
        <input type="text" name="username" placeholder="用户名">
        <input type="password" name="password" placeholder="密码">
        <input type="submit" value="登录" name="submit">
    </div>
</form>
	<div>
		<a href="${pageContext.request.contextPath}/user/register.do">注册</a>
	</div>
</bod