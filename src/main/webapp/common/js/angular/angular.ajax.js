/**
 * 功能: 定义angular ajax模块
 */
angular.module("angular.ajax", []).provider("$Ajax", function () {
    var interceptorFactories = this.interceptors = [];
    this.$get = ['$rootScope', '$q', '$injector', function ($rootScope, $q, $injector) {
        function $apply() {
            if (!$rootScope.$$phase) $rootScope.$apply();
        }

        /**
         * Interceptors stored in reverse order. Inner interceptors before outer interceptors.
         * The reversal is needed so that we can build up the interception chain around the
         * server request.
         */
        var reversedInterceptors = [];

        angular.forEach(interceptorFactories, function (interceptorFactory) {
            reversedInterceptors.unshift(angular.isString(interceptorFactory)
                ? $injector.get(interceptorFactory) : $injector.invoke(interceptorFactory));
        });

        function $Ajax(params) {
            var chain = [sendReq, undefined];
            var promise = $q.when(params);

            // apply interceptors
            angular.forEach(reversedInterceptors, function (interceptor) {
                if (interceptor.request || interceptor.requestError) {
                    chain.unshift(interceptor.request, interceptor.requestError);
                }
                if (interceptor.response || interceptor.responseError) {
                    chain.push(interceptor.response, interceptor.responseError);
                }
            });

            while (chain.length) {
                var thenFn = chain.shift();
                var rejectFn = chain.shift();

                promise = promise.then(thenFn, rejectFn);
            }

            return promise;
        }

        function sendReq(params) {
            var deferred = $q.defer(),
                promise = deferred.promise;
            // make a params copy
            var options = angular.extend({}, params);
            options.success = function (data, textStatus) {
                deferred.resolve(data, textStatus);
                $apply();
            };
            if(!options.error){
                options.error = function (XMLHttpRequest, textStatus, errorThrown) {
                   // alert("请求异常");
                    deferred.reject(XMLHttpRequest, textStatus, errorThrown);
                    $apply();
                };
            }
            promise.done = function (callback) {
                promise.then(function (responseData, textStatus) {
                    callback(responseData, textStatus);
                }, function (XMLHttpRequest, textStatus, errorThrown) {
                    callback(XMLHttpRequest.responseText, textStatus, XMLHttpRequest, errorThrown);
                });
                return promise;
            };
            jQuery.ajax(options);
            return promise;
        }

        return $Ajax;
    }];
});
