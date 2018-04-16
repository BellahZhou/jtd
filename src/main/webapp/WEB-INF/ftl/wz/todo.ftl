<#include "/common/ftl/common.ftl"/>
<@body>
	<div class="tab_frame_body" data-ng-app="indexApp" data-ng-controller="indexCtrl">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<img src="${ctx}/common/images/top_1.png"> 
				</div>
			</div>
			<div class="row">
				<div class="col-md-9">
					<div class="row">
						<div class="col-md-1"></div>
						<div class="col-md-5" style="padding-left:0px;padding-right:0px">
							<img src="${ctx}/common/images/left_1.png">
							<h2>BEAN AT LOS ANGELES</h2>
							<h6>HAVE A NICE HOLIDAY</h6>
						</div>
						<div class="col-md-6" style="padding-left:0px;padding-right:5px">
							<div style="width:497px;height:90px"></div>
							<img src="${ctx}/common/images/middle_1.png">
						</div>
					</div>
					<div class="row"><hr></div>
					<div class="row">
						<div class="row">
							<div class="col-md-1"></div>
							<div class="col-md-11">
								<h6>A LITTLE STEP</h6>
								<h4>幸福的</h4>
								<h4>最小行动</h4>
							</div>
						</div>
						<div class="row">
							<div class="col-md-1"></div>
							<div class="col-md-3">
								<h6>DESCRIBE</h6>
								<h6>IT`S A BOOK FROM A MAN WHO IS SON OF LIUYONG AND DOCTOR OF PSYCHOLOGY.HIS CONCEPT IS BENIFIT FOR US AND PRACTICAL.IT`S ABOUT HOW TO MAKE A SCHEDULE BASE ON YOUR PSYCHOLOGY.</h6>
							</div>
							<div class="col-md-4">
								<h6>SHY OF YOU</h6>
								<h6>'I JUMPED ACROSS FOR YOU,OH WHAT A THING TO DO ,`COS YOU WERE ALL YELLOW.'</h6>
							</div>
							<div class="col-md-4">
								<h6>FROM NOW</h6>
								<h6>IF YOU WANNA KEEP FIT,JUST TAKE ON YOUR SHOES AND OUT OF DOOR.</h6>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-3" style="padding-left:0px">
					<h2 style="margin-left:50px">BLOG</h2>
					<h6>ONLINE</h6>
					<h4 style="margin-left:50px">LOOK AT THE FACE</h4>
					<h6 style="margin-left:50px">LOO KA FACE</h6>
					<hr>
					<h6>ONLINE</h6>
					<h4 style="margin-left:50px">PLAY THE PINAO</h4>
					<h6 style="margin-left:50px">DO RE MI FA SO LA XI DO...</h6>
					<hr>
					<h6>ONLINE</h6>
					<h4 style="margin-left:50px">EAT SNACKS</h4>
					<h6 style="margin-left:50px">HAVE A GREAT DAY</h6>
					<hr>
					<h6>ONLINE</h6>
					<h4 style="margin-left:50px">HAVE NOT WORK</h4>
					<h6 style="margin-left:50px">WHAT YOU WANNA</h6>
					<hr>
					<h6>ONLINE</h6>
					<h4 style="margin-left:50px">COOK FOR YOUR LOVE</h4>
					<h6 style="margin-left:50px">BOY FRIEND</h6>
					<hr>
					<h6>ONLINE</h6>
					<h4 style="margin-left:50px">PICK UP YOUR COMPUTER</h4>
					<h6 style="margin-left:50px">RIGHT DOWN IDEALS,SUCH AS CHICKEN CLUB FOR THE SOUL</h6>
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