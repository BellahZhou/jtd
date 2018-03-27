<#include "/common/ftl/common.ftl"/>
<@body>
	<div data-ng-app="indexApp" data-ng-controller="indexCtrl">
		<form role="form" name="itemForm" novalidate>
	  		<fieldset class="panel-field">
			    <legend>与我对话</legend>
			    <div class="panel-field-box form-horizontal">
			    
			    <div class="form-group">
			        <label class="col-sm-2 control-label">项目名称：</label>
			        <p class="help-block col-sm-2">{{item.itemName}}</p>
			        
			        <label class="col-sm-2 control-label">项目类别：</label>
			        <p class="help-block col-sm-2">
			            <dict-type dictId="item.itemType" dictTypeId="ITEM_TYPE"/>
			        </p>
			      	
			      	<label class="col-sm-2 control-label">险种代码：</label>
			    	<p class="help-block col-sm-2">
			    		<select class="form-control input-sm w-100" ng-model="summary.insuranceType"
			                     ng-options="x.dictId as x.dictName for x  in insuranceTypes"
			                     ng-selected="x.dictId == summary.insuranceType">
			                 <option value="">请选择</option>
			             </select>
			    	</p>
			     </div>
			     
			</fieldset>     
   
	  		
	  		
	        <div class="btm-bar" >
			  	<fieldset class="panel-field">
			         <legend>送审信息</legend>
			     </fieldset>
			</div>
	    </form>
		
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