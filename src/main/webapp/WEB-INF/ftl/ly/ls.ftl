<#include "/common/ftl/common.ftl"/>
<@body>
	<div class="tab_frame_body" data-ng-app="indexApp" data-ng-controller="indexCtrl">
	      <div id="pageGrid">
		        <div data-ng-repeat="x in lys" >
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
	    	$Ajax({
	    	    type: "POST",
	    	    url: "${ctx}/ly/ls.do"
	    	}).then(function (data) {
	    		$scope.lys=data;
	    	});
	    	
	    }]);
	</script>
	</@javascript>
</@body>