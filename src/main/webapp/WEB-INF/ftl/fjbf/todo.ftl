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
				            <input class="form-control" ng-model="item.positiveWords"></textarea>
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
				            <textarea ng-disabled="item.nothingTheMatterDot" class="form-control" ng-model="item.nothingTheMatter" rows="4"></textarea>
				        </div>
				        <input type="checkbox" ng-model="item.nothingTheMatterDot">(可以用“✓”代替)
				     </div>
				     
				     <div class="form-group">
				    	<label class="col-sm-2 control-label"></label>      	
				    	<p class="help-block col-sm-8">B.和未来有关的事：</p>
				     </div>
				     <div class="form-group">
				     	<label class="col-sm-2 control-label"></label>      
				        <div class="col-sm-8">
				            <textarea ng-disabled="item.aboutFutureDot" class="form-control" ng-model="item.aboutFuture" rows="4"></textarea>
				        </div>
				        <input type="checkbox" ng-model="item.aboutFutureDot">(可以用“✓”代替)
				     </div>
				     
				     <div class="form-group">
				    	<label class="col-sm-2 control-label"></label>      	
				    	<p class="help-block col-sm-8">C.今天最重要的事：</p>
				     </div>
				     <div class="form-group">
				     	<label class="col-sm-2 control-label"></label>      
				        <div class="col-sm-8">
				            <textarea ng-disabled="item.importantThingsDot" class="form-control" ng-model="item.importantThings" rows="4"></textarea>
				        </div>
				        <input type="checkbox" ng-model="item.importantThingsDot">(可以用“✓”代替)
				     </div>
				     
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
	    	$Ajax({url: "${ctx}/fjbf.do"}).then(function (data) {
	    		$scope.music=data;
	    		$("#player").vpplayer({
				    src: "${ctx}/common/audio/"+$scope.music.src,
				    trackName: "sample audio",
				    playerColor:$scope.music.playerColor,
				    view:'minimal',	
				});
	    	});
	    	
	    	
	    	
	    }]);
	</script>
	</@javascript>
</@body>