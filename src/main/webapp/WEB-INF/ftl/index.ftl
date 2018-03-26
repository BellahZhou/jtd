<#include "/common/ftl/common.ftl"/>
<@body>
<nav class="navbar navbar-default" role="navigation" style="margin-bottom: 0px;">
	<div class="navbar-header">
        <a class="navbar-brand"  href="${ctx}/index.shtml">鸡汤店</a>
    </div>
  	<ul class="nav navbar-nav pull-right">
        <li><a>欢迎&nbsp;<b style="color: #fff;">${user.username}</b>&nbsp;登录</a></li>
        <li><a href="${ctx}/unifiedlogout.shtml"><span class="glyphicon glyphicon-log-out"></span> 退出登录</a></li>
    </ul>
</nav>

<style>
.main{
    background:url("${ctx}/common/images/warm.png") no-repeat center;
    background-size: cover;
}
</style>

<div class="main" data-ng-app="indexApp" data-ng-controller="indexCtrl">
       <div ng-repeat="x in menus" style="width:300px;height:160px;aligh:center;">
       	<img  id="x.sortNo" ng-src="${ctx}/common/images/{{x.menuIcon}}_b.png" class="img-circle" style="width:100px;height:100px">
           <h3 ng-bind="x.menuName"></h3>
       </div>
</div>
	

	<@javascript>
	    <script type="text/javascript">
	        var indexApp = angular.module("indexApp", ["commApp","ngTouch"]);
	        indexApp.controller("indexCtrl", ['$scope', '$Ajax','$swipe','$timeout', function ($scope, $Ajax,$swipe,$timeout) {
	            $Ajax({url: "${ctx}/getTopMenus.do"}).then(function (data) {
	                $scope.menus = data;
	            	
	            });
	            
	            $swipe.bind($("#123"),{
	            	'move':function(){
	            		debugger
	            		$("#1").css("display","none");
	            		$timeout(function(){
	            			$("#2").css("display","block");
	            		})
	            	}
	            });
	            
	            
	        }]);
	    </script>
    </@javascript>
</@body>