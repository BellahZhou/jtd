/**
 * 封装ngDialog的方法
 */

angular.module("bootstrap.ui.modal", ['ngDialog']).provider("$modal", function () {

    var templateString = '<div class="modal-header"> <h4 class="modal-title">{{title}}</h4> </div>'
        + '<div class="modal-body"> <div class="col-sm-12 m-t-xs m-b-xs "> <div class="form-group">'
        + '{{content}}'
        + '</div> </div> </div>'
        + '<div ng-if="buttons.length" class="modal-footer">'
        + '<button ng-repeat="x in buttons" type="button" class="btn" ng-click="closeThisDialog(x.key)">{{x.value}}</button>'
        + '</div>';

    this.$get = ['ngDialog', '$q', function (ngDialog, $q) {

        function openModal(content, title, buttons) {
            var defer = $q.defer();
            var dialog = ngDialog.open({
                template: templateString, plain: true, closeByDocument: false, controller: ["$scope", function ($scope) {
                    $scope.title = title;
                    $scope.content = content;
                    $scope.buttons = buttons;
                }]
            });
            dialog.closePromise.then(function (action) {
                defer.resolve(action.value);
            });
            return defer.promise;
        }

        var alert = function (content, title) {
            return openModal(content, title || "提醒", [{key: "ok", value: "确定"}]);
        }

        var confirm = function (content, title) {
            return openModal(content, title || "确认", [{key: "ok", value: "确定"}, {key: "cancel", value: "取消"}]);
        }

        var open = function (opts) {
            return ngDialog.open(opts);
        }

        return {
            alert: alert,
            confirm: confirm,
            open: open
        }
    }];

});