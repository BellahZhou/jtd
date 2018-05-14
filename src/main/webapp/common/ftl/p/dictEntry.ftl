<#macro itemDictJs>
// 送审结果
$dictService.getEntry('AUDIT_RESULT').then(function (data) {
    $scope.results = data;
});
</#macro>