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
	    
	    
	    <div class="table_wrap" ng-show="tasks!=null&&tasks.length>0">
	        <div class="set_bar">
	            <div class="form-group">
	            <h4>代办任务</h4>
	            </div>
	        </div>
	        <@p.table fixed=true>
	            <@p.thead>
	                <tr>
	                    <th width="40"><span>序号</span></th>
	                    <th width="70"><span>ID:</span></th>
	                    <th width="100"><span>任务名:</span></th>
	                    <th width="70"><span>接收人:</span></th>
	                    <th width="100"><span>开始时间:</span></th>
	                    <th width="100"><span>留言:</span></th>
	                    <th width="100"><span>代办:</span></th>
	                </tr>
	            </@p.thead>
	            <@p.tbody>
	                <tr ng-class="{true: 'active'}[x.checked]" data-ng-repeat="x in tasks" repeat-finish>
	                    <td class="t_c" ng-bind="$index + 1"></td>
	                    <td>
	                        <div class="text_wrap" ng-bind="x.taskId"></div>
	                    </td>
	                    <td>
	                        <div class="text_wrap" ng-bind="x.taskName"></div>
	                    </td>
	                    <td>
	                        <div class="text_wrap" ng-bind="x.assignee"></div>
	                    </td>
	                    <td>
	                        <div class="text_wrap">{{ x.taskCreateTime | date:'yyyy-MM-dd HH:mm:ss'}}</div>
	                    </td>
	                    <td>
	                        <div class="text_wrap" ng-bind="x.remark"></div>
	                    </td>
	                    <td>
	                        <div class="text_wrap">
	                        <select class="form-control" ng-model="item.itemNew" name="itemNew"
		                            ng-options="x.dictId as x.dictName for x in results"
		                            ng-selected="x.dictId==item.itemNews">
		                    </select>
	                        
	                        </div>
	                    </td>
	                    
	                </tr>
	            </@p.tbody>
	        </@p.table>
	    </div>
	    
	</div>



	<@javascript>
	<script type="text/javascript">
	    var indexApp = angular.module("indexApp", ["commApp"]);
	    indexApp.controller("indexCtrl", ['$scope','$dictService','$Ajax','$PagingService','$modal',function ($scope,$dictService,$Ajax,$PagingService,$modal) {
	    	<@p.ItemDetailJs/>
	    	
	    	$scope.query=function(){
	    		$scope.tasks=[];
	    		$PagingService.query({
	                url: "${ctx}/ly/myTask.do"
		        }).listen(function (responseData) {
		        	
	                $scope.tasks.pushPageData(responseData.list);
	            });
	    	}
	    	$scope.query();
	    	
	    	$scope.doSubmit=function(){
	    		if(!$scope.item.remark){
	    			$modal.alert("不可以提交哦，请填写好哦");
	    			return;
	    		}
	    		$Ajax({
	    				
	                    url: "${ctx}/ly/doSubmit.do",
	                    type: "POST",
	                    contentType: "application/json",
                        data: angular.toJson($scope.item)
                }).then(function (data) {
                	debugger
                	if(data==1){
                		$modal.alert("提交成功");
                	}else{
                		$modal.alert("提交失败");
                	}
                	
                });
	    		
	    	}
	    	
	    	$scope.completeTask=function(taskId){
	    		$Ajax({
	    				
	                    url: "${ctx}/ly/completeTask",
	                    type: "POST",
                        data: {taskId:taskId}
                }).then(function (data) {
	    			$scope.query();
                });
	    		
	    	};
	    	
	    	$scope.back = function () {
                window.history.go(-1);
            };
	
	    }]);
	</script>
	</@javascript>
</@body>