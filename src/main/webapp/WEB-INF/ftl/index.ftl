<#include "/common/ftl/common.ftl"/>
<@body>
	<nav class="navbar navbar-yellow" role="navigation" style="margin-bottom: 0px;">
		<div class="navbar-header">
	        <a class="navbar-brand"  href="${ctx}/index.do">鸡汤店</a>
	    </div>
	  	<ul class="nav navbar-nav pull-right">
	        <li><a>Hi,${user}&nbsp;</a></li>
	        <li><a href="${ctx}/unifiedlogout.do"><span class="glyphicon glyphicon-log-out"></span> 退出登录</a></li>
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
	        var indexApp = angular.module("indexApp", ["commApp"]);
	        indexApp.controller("indexCtrl", ['$scope', '$Ajax', function ($scope, $Ajax) {
	            $Ajax({
	            	type: "POST",
	            	url: "${ctx}/getTopMenus.do"
	            }).then(function (data) {
	                $scope.menus = data;
	            });
	            
	            
	            $scope.goPage = function (x) {
	                if(x.hasAuth === '1'){
	                    window.location.href = "${ctx}/menu_index_" + x.id + ".do";
	                }
	            };
	            
	        }]);
	    </script>
    </@javascript>
</@body>