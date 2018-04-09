<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>common/css/styles.css">
  </head>
  
  <body>
   <div class="login">
	    <form action="<%=basePath%>register" style="width:260px;text-align:center;" method="post">
	    	${msg}
	    	<fieldset>
	    		<legend>注册</legend>
	    		用户： <input type="text" name="username" style="width:150px;" value=""/><br/><br/>
				密码： <input type="password" name="password" style="width:150px;"/><br/><br/> 
				<input type="submit" value="注册"/>
			    <input type="reset" value="重置"/> 
		    </fieldset>
	    </form>
	    
	    <div style="margin-top:15px;">
			<a href="${pageContext.request.contextPath}/user/loginPage.do">返回</a>
		</div>
    </div>
  </body>
</html>