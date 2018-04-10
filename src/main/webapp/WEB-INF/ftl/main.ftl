<#include "/common/ftl/common.ftl"/>
<@body class="main_body">
<nav class="navbar navbar-blue" sytyle="margin-bottom: 0px;margin-bottom:0px;" role="navigation">

    <div class="navbar-header">
        <a href=""></a>
    </div>

    <ul class="nav navbar-nav pull-right">
        <li><a>Hi,${user.username}</b>&nbsp;</a></li>
        <li><a href="${ctx}/index.do"><span class="glyphicon glyphicon-home"></span> 返回首页</a></li>
        <li><a href="${ctx}/logout.do"><span class="glyphicon glyphicon-log-out"></span> 退出登录</a></li>
    </ul>

</nav>
<style>
.slide_bar .list-group  .list-group a.padl_60{ padding-left:60px;}
</style>
<div data-ng-app="indexApp" data-ng-controller="indexCtrl" ng-cloak>
    

    <ol class="breadcrumb">
        <li><a href="${ctx}/index.do">首页</a></li>
        <li><a href="${ctx}/index.do">系统主页面</a></li>
       	<li ><a href="javascript:void(0)" ng-click="link(menus)">{{menus.menuName}}</a></li>
       	<span> :</span>
       	<span ng-repeat="menu in menus.nodes">
			<a href="javascript:void(0)" ng-click="link(menu)"><span>{{menu.menuName}}<span ng-if="menus.nodes && $index!=(menus.nodes.length-1)">、</span></span></a>
		</span>
    </ol>

    <div class="main_page">
        <iframe frameborder="0" scrolling="no" ng-src="{{iframeSrc}}" class="frame_page"></iframe>
    </div>
</div>
    <@javascript>
    <script type="text/javascript">

        var indexApp = angular.module("indexApp", ["commApp"]);
        indexApp.controller("indexCtrl", ['$scope', '$Ajax', function ($scope, $Ajax) {
           
            $Ajax({url: "${ctx}/getMenuTree.do", type: "POST", data: {menuId: '${topMenu.id}'}}).then(function (data) {
            	 $scope.menus = data[0];
            	 var href = data[0].url + "?menuId=" + data[0].id;
            	 $scope.mainHref="${ctx}" + href;
                 $scope.iframeSrc = "${ctx}" + href;
            });
            
            $scope.link=function(menu){
            	var href = menu.url + "?menuId=" + menu.id;
                $scope.iframeSrc = "${ctx}" + href;
            }
        }]);

    </script>
    </@javascript>
</@body>