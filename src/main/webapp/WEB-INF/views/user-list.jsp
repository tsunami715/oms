<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/23 0023
  Time: 上午 6:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
    <%@include file="include/head.html" %>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i> 首页
    <span class="c-gray en">&gt;</span> 权限控制
    <span class="c-gray en">&gt;</span> 员工管理
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>
<div class="page-container">
    <form id="form-admin-add">
        <div class="text-c">
            <select id="type1" name="type1" class="input-text" style="width:120px;">
                <option value="1">option1</option>
                <option value="2">option2</option>
                <option value="3">option3</option>
            </select>
            <%--<select id="type1" name="type1" class="input-text" style="width:120px;">--%>
                <%--<c:forEach var="item" items="${contractType}"><option value="${item.key }">${item.value }</option></c:forEach>--%>
            <%--</select>--%>
            <%--<select id="type2" name="type2" class="input-text" style="width:120px;">--%>
                <%--<c:forEach var="item" items="${contractType}"><option value="${item.key }">${item.value }</option></c:forEach>--%>
            <%--</select>--%>
            <%--<select id="type3" name="type3" class="input-text" style="width:120px;">--%>
                <%--<c:forEach var="item" items="${contractType}"><option value="${item.key }">${item.value }</option></c:forEach>--%>
            <%--</select>--%>
            日期范围：
            <input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin" name="datemin" class="input-text Wdate" style="width:180px;">-
            <input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })" id="datemax" class="input-text Wdate" style="width:180px;">
            <input type="text" class="input-text" style="width:250px" placeholder="输入管理员帐号" id="" name="">
            <button type="submit" class="btn btn-success" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜用户</button>
        </div>
    </form>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" onclick="datadel()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
            <a href="javascript:;" onclick="contract_add('添加管理员','contract-info')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加管理员</a>
        </span>
    </div>
    <table id="userList" class="table table-border table-bordered table-bg">
        <thead>
        <tr><th scope="col" colspan="10">员工列表</th></tr>
        <tr class="text-c">
            <th>登录账号</th>
            <th>状态</th>
            <th>所属组别</th>
            <th>最后登录时间</th>
            <th>最后登录ip</th>
            <th width="10%">操作</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>
</div>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
    // 表单中字段的key
    var columns = [
        {data : 'account'},
        {data : 'isDisable' },
        {data : 'groupId'},
        {data : 'lastLoginTime'},
        {data : 'ip'},
        {
            data: function (e) {
                return "";

//                var element = "<button type='button' class='btn btn-info'data-toggle='modal'"
//                    +	"data-target='#amendGroup' onclick='getUserInfo("+e.id+");'>查看</button>&nbsp;&nbsp;";
//                element = element + "<button type='button' class='btn btn-info' onclick='search();'>操作日志</button>";
//                return element;
            },
        },
    ];

        $("#form-admin-add").validate({
            submitHandler:function(form){
                $(form).ajaxSubmit({
                    url: "user" ,
                    success: function(jsonResult){
                        bindJsonTable("userList", jsonResult.data, columns);
                    },
                    error: function(XmlHttpRequest, textStatus, errorThrown){
                        layer.msg('error!',{icon:1,time:1000});
                    }
                });
            }
        });

        $("#form-admin-add").submit();
</script>
</body>
</html>