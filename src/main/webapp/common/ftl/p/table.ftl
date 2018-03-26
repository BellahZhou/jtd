<#macro table id="pageGrid" showPage=true fixed=false>
    <#if fixed>
    <div class="data_table_fixed">
    </#if>
    <div id="${id}" class="data_table_grid">
        <div class="data_table" >
            <div class="data_table_wrap" style="width:auto;">
                <table class="table table-bordered table-hover" fixed-header id="${id}_table">
                    <#nested/>
                </table>
            </div>
        </div>
        <#if showPage>
            <div class="pagination_div page_bar">
                <ul class="pagination pagination-sm pull-right"></ul>
            <span class="page-text" style="padding:0;">
            总条数： <span class="dataTotal"></span> 条
        </span>
            </div>
        </#if>
    </div>
    <#if fixed>
    </div>
    </#if>
</#macro>
<#macro thead>
<thead>
    <#nested/>
</thead>
</#macro>
<#macro tbody>
<tbody>
    <#nested/>
</tbody>
</#macro>
<#macro table2 id="pageGrid" showPage=true fixed=false>
    <#if fixed>
    <div class="data_table_fixed">
    </#if>
    <div id="${id}" class="data_table_grid">
        <div class="data_table" style="overflow:auto;padding-bottom:20px;">
            <div class="data_table_wrap">
                <table class="table table-bordered table-hover" fixed-header id="${id}_table">
                    <#nested/>
                </table>
            </div>
        </div>
        <#if showPage>
            <div class="pagination_div page_bar">
                <ul class="pagination pagination-sm pull-right"></ul>
            <span class="page-text" style="padding:0;">
            总条数： <span class="dataTotal"></span> 条
        </span>
            </div>
        </#if>
    </div>
    <#if fixed>
    </div>
    </#if>
</#macro>