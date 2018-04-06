<#include "/common/ftl/common.ftl"/>
<style>
#seekBar{
margin-bottom: 15px;
}
</style>
<@body>
	<div class="tab_frame_body" data-ng-app="indexApp" data-ng-controller="indexCtrl">
		<form role="form" name="itemForm" novalidate>
	  		<fieldset class="panel-field">
			    <legend>附加部分</legend>
			    <div class="panel-field-box form-horizontal">
			    
				    <div class="form-group">
				        <label for="" class="col-sm-2 control-label">每天一句积极的话:</label>

				        <div class="col-sm-8">
				            <input class="form-control" ng-model="fjbf.positiveWords"></textarea>
				        </div>
				    </div>
				    <div class="form-group">    
				        <label class="col-sm-2 control-label">今天要做的事：</label>
				        <div class="col-sm-8"></div>
				    </div>
				    <div class="form-group">
				    	<label class="col-sm-2 control-label"></label>      	
				    	<p class="help-block col-sm-8">A.最容易完成的事：</p>
				     </div>
				     <div class="form-group">
				     	<label class="col-sm-2 control-label"></label>      
				        <div class="col-sm-8">
				            <textarea ng-disabled="nothingTheMatterDot" class="form-control" ng-model="fjbf.nothingTheMatter" rows="4"></textarea>
				        </div>
				        <input type="checkbox" ng-model="nothingTheMatterDot">(可以用“✓”代替)
				     </div>
				     
				     <div class="form-group">
				    	<label class="col-sm-2 control-label"></label>      	
				    	<p class="help-block col-sm-8">B.和未来有关的事：</p>
				     </div>
				     <div class="form-group">
				     	<label class="col-sm-2 control-label"></label>      
				        <div class="col-sm-8">
				            <textarea ng-disabled="aboutFutureDot" class="form-control" ng-model="fjbf.aboutFuture" rows="4"></textarea>
				        </div>
				        <input type="checkbox" ng-model="aboutFutureDot">(可以用“✓”代替)
				     </div>
				     
				     <div class="form-group">
				    	<label class="col-sm-2 control-label"></label>      	
				    	<p class="help-block col-sm-8">C.今天最重要的事：</p>
				     </div>
				     <div class="form-group">
				     	<label class="col-sm-2 control-label"></label>      
				        <div class="col-sm-8">
				            <textarea ng-disabled="importantThingsDot" class="form-control" ng-model="fjbf.importantThings" rows="4"></textarea>
				        </div>
				        <input type="checkbox" ng-model="importantThingsDot">(可以用“✓”代替)
				     </div>
					
			     </div>
			     <div class="btm-bar" >
				  	 <button class="btn btn-success" ng-click="doSubmit()">提交</button>
		       		 <a class="btn btn-success" ng-click="back()">返回</a>
				 </div>
			</fieldset>
			<fieldset class="panel-field"> 
				<div class="panel-field-box form-horizontal">    
	  				<div class="form-group">
				        <label for="" class="col-sm-2 control-label">送你一首歌:</label>
				        <div class="col-sm-8"></div>
				    </div>
				    <div class="form-group">
				        <label for="" class="col-sm-2 control-label"></label>
				        <div class="col-sm-8" id="player">
				        </div>
				    </div>
			    </div>
			</fieldset> 
	    </form>
		 
	</div>



	<@javascript>
	<script type="text/javascript">
	    var indexApp = angular.module("indexApp", ["commApp"]);
	    indexApp.controller("indexCtrl", ['$scope','$Ajax',function ($scope,$Ajax) {
	    	$Ajax({url: "${ctx}/fjbf/music.do"}).then(function (data) {
	    		$scope.music=data;
	    		$("#player").vpplayer({
				    src: "${ctx}/common/audio/"+$scope.music.src,
				    trackName: "sample audio",
				    playerColor:$scope.music.playerColor,
				    view:'minimal',	
				});
	    	});
	    	
	    	
	    	$scope.doSubmit=function(){
	    		/* if(!$scope.fjbf.remark){
	    			alert("不可以提交哦，请填写好哦");
	    		} */
	    		debugger
	    		$Ajax({
	                    url: "${ctx}/fjbf/save.do",
	                    type: "POST",
	                    contentType: "application/json",
                        data: angular.toJson($scope.fjbf)
                }).then(function (data) {
                	if(data==1){
                		alert("提交成功");
                	}else{
                		alert("提交失败");
                	}
                	window.location.reload();
                });
	    		
	    	}
	    	
	    	$scope.back = function () {
                window.history.go(-1);
            };
	    	
	    	
	    }]);
	</script>
	</@javascript>
</@body>