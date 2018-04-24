/**
 * 功能: 定义公共的angular模块
 */
var commApp = angular.module("commApp", ['angular.ajax','angular.dict']);

var dictPromise = {};
//业务字典指令
commApp.directive('dictType',['$dictService', function ($dictService) {
 return {
     scope: {
         dictid: '=',
         dicttypeid: '@'
     },
     link: function (scope, element, attr) {
         var dictId = scope.dictid;
         var dictTypeId = scope.dicttypeid;
         if(dictId){
             watch(dictId);
         }else {
             scope.$watch('dictid' , function (newVal) {
                 if(newVal) {
                     watch(newVal);
                 }
             });
         }

         function watch(dictId) {
             var promise = dictPromise[dictId + "_" + dictTypeId];

             if(!promise){
                 promise = $dictService.getEntryByDictId(dictTypeId, dictId);
                 dictPromise[dictId + "_" + dictTypeId] = promise;
             }
             promise.then(function (data) {
                 element.replaceWith(data);
             });
         }

     }
 }
}]);

