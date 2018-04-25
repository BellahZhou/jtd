(function () {

    'use strict';

    /**
     * Loading Bar
     *
     * This service handles adding and removing the actual element in the DOM.
     * Generally, best practices for DOM manipulation is to take place in a
     * directive, but because the element itself is injected in the DOM only upon
     * XHR requests, and it's likely needed on every view, the best option is to
     * use a service.
     */
    angular.module('angular.loading', [])
        .provider('$loadingBox', function () {

            this.loadingMsg = "loading...";
            this.parentSelector = 'body';
            this.spinnerTemplate = '<div class="loading-bar-spinner"><div class="spinner-background"></div><div class="spinner-icon spinner-msg"></div></div>';

            this.$get = ['$document', function ($document) {
                var $parentSelector = this.parentSelector,
                    $loadingMsg = this.loadingMsg,
                    $spinner = this.spinnerTemplate;

                /**
                 * Inserts the loading bar element into the dom, and sets it to 2%
                 */
                function _start(options) {
                    var $$loadingMsg = options.loadingMsg || $loadingMsg;
                    var $$parentSelector = options.parentSelector || $parentSelector;

                    var parent = $document.find($$parentSelector)[0];

                    if (!parent) {
                        parent = document.getElementsByTagName('body')[0];
                    }

                    var $parent = angular.element(parent);

                    $parent.append($spinner);
                    var spinner = $parent.find(".loading-bar-spinner");
                    var b = spinner.find(".spinner-msg")[0];
                    b.innerHTML = $$loadingMsg;
                    b.style.display = "block";
                    var g = {
                        width: angular.element(b).outerWidth(),
                        height: angular.element(b).outerHeight()
                    };
                    b.style.marginLeft = -g.width / 2 + "px";
                    b.style.marginTop = -g.height / 2 + "px";
                }

                function _complete(parentSelector) {
                    parentSelector = parentSelector || $parentSelector;
                    var $parent = $document.find(parentSelector);
                    $parent.find(".loading-bar-spinner").remove();
                    //$document.find($parentSelector).find(".loading-bar-spinner").remove();
                }

                return {
                    start: _start,
                    complete: _complete
                };
            }];
        });
})();
