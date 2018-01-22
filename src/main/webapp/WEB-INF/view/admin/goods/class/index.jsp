<%--
  Created by IntelliJ IDEA.
  User: 周润斌
  Date: 2018/1/15 0015
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%--<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>--%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>分类管理</title>
    <jsp:include page="/resources/inc/head.jsp" flush="true"/>
</head>
<body>
<div style="display: flex;flex-direction: row;">
    <div style="flex:1;padding:1.5em;">
        <ul id="leftTree" class="ztree"></ul>
    </div>
    <div id="main" style="flex:6;">
        <div id="toolbar">
            <a class="waves-effect waves-button" href="javascript:;" onclick="createAction()"><i class="zmdi zmdi-plus"></i> 新增类型</a>
         <%--   <a class="waves-effect waves-button" href="javascript:;" onclick="updateAction()"><i class="zmdi zmdi-edit"></i> 编辑类型</a>
            <a class="waves-effect waves-button" href="javascript:;" onclick="deleteAction()"><i class="zmdi zmdi-close"></i> 删除类型</a>
            <a class="waves-effect waves-button" href="javascript:;" onclick="deleteAction()"><i class="zmdi zmdi-close"></i> 类型详情</a>--%>
        </div>
        <table id="table"></table>
    </div>
</div>

<jsp:include page="/resources/inc/footer.jsp" flush="true"/>

<script>
    var $table = $('#table');
    var zTree;
    $(function() {
        var setting = {
            data:{
                key : {
                    title : "text",
                    name : "text",
                    children: "nodes",
                },
                simpleData : {
                    enable : true,
                    idKey : "id",
                    pIdKey : "pId",
                    rootPId: 0
                },
                edit: {
                    enable: true,
                    drag: {
                        autoExpandTrigger: true,
                        autoOpenTime: 0
                    },
                },
                view: {
                    expandSpeed: "normal",
                }
            },
            expandAll: true,
            showLine : true, //是否显示节点间的连线
            checkable : true, //每个节点上是否显示 CheckBox
            callback: {
                onClick: onClick//单击
            }
        };
        var tree = ${zTreeStr};//后台传递的Jsontree
        var zTreeNodes = eval(tree);

        zTree = $.fn.zTree.init($("#leftTree"), setting, zTreeNodes);
        // bootstrap table初始化
        $table.bootstrapTable({
            url: '${basePath}/goods/class/list',
            height: getHeight(),
            striped: true,
            search: true,
            showRefresh: true,
            showColumns: true,
            minimumCountColumns: 2,
            clickToSelect: true,
            detailView: true,
            detailFormatter: 'detailFormatter',
            pagination: true,
            paginationLoop: false,
            sidePagination: 'server',
            silentSort: false,
            smartDisplay: false,
            escape: true,
            searchOnEnterKey: true,
            idField: 'id',
            sortName: 'sort',
            sortOrder: 'desc',
            maintainSelected: true,
            toolbar: '#toolbar',
            columns: [
                {field: 'ck', checkbox: true},
                {field: 'sort', title: '排序', sortable: true, align: 'left'},
                {field: 'className', title: '分类名称',align: 'left'},
                {field: 'name', title: '类型',align: 'left'},
                {field: 'display', title: '显示',align: 'center',formatter: 'displayFormatter'},
                {field: 'recommend', title: '推荐',align: 'center',formatter: 'recommendFormatter'},
                {field: 'action', title: '操作', align: 'center', formatter: 'actionFormatter', events: 'actionEvents', clickToSelect: false}
            ],
            onLoadSuccess: function(){  //加载成功时执行
                $(".push").bootstrapSwitch({
                    onText:'显示',
                    offText:'隐藏',
                    onColor : "success",
                    offColor : "danger",
                    size : "small",
                    onSwitchChange : function(event, state) {
                        //后台修改状态代码
                        //后台修改状态代码
                        $.post('${basePath}/goods/class/changeStatus',{
                            id: event.target.id,
                            display: state?"1":"0"
                        },function(data){
                            console.log(data)
                        });
                    }
                });
                $(".push2").bootstrapSwitch({
                    onText:'推荐',
                    offText:'不推荐',
                    onColor : "success",
                    offColor : "danger",
                    size : "small",
                    onSwitchChange : function(event, state) {
                        //后台修改状态代码
                        $.post('${basePath}/goods/class/changeStatus',{
                            id: event.target.id,
                            recommend: state?"1":"0"
                        },function(data){
                            console.log(data)
                        });
                    }
                });
            },
        });
    });

    function onClick(event, treeId, treeNode, clickFlag) {
        $('#table').bootstrapTable('refresh', {
            query: {
                    parentId:treeNode.id
            }
        });

    }

    function updateAction(id){
        window.location.href = "/goods/class/editPage?flag=true&id="+id;
    }

    function displayFormatter(value,row,index){
        if (value == "1"){
            return '<input class="push" type="checkbox" id="'+row.id+'" checked/>';
        }else{
            return '<input class="push" type="checkbox" id="'+row.id+'" />';
        }
    }

    function recommendFormatter(value,row,index){
        if (value == "1"){
            return '<input class="push2" type="checkbox" id="'+row.id+'" checked/>';
        }else{
            return '<input class="push2" type="checkbox" id="'+row.id+'" />';
        }
    }

    // 新增
    function createAction() {
        window.location.href = "/goods/class/editPage";
    }

    // 格式化操作按钮
    function actionFormatter(value, row, index) {
        return [
            '<a class="update" href="javascript:;" onclick="updateAction('+row.id+')" data-toggle="tooltip" title="Edit"><i class="glyphicon glyphicon-edit"></i></a>　',
            '<a class="delete" href="javascript:;" onclick="deleteAction()" data-toggle="tooltip" title="Remove"><i class="glyphicon glyphicon-remove"></i></a>'
        ].join('');
    }
</script>
</body>
</html>
