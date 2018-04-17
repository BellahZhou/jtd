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
	    
	    
	    <div class="table_wrap">
	        <div class="set_bar">
	            <div class="form-group">
	            </div>
	        </div>
	        <@p.table fixed=true>
	            <@p.thead>
	                <tr>
	                    <th width="40"><span>序号</span></th>
	                    <th width="70"><span>ID:</span></th>
	                    <th width="100"><span>姓名:</span></th>
	                    <th width="200"><span>接收人:</span></th>
	                    <th width="70"><span>开始时间:</span></th>
	                </tr>
	            </@p.thead>
	            <@p.tbody>
	                <tr ng-class="{true: 'active'}[x.checked]" data-ng-repeat="x in tasks" repeat-finish>
	                    <td class="t_c" ng-bind="$index + 1"></td>
	                    <td>
	                        <div class="text_wrap" ng-bind="x.id"></div>
	                    </td>
	                    <td>
	                        <div class="text_wrap" ng-bind="x.name"></div>
	                    </td>
	                    <td>
	                        <div class="text_wrap" ng-bind="x.assignee"></div>
	                    </td>
	                    <td>
	                        <div class="text_wrap" ng-bind="x.createTime"></div>
	                    </td>
	                    
	                </tr>
	            </@p.tbody>
	        </@p.table>
	    </div>
	    
	</div>



	<@javascript>
	<script type="text/javascript">
	    var indexApp = angular.module("indexApp", ["commApp"]);
	    indexApp.controller("indexCtrl", ['$scope','$Ajax',function ($scope,$Ajax) {
	    	$Ajax({
	                url: "${ctx}/ly/myTask.do",
	                type: "POST"
	        }).then(function (data) {
	        	debugger;
	        	$scope.tasks=data;
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