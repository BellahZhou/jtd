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
	    
	</div>



	<@javascript>
	<script type="text/javascript">
	    var indexApp = angular.module("indexApp", ["commApp"]);
	    indexApp.controller("indexCtrl", ['$scope','$Ajax',function ($scope,$Ajax) {
	    	
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