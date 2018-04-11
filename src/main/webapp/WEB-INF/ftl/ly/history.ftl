<#include "/common/ftl/common.ftl"/>
<@body>
	<div class="tab_frame_body" data-ng-app="indexApp" data-ng-controller="indexCtrl">
	      <div id="pageGrid">
		        <div >
		            <fieldset class="panel-field">
		                <legend>历史记录</legend>
		                <div class="panel-field-box form-horizontal" data-ng-repeat="x in lys" >
		                    <div class="form-group">
		                        <label for="" class="col-sm-2 control-label">操作时间：</label>
		                        <p class="help-block col-sm-3" ng-bind="x.createDate"></p>
		                        <label for="" class="col-sm-2 control-label">操作人：</label>
		                        <p class="help-block col-sm-3" ng-bind="x.createBy"> </p>
		                    </div>
		                    
		                    <div class="form-group">
		                        <label for="" class="col-sm-2 control-label">留言结果：</label>
		                        <p class="help-block col-sm-3" ng-bind="x.remark"></p>
		                    </div>
		                    <div class="form-group">
		                        <label for="" class="col-sm-2 control-label">留言回信：</label>
		                        <input class="help-block col-sm-7" type="text" ng-model="x.reback"/>
		                        <button class="btn btn-success" type="button" class="col-sm-1"  ng-click="ok(x)">回信</button>
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
	    	$Ajax({
	    	    type: "POST",
	    	    url: "${ctx}/ly/history.do"
	    	}).then(function (data) {
	    		$scope.lys=data;
	    	});
	    	
	    	$scope.ok = function (x) {
                $Ajax({
                	contentType: "application/json",
                    url: "${ctx}/ly/update",
                    type: "POST",
                    data: angular.toJson(x)
                }).then(function (data) {
                    if (data == 1) {
                    	alert("更新成功!");
                    }else{
                        alert("更新失败!");
                    }
                	window.location.reload();
                });
         	};
	    	
	    }]);
	</script>
	</@javascript>
</@body>