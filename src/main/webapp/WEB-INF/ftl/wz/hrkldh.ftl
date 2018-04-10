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
					<p>不乱于心,不困于情.不畏将来,不念过往.如此,安好! <br>
深谋若谷,深交若水.深明大义,深悉小节.已然,静舒! <br>
善宽以怀,善感以恩.善博以浪,善精以业.这般,最佳! <br>
勿感于时,勿伤于怀.勿耽美色,勿沉虚妄.从今,进取! <br>
无愧于天,无愧于地.无怍于人,无惧于鬼.这样,人生!<br>
——丰子恺《不宠无惊过一生》</p>
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