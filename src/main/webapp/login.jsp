<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authorize access="hasRole('ADD')">
<a href="/XXX/add">增加</a>
</sec:authorize> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>登录</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/common/css/login.css">
	    <script type="text/javascript" src="${pageContext.request.contextPath}/common/js/jquery-1.11.1.min.js"></script>
		
	</head>
<body>
	<div class="login login_box">
		<form action="${pageContext.request.contextPath}/user/login.do" method="post" id="myLoginForm">
			<label>账号：</label>
			<input type="text" id="username" name="username" placeholder="请输入账号" /><br/>
			<hr class="hr15">
			<label>密码：</label>
			<input type="password" id="password" name="password" placeholder="请输入密码" /><br/>
			<hr class="hr15">
        	<hr class="hr15">
			<input type="submit" style="width:100%;" value="提交" />
			<hr class="hr15">
			<input type="reset" style="width:100%;" value="重置" />
			
			<div class="error_text"> ${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message} </div>
		</form>
	 </div>
	 <script type="text/javascript">
	    $(document).ready(function () {
	        //对登录按钮注册键盘事件
	        document.onkeydown = function (e) {
	            //捕捉回车事件
	            var ev = (typeof event != 'undefined') ? window.event : e;
	            if (ev.keyCode == 13) {
	                login();
	            }
	        };
	    });
	
	    if (self != top) {
	        top.location = window.location;
	    }
	
	    function login() {
	        if (!$("#username").val()) {
	            alert('请输入用户名');
	            return;
	        }
	        if (!$("#password").val()) {
	            alert('请输入密码');
	            return;
	        }
	        if (!/^[a-zA-Z0-9_]{2,30}$/.test($("#username").val())) {
	            alert('用户名只能包含英文数字或下划线');
	            return;
	        }
	        $("#myLoginForm").submit();
	    }
	
	</script>
</body>
</html>