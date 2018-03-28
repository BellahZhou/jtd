<#include "/common/ftl/common.ftl"/>
<@body>
	<div class="tab_frame_body" data-ng-app="indexApp" data-ng-controller="indexCtrl">
		<form role="form" name="itemForm" novalidate>
	  		<fieldset class="panel-field">
			    <legend>与我对话</legend>
			    <div class="panel-field-box form-horizontal">
			    
				    <div class="form-group">
				        <label class="col-sm-3 control-label">我的电话：</label>
				        <p class="help-block col-sm-3">18217702806</p>
				    </div>
				    <div class="form-group">    
				        <label class="col-sm-3 control-label">我的EMAIL：</label>
				        <p class="help-block col-sm-3">18351886003@163.com</p>
				    </div>
				    <div class="form-group">      	
				      	<label class="col-sm-3 control-label">你也可以给我写信：</label>
				    	<p class="help-block col-sm-8">上海市徐汇区桂平路481号20号楼6层（万达信息）</p>
				     </div>
				     
			     </div>
			</fieldset>     
	  		
	    </form>
		
	</div>



	<@javascript>
	<script type="text/javascript">
	    var indexApp = angular.module("indexApp", ["commApp"]);
	    indexApp.controller("indexCtrl", ['$scope','$Ajax',function ($scope,$Ajax) {
	
	    }]);
	</script>
	</@javascript>
</@body>