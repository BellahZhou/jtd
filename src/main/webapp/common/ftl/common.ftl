<#import "/common/ftl/p/p.ftl" as p/>
<#assign ctx="${request.contextPath}"/>
<#assign title="jtd"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>${title}</title>
    <meta name="renderer" content="webkit"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="format-detection" content="telephone=no"/>
	<link rel="stylesheet" type="text/css" href="${ctx}/common/frame3rd/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/common/css/common.css"/>
    <script type="text/javascript" src="${ctx}/common/js/jquery-1.11.1.min.js"></script>
     <script type="text/javascript" src="${ctx}/common/js/angular/angular-1.3.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/common/js/angular/angular.ajax.js"></script>
    <script type="text/javascript" src="${ctx}/common/js/angular/angular.bootstrap.ui.modal.js"></script>
    <script type="text/javascript" src="${ctx}/common/js/angular/angular.common.js"></script>
        
    <script type="text/javascript">
        var contextPath = "${ctx}";
        $.extend(Array.prototype, {
            clone: function () {
                if (this.length === 1) {
                    return [this[0]];
                } else {
                    return Array.apply(null, this);
                }
            },
            remove: function (b) {
                var a = this.indexOf(b);
                if (a >= 0) {
                    this.splice(a, 1);
                }
                return (a >= 0);
            },
            pushPageData: function (c) {
                for (var b = 0,
                             a = c.length; b < a; b++) {
                    this[this.length] = c[b];
                }
                return this;
            }
        });
    </script>
   	<script src="https://cdn.bootcss.com/angular-touch/1.3.1/angular-touch.min.js"></script>
    <script type="text/javascript" src="${ctx}/common/frame3rd/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<#macro header>
    <#nested />
</#macro>
</head>
<#macro body class="">
<body class="${class}">
    <#nested />
</body>
</#macro>
<#macro javascript>
    <#nested />
</#macro>
</html>