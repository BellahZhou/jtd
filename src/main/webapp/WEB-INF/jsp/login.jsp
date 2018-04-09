<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html style="height:100%;
    overflow:hidden;">
<head>
    <title>登录</title>
</head>
<body style="background:url(${pageContext.request.contextPath}/common/images/logo.png) no-repeat center;
    background-size: cover;">
    <div style="height: 280px;
    width: 350px;
    padding: 40px;
    background-color: #ffffff;
    border-radius: 4px;
    box-sizing: border-box;
	  position: absolute; 
	  left: 50%; top: 50%;    
	  transform: translate(-50%, -50%);">
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
	</div>
</body>