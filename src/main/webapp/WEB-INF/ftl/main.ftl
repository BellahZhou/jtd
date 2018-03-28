<#include "/common/ftl/common.ftl"/>
<@body class="main_body">
<nav class="navbar navbar-blue" sytyle="margin-bottom: 0px;margin-bottom:0px;" role="navigation">

    <div class="navbar-header">
        <a href=""></a>
    </div>

    <ul class="nav navbar-nav pull-right">
        <li><a>欢迎&nbsp;<b style="color: #fff;">${user.username}</b>&nbsp;登录</a></li>
        <li><a href="${ctx}/index.do"><span class="glyphicon glyphicon-home"></span> 返回首页</a></li>
        <li><a href="${ctx}/unifiedlogout.do"><span class="glyphicon glyphicon-log-out"></span> 退出登录</a></li>
    </ul>

</nav>
<style>
.slide_bar .list-group  .list-group a.padl_60{ padding-left:60px;}
</style>
<div data-ng-app="indexApp" data-ng-controller="indexCtrl" ng-cloak>
    

    <ol class="breadcrumb">
        <li><a href="${ctx}/index.do">首页</a></li>
        <li><a href="${ctx}/index.do">系统主页面</a></li>
        <li ng-bind="menus.menuName"></li>
        <li ng-if="clickppM" ng-bind="clickppM.menuName"></li>
        <li ng-if="clickpM" ng-bind="clickpM.menuName"></li>
        <li ng-if="clickMenu" class="active" ng-bind="clickMenu.menuName"></li>
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
            	var href = data[0].url + "?menuId=" + data[0].id;
                $scope.iframeSrc = "${ctx}" + href;
            });

        }]);

    </script>
    </@javascript>
</@body>