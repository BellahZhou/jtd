/**
 * 功能: 定义公共的angular模块
 */
var commApp = angular.module("commApp", ['bootstrap.ui.modal','angular.ajax','angular.dict','angular.loading']);

/**
 * 功能: 定义分页服务
 */
commApp.service("$PagingService", ["$Ajax", '$q', '$loadingBox', function ($Ajax, $q, $loadingBox) {
    var defaultParams = {type: "POST", data: {pageNum: 1, pageSize: 10}, pagingId: "pageGrid"};
    this.query = function (params) {
        var deferred = $q.defer(),
            promise = deferred.promise;

        // make a params copy
        var currentParams = jQuery.extend(true, {}, defaultParams, params);
        var parentSelector = "#" + currentParams.pagingId;

        promise.listen = function (success, error) {
            promise.then(null, function (XMLHttpRequest, textStatus, errorThrown) {
                $loadingBox.complete(parentSelector);
                if (error) {
                    error(XMLHttpRequest, textStatus, errorThrown);
                }
            }, function (responseData, textStatus) {
                $loadingBox.complete(parentSelector);
                if (success) {
                    success(responseData, textStatus);
                }
            });
            return promise;
        };

        var sendQuery = function () {
            $loadingBox.start({parentSelector: parentSelector, loadingMsg: "加载中..."});
            $Ajax(currentParams).then(function (responseData, textStatus) {
                // 更新分页条显示
                $(parentSelector + " .dataTotal").text(responseData.total);

                deferred.notify(responseData, textStatus);
                // 更新分页按钮
                $(parentSelector + " .pagination").twbsPagination({
                    totalPages: (responseData.pages === 0 ? 1 : responseData.pages),
                    visiblePages: 0, // 显示分页码个数
                    startPage: (responseData.pageNum === 0 ? 1 : responseData.pageNum),
                    first: false,
                    prev: false,
                    next: "加载更多",
                    last: false,
                    onPageClick: function (event, currPageNo) {
                        currentParams.data.pageNum = currPageNo;
                        sendQuery();
                    }
                });
            }, function (XMLHttpRequest, textStatus, errorThrown) {
                $(parentSelector + " .dataTotal").text(0);
                deferred.reject(XMLHttpRequest, textStatus, errorThrown);
            });
        }

        sendQuery();
        return promise;
    };
}]);

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

