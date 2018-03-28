<#include "/common/ftl/common.ftl"/>
<@body>
	<div class="tab_frame_body" data-ng-app="indexApp" data-ng-controller="indexCtrl">
		<form role="form" name="itemForm" novalidate>
	  		<fieldset class="panel-field">
			    <legend>留言</legend>
			    <div class="panel-field-box form-horizontal">
			    
			    <div class="form-group">
			        <label for="" class="col-sm-2 control-label">say something:</label>

			        <div class="col-sm-8">
			            <textarea class="form-control" ng-model="item.remark" rows="4"></textarea>
			        </div>
			    </div>
			     
			</fieldset>     
   
	  		
	  		
	        <div class="btm-bar" >
			  	 <button class="btn btn-success" ng-click="doSubmit()">提交</button>
        		 <a class="btn btn-success" ng-click="back()">返回</a>
			</div>
	    </form>
	    
	    <div id="pageGrid">
	        <div data-ng-repeat="x in dataItems" >
	            <fieldset class="panel-field">
	                <legend>历史记录</legend>
	                <div class="panel-field-box form-horizontal">
	                    <div class="form-group">
	                        <label for="" class="col-sm-2 control-label">操作时间：</label>
	                        <p class="help-block col-sm-3" ng-bind="x.createDate"></p>
	                        <label for="" class="col-sm-2 control-label">操作人：</label>
	                        <p class="help-block col-sm-3" ng-bind="x.createBy"> </p>
	                    </div>
	                    
	                    <div class="form-group" ng-if="x.remark">
	                        <label for="" class="col-sm-2 control-label">留言结果：</label>
	                        <p class="help-block col-sm-3" ng-bind="x.remark"></p>
	                    </div>
	                    <div class="form-group" ng-if="x.reback">
	                        <label for="" class="col-sm-2 control-label">留言回信：</label>
	                        <p class="help-block col-sm-8" ng-bind="x.reback"></p>
	                    </div>
	
	                </div>
	            </fieldset>
	        </div>
		</div>
	    
	</div>



	<@javascript>
	<script type="text/javascript">
	    var indexApp = angular.module("indexApp", ["commApp"]);
	    indexApp.controller("indexCtrl", ['$scope','$Ajax',function ($scope,$Ajax) {
	    	$Ajax({url: "${ctx}/ly.do"}).then(function (data) {
	    		$scope.dataItems=data;
	    	});
	    	
	    	$scope.doSubmit=function(){
	    		if(!$scope.item.remark){
	    			alert("不可以提交哦，请填写好哦");
	    		}
	    		$Ajax({
	    				
	                    url: "${ctx}/ly/doSubmit.do",
	                    type: "POST",
	                    contentType: "application/json",
                        data: angular.toJson($scope.item)
                }).then(function (data) {
                	debugger
                	if(data==1){
                		alert("提交成功");
                	}else{
                		alert("提交失败");
                	}
                	window.location.reload();
                });
	    		
	    	}
	
	    }]);
	</script>
	</@javascript>
</@body>