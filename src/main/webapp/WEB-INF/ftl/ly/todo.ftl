<#include "/common/ftl/common.ftl"/>
<@body>
<div class="panel panel-default panel-page">
    <div class="panel-heading">
        <ul id="myTab" class="nav nav-tabs">
            <li class="active"><a href="#tab1"  data-toggle="tab">留言目</a></li>
            <li><a href="#tab1_2"  data-toggle="tab">我的留言</a></li>
        </ul>
    </div>

    <div id="myTabContent" class="tab-content tab-frame">
        <iframe frameborder="0" src="lym.shtml" scrolling="no"  class="tab-pane fade in active" id="tab1"></iframe>

        <iframe frameborder="0" src="myLy.shtml" scrolling="no" class="tab-pane fade" id="tab1_2"></iframe>
        
    </div>
</div>

</@body>