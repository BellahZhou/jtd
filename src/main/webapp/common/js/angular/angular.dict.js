/**
 * 功能: 定义angular 业务字典服务模块
 *
 * getEntry: function (dictTypeId, parentDictId)
 *
 * getEntryByDictId: function (dictTypeId, dictId)
 *
 */
angular.module("angular.dict", ['angular.ajax'])
    .provider("$dictService", function () {
    	debugger
        var map = {};
        var ORG_MAP = {};
        var DEPT_MAP = {};
        this.$get = ["$Ajax", '$q',function ($Ajax ,$q) {
            var privateMethod = {
                equals: function (d, e) {
                    return ("," + d + ",").indexOf("," + e + ",") != -1;
                },
                getDictName: function (f, d) {
                    for (var g = 0,
                             c = f.length; g < c; g++) {
                        var h = f[g];
                        if (privateMethod.equals(d, h.dictId)) {
                            return h.dictName;
                        }
                    }
                    return "";
                }
            };
            var service = {
        		getEntry: function (dictTypeId) {
                    return $Ajax({url: contextPath + "/entry/getEntry.do", type: "POST", data: {dictTypeId: dictTypeId}});
                },	
                
                getEntryByDictId: function (dictTypeId, dictId) {
                    var deferred = $q.defer(),
                        promise = deferred.promise;
                    var d = map[dictTypeId];
                    var f = "";
                    if (d) {
                        f = privateMethod.getDictName(d, dictId);
                        if (f !== "") {
                            deferred.resolve(f);
                        }
                    };
                    if(dictId === null || dictId === ""){
                        return "";
                    }
                    jQuery.ajax({
                        url: contextPath + "/entry/getEntryByDictId.do",
                        type: "POST",
                        data: {dictTypeId: dictTypeId, dictId: dictId},
                        success: function (data) {
                            if (data) {
                                if (map[dictTypeId]) {
                                    f = privateMethod.getDictName(map[dictTypeId], dictId);
                                    if (f === "") {
                                        map[dictTypeId].push(data);
                                    }
                                } else {
                                    map[dictTypeId] = [];
                                    map[dictTypeId].push(data);
                                }
                                f = privateMethod.getDictName(map[dictTypeId], dictId);
                                deferred.resolve(f);
                            }
                        }
                    });
                    return promise;
                }
                };
            return service;
        }];
    });