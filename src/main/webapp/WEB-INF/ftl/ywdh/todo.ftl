<#include "/common/ftl/common.ftl"/>
<@body>
	<div class="tab_frame_body" data-ng-app="indexApp" data-ng-controller="indexCtrl">
		<form role="form" name="itemForm" novalidate>
	  		<fieldset class="panel-field">
			    <legend>与我对话</legend>
			    <div class="panel-field-box form-horizontal">
			    
				    <div class="form-group">
				        <label class="col-sm-3 control-label">我的电话：</label>
				        <p class="help-block col-sm-3">{{my.phone}}</p>
				    </div>
				    <div class="form-group">    
				        <label class="col-sm-3 control-label">我的EMAIL：</label>
				        <p class="help-block col-sm-3">{{my.email}}</p>
				    </div>
				    <div class="form-group">      	
				      	<label class="col-sm-3 control-label">你也可以给我写信：</label>
				    	<p class="help-block col-sm-8">{{my.address}}</p>
				     </div>
				     
			     </div>
			</fieldset>     
	  		
	    </form>
		
	</div>



	<@javascript>
	<script type="text/javascript">
	    var indexApp = angular.module("indexApp", ["commApp"]);
	    indexApp.controller("indexCtrl", ['$scope','$Ajax',function ($scope,$Ajax) {
	    	$Ajax({url: "${ctx}/ywdh/list.do"}).then(function (data) {
	    		$scope.my=data;
	    	});
	    }]);
	</script>
	</@javascript>
</@body>