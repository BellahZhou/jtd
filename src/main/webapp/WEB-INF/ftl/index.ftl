<#include "/common/ftl/common.ftl"/>
<@body>
<nav class="navbar navbar-yellow" role="navigation" style="margin-bottom: 0px;">
	<div class="navbar-header">
        <a class="navbar-brand"  href="${ctx}/index.shtml">鸡汤店</a>
    </div>
  	<ul class="nav navbar-nav pull-right">
        <li><a>欢迎&nbsp;<b style="color: #fff;">${user.username}</b>&nbsp;登录</a></li>
        <li><a href="${ctx}/unifiedlogout.shtml"><span class="glyphicon glyphicon-log-out"></span> 退出登录</a></li>
    </ul>
</nav>

<div data-ng-app="indexApp" data-ng-controller="indexCtrl" ng-cloak class="index_page">
    <ul class="index_link">
        <li ng-repeat="x in menus"><a style="cursor: pointer;" ng-if="x.menuIcon" ng-click="goPage(x)" ng-class="{'link_dis':x.hasAuth === '0'}"><img ng-src="${ctx}/common/images/{{x.menuIcon}}_b.png">
            <span ng-if="x.showTodo" class="dot"></span>
            <h3 ng-bind="x.menuName"></h3><i></i></a></li>
            
    </ul>
</div>
	

	<@javascript>
	    <script type="text/javascript">
	        var indexApp = angular.module("indexApp", ["commApp","ngTouch"]);
	        indexApp.controller("indexCtrl", ['$scope', '$Ajax','$swipe','$timeout', function ($scope, $Ajax,$swipe,$timeout) {
	            $Ajax({url: "${ctx}/getTopMenus.do"}).then(function (data) {
	                $scope.menus = data;
	            	
	            });
	            
	            
	            $scope.goPage = function (x) {
	                if(x.hasAuth === '1'){
	                    window.location.href = "${ctx}/menu_index_" + x.id + ".shtml";
	                }
	            };
	            
	        }]);
	    </script>
    </@javascript>
</@body>