<#include "/common/ftl/common.ftl"/>
<@body>
	<div class="tab_frame_body" data-ng-app="indexApp" data-ng-controller="indexCtrl">
		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<img src="${ctx}/common/images/topleft.png">
				</div>
				<div class="col-md-9">
					<h1>The Club of Chicken Soup For The Soul</h1>
					<h3>Independent personality</h3>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-md-12">
					<!-- <img src="http://placehold.it/950x350"> -->
					<p>如果你为错过的太阳而流泪，那么你也将错过整个群星。</p>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<h2>Featured Work</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<img src="${ctx}/common/images/bottom1.png">
					<h2>applify</h2>
					<a href="http://baidu.com">https://github.com/udacity/applify</a>
				</div>
				<div class="col-md-4">
					<img src="${ctx}/common/images/bottom2.png">
					<h2>sunflower</h2>
					<a href="http://baidu.com">https://github.com/udacity/sunflower</a>
				</div>
				<div class="col-md-4">
					<img src="${ctx}/common/images/bottom3.png">
					<h2>bokeh</h2>
					<a href="http://baidu.com">https://github.com/udacity/bokeh</a>
				</div>
			</div>
		</div>
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