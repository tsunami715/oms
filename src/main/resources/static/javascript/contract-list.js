// 表单中字段的key
var columns = [
    {data: 'id'},
    {data: 'type'},
    {data: 'path'},
    {data: 'startTime'},
    {data: 'endTime'},
    {data: 'producerId'},
    {data: 'signatureCompany'},
    {data: 'signaturePerson'},
    {data: 'remark'},
    {
        "data": function (e) {
            var html = "<a title=\"编辑\" href=\"javascript:;\" class=\"ml-5\" onclick=\"admin_edit('管理员编辑','contract-info?id="+e.id+"')\" style=\"text-decoration:none\">"
                + "<i class=\"Hui-iconfont\">&#xe6df;</i></a>";
            return html;
        }
    }
];

// 页面加载后执行
$(document).ready(function() {
    // 初始化表格信息
    bindDataTable("contractList", "contract", "[]", columns);
})



/*合同资料-增加*/
function contract_add(title, url) {
    layer_show(title, url, '800', '500');
}

/*合同资料-编辑*/

/*管理员-编辑*/
function admin_edit(title, url) {
    layer_show(title, url, '800', '500');
}