<#macro itemDictJs>
// 送审结果
$dictService.getEntry('AUDIT_RESULT').then(function (data) {
debugger
    $scope.results = data;
});
</#macro>