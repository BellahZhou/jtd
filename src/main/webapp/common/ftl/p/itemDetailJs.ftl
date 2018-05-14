<#assign ctx = "${request.contextPath}"/>
<#include "/common/ftl/p/dictEntry.ftl"/>
<#macro ItemDetailJs>
	<@itemDictJs/>
	
	// 返回
	$scope.back = function () {
	    window.history.go(-1);
	};
</#macro>
