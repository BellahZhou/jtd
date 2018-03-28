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
					<h3>Running out of time</h3>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-md-12">
					<!-- <img src="http://placehold.it/950x350"> -->
					<p>“小时候每当我生病，母亲都会为我冲一杯咖啡，她温柔地说：“外国人都喝这个的。
”幼小的我总害怕咖啡，酸甜苦涩交错。如今我走遍米萝、上岛、星巴克都找不到小时候喝的那个味道，
直到那天我喝了一杯板蓝根。” </p>
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
					<a href="https://github.com/udacity/applify">https://github.com/udacity/applify</a>
				</div>
				<div class="col-md-4">
					<img src="${ctx}/common/images/bottom2.png">
					<h2>sunflower</h2>
					<a href="https://github.com/udacity/sunflower">https://github.com/udacity/sunflower</a>
				</div>
				<div class="col-md-4">
					<img src="${ctx}/common/images/bottom3.png">
					<h2>bokeh</h2>
					<a href="https://github.com/udacity/bokeh">https://github.com/udacity/bokeh</a>
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