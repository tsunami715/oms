<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/16 0016
  Time: 上午 7:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@include file="include/head.html" %>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i> 首页
    <span class="c-gray en">&gt;</span> 信息整合
    <span class="c-gray en">&gt;</span> 合同资料
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>
<div class="page-container">
    <div class="text-c"> 日期范围：
        <input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin" class="input-text Wdate" style="width:120px;">-
        <input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })" id="datemax" class="input-text Wdate" style="width:120px;">
        <input type="text" class="input-text" style="width:250px" placeholder="输入管理员名称" id="" name="">
        <button type="submit" class="btn btn-success" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜用户</button>
    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
            <a href="javascript:;" onclick="admin_add('添加管理员','admin-add.html','800','500')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加管理员</a>
        </span>
    <table id="contractList" class="table table-border table-bordered table-bg">
        <thead>
        <tr><th scope="col" colspan="10">员工列表</th></tr>
        <tr class="text-c">
            <th>合同ID</th>
            <th>合同类型</th>
            <th>合同保存路径</th>
            <th>合同签署日期</th>
            <th>合同终止日期</th>
            <th>供应商</th>
            <th>签章公司</th>
            <th>签章名称</th>
            <th>备注</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
      <%--
        <tr class="text-c">
            <td><input type="checkbox" value="2" name=""></td>
            <td>2</td>
            <td>zhangsan</td>
            <td>13000000000</td>
            <td>admin@mail.com</td>
            <td>栏目编辑</td>
            <td>2014-6-11 11:11:42</td>
            <td class="td-status"><span class="label radius">已停用</span></td>
            <td class="td-manage">
                <a style="text-decoration:none" onClick="admin_start(this,'10001')" href="javascript:;" title="启用">
                    <i class="Hui-iconfont">&#xe615;</i>
                </a>
                <a title="编辑" href="javascript:;" onclick="admin_edit('管理员编辑','admin-add.html','2','800','500')" class="ml-5" style="text-decoration:none">
                    <i class="Hui-iconfont">&#xe6df;</i>
                </a>
                <a title="删除" href="javascript:;" onclick="admin_del(this,'1')" class="ml-5" style="text-decoration:none">
                    <i class="Hui-iconfont">&#xe6e2;</i>
                </a>
            </td>
        </tr>
        --%>
        </tbody>
    </table>
</div>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">

    // 表单中字段的key
    var columns = [
        {data : 'id'},
        {data : 'type'},
        {data : 'path'},
        {data : 'startTime'},
        {data : 'endTime'},
        {data : 'producerId'},
        {data : 'signatureCompany'},
        {data : 'signaturePerson'},
        {data : 'remark'},
//        {
//            "m" : function(){
//                return "<a href='javascript:;' data-toggle='modal' data-target='#myModal' title=''>查看</a>"
//            }
//        },
        {
            "data" : function(e) {
                var html = "<a title=\"编辑\" href=\"javascript:;\" onclick=\"admin_edit('管理员编辑','contract-info','2','800','500')\" class=\"ml-5\" style=\"text-decoration:none\">"
                    +"<i class=\"Hui-iconfont\">&#xe6df;</i></a>";
                return html;
            }
        }
    ];

    bigDataTable("contractList", "contract", "[]", columns);

    function bigDataTable(tableName, requestUrl, queryData, columns) {
        $("#contractList").DataTable({
            "ajaxSource": "contract",
            "language": language,
            "columns":columns,
            "autoWidth":false,
            "displayLength" : 20,
            "lengthChange" : false,
            "searching" : false,
        });
    };

    var language = {// 语言设置
        "sProcessing" : "处理中...",
        "sLengthMenu" : "显示 _MENU_ 项结果",
        "sZeroRecords" : "没有匹配结果",
        "sInfo" : "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
        "sInfoEmpty" : "显示第 0 至 0 项结果，共 0 项",
        "sInfoFiltered" : "(由 _MAX_ 项结果过滤)",
        "sInfoPostFix" : "",
        "sSearch" : "搜索:",
        "sUrl" : "",
        "sEmptyTable" : "表中数据为空",
        "sLoadingRecords" : "载入中...",
        "sInfoThousands" : ",",
        "oPaginate" : {
            "sFirst" : "首页",
            "sPrevious" : "上页",
            "sNext" : "下页",
            "sLast" : "末页"
        }
    };

    /*
        参数解释：
        title	标题
        url		请求的url
        id		需要操作的数据id
        w		弹出层宽度（缺省调默认值）
        h		弹出层高度（缺省调默认值）
    */
    /*管理员-增加*/
    function admin_add(title,url,w,h){
        layer_show(title,url,w,h);
    }
    /*管理员-删除*/
    function admin_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            $.ajax({
                type: 'POST',
                url: '',
                dataType: 'json',
                success: function(data){
                    $(obj).parents("tr").remove();
                    layer.msg('已删除!',{icon:1,time:1000});
                },
                error:function(data) {
                    console.log(data.msg);
                },
            });
        });
    }

    /*管理员-编辑*/
    function admin_edit(title,url,id,w,h){
        layer_show(title,url,w,h);
    }
    /*管理员-停用*/
    function admin_stop(obj,id){
        layer.confirm('确认要停用吗？',function(index){
            // TODO 此处请求后台程序，下方是成功后的前台处理……

            $(obj).parents("tr").find(".td-manage").prepend('<a onClick="admin_start(this,id)" href="javascript:;" title="启用" style="text-decoration:none"><i class="Hui-iconfont">&#xe615;</i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">已禁用</span>');
            $(obj).remove();
            layer.msg('已停用!',{icon: 5,time:1000});
        });
    }

    /*管理员-启用*/
    function admin_start(obj,id){
        layer.confirm('确认要启用吗？',function(index){
            // TODO 此处请求后台程序，下方是成功后的前台处理……


            $(obj).parents("tr").find(".td-manage").prepend('<a onClick="admin_stop(this,id)" href="javascript:;" title="停用" style="text-decoration:none"><i class="Hui-iconfont">&#xe631;</i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
            $(obj).remove();
            layer.msg('已启用!', {icon: 6,time:1000});
        });
    }
</script>
</body>
</html>