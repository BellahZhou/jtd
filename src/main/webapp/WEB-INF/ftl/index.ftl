<#include "/common/ftl/common.ftl"/>
<nav class="navbar navbar-blue" role="navigation">
	<div class="navbar-header">
        <a href="${ctx}/index.shtml"><img src="${ctx}/common/images/logo.png"></a>
    </div>
  	<ul class="nav navbar-nav pull-right">
        <li><a>欢迎&nbsp;<b style="color: #fff;">${user.username}</b>&nbsp;登录</a></li>
        <li><a href="${ctx}/unifiedlogout.shtml"><span class="glyphicon glyphicon-log-out"></span> 退出登录</a></li>
    </ul>

</nav>