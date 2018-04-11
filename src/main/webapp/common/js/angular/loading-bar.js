(function () {

    'use strict';

    /**
     * loadingBarInterceptor service
     *
     * Registers itself as an Angular interceptor and listens for XHR requests.
     */
    angular.module('angular.loading.interceptor', ['angular.loading'])
        .config(['$AjaxProvider', function ($AjaxProvider) {
            var interceptor = ['$q', '$timeout', '$loadingBar', function ($q, $timeout, $loadingBar) {

                /**
                 * The total number of requests made
                 */
                var reqsTotal = 0;

                /**
                 * The number of requests completed (either successfully or not)
                 */
                var reqsCompleted = 0;

                /**
                 * The amount of time spent fetching before showing the loading bar
                 */
                var latencyThreshold = $loadingBar.latencyThreshold;

                /**
                 * $timeout handle for latencyThreshold
                 */
                var startTimeout;


                /**
                 * loading bar from the DOM.
                 */
                function setComplete() {
                    $timeout.cancel(startTimeout);
                    $loadingBar.complete();
                    reqsCompleted = 0;
                    reqsTotal = 0;
                }

                return {
                    'request': function (params) {
                        if (reqsTotal === 0) {
                            startTimeout = $timeout(function () {
                                $loadingBar.start();
                            }, 1);
                        }
                        reqsTotal++;
                        var _stat = reqsCompleted / reqsTotal;
                        if($loadingBar.status() < _stat){
                            $loadingBar.set(reqsCompleted / reqsTotal);
                        }else{
                            $loadingBar.inc();
                        }
                        return params;
                    },

                    'response': function (response, textStatus) {
                        reqsCompleted++;
                        if (reqsCompleted >= reqsTotal) {
                            setComplete();
                        } else {
                            var _stat = reqsCompleted / reqsTotal;
                            if($loadingBar.status() < _stat){
                                $loadingBar.set(reqsCompleted / reqsTotal);
                            }else{
                                $loadingBar.inc();
                            }
                        }
                        return response;
                    },

                    'responseError': function (rejection) {
                        reqsCompleted++;
                        if (reqsCompleted >= reqsTotal) {
                            setComplete();
                        } else {
                            $loadingBar.set(reqsCompleted / reqsTotal);
                        }
                        return $q.reject(rejection);
                    }
                };
            }];

            $AjaxProvider.interceptors.push(interceptor);
        }]);

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
        .provider('$loadingBar', function () {

            this.autoIncrement = true;
            this.includeBar = true;
            this.latencyThreshold = 100;
            this.startSize = 0.02;
            this.parentSelector = 'body';
            this.loadingBarTemplate = '<div id="loading-bar"><div class="bar"><div class="peg"></div></div></div>';

            this.$get = ['$injector', '$document', '$timeout', '$rootScope', function ($injector, $document, $timeout, $rootScope) {
                var $animate;
                var $parentSelector = this.parentSelector,
                    loadingBarContainer = angular.element(this.loadingBarTemplate),
                    loadingBar = loadingBarContainer.find('div').eq(0);

                var incTimeout,
                    completeTimeout,
                    started = false,
                    status = 0;

                var autoIncrement = this.autoIncrement;
                var includeBar = this.includeBar;
                var startSize = this.startSize;

                /**
                 * Inserts the loading bar element into the dom, and sets it to 2%
                 */
                function _start() {
                    if (!$animate) {
                        $animate = $injector.get('$animate');
                    }

                    $timeout.cancel(completeTimeout);

                    // do not continually broadcast the started event:
                    if (started) {
                        return;
                    }

                    var document = $document[0];
                    var parent = document.querySelector ?
                            document.querySelector($parentSelector)
                            : $document.find($parentSelector)[0]
                        ;

                    if (!parent) {
                        parent = document.getElementsByTagName('body')[0];
                    }

                    var $parent = angular.element(parent);
                    var $after = parent.lastChild && angular.element(parent.lastChild);

                    $rootScope.$broadcast('loadingBar:started');
                    started = true;

                    if (includeBar) {
                        $animate.enter(loadingBarContainer, $parent, $after);
                    }

                    _set(startSize);
                }

                /**
                 * Set the loading bar's width to a certain percent.
                 *
                 * @param n any value between 0 and 1
                 */
                function _set(n) {
                    if (!started) {
                        return;
                    }
                    var pct = (n * 100) + '%';
                    loadingBar.css('width', pct);
                    status = n;

                    // increment loadingbar to give the illusion that there is always
                    // progress but make sure to cancel the previous timeouts so we don't
                    // have multiple incs running at the same time.
                    if (autoIncrement) {
                        $timeout.cancel(incTimeout);
                        incTimeout = $timeout(function () {
                            _inc();
                        }, 250);
                    }
                }

                /**
                 * Increments the loading bar by a random amount
                 * but slows down as it progresses
                 */
                function _inc() {
                    if (_status() >= 1) {
                        return;
                    }

                    var rnd = 0;

                    var stat = _status();
                    if (stat >= 0 && stat < 0.25) {
                        // Start out between 3 - 6% increments
                        rnd = (Math.random() * (5 - 3 + 1) + 3) / 100;
                    } else if (stat >= 0.25 && stat < 0.65) {
                        // increment between 0 - 3%
                        rnd = (Math.random() * 3) / 100;
                    } else if (stat >= 0.65 && stat < 0.9) {
                        // increment between 0 - 2%
                        rnd = (Math.random() * 2) / 100;
                    } else if (stat >= 0.9 && stat < 0.99) {
                        // finally, increment it .5 %
                        rnd = 0.005;
                    } else {
                        // after 99%, don't increment:
                        rnd = 0;
                    }

                    var pct = _status() + rnd;
                    _set(pct);
                }

                function _status() {
                    return status;
                }

                function _completeAnimation() {
                    status = 0;
                    started = false;
                }

                function _complete() {
                    if (!$animate) {
                        $animate = $injector.get('$animate');
                    }

                    _set(1);
                    $timeout.cancel(completeTimeout);

                    completeTimeout = $timeout(function () {
                        var promise = $animate.leave(loadingBarContainer, _completeAnimation);
                        if (promise && promise.then) {
                            promise.then(_completeAnimation);
                        }
                        $rootScope.$broadcast('loadingBar:completed');
                    }, 500);
                }

                return {
                    start: _start,
                    set: _set,
                    status: _status,
                    inc: _inc,
                    complete: _complete,
                    autoIncrement: this.autoIncrement,
                    latencyThreshold: this.latencyThreshold,
                    parentSelector: this.parentSelector,
                    startSize: this.startSize
                };
            }];
        })
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
