<#include "/common/ftl/common.ftl"/>
<@body>
	<div data-ng-app="indexApp" data-ng-controller="indexCtrl">
		
		
		
	</div>



	<@javascript>
	<script type="text/javascript">
	    var indexApp = angular.module("indexApp", ["commApp"]);
	    indexApp.controller("indexCtrl", ['$scope','$Ajax',function ($scope,$Ajax) {
	    	$Ajax({url: "${ctx}/wz.do"}).then(function (data) {
	    		$scope.list=data;
	    	});
	
	    }]);
	</script>
	</@javascript>
</@body>