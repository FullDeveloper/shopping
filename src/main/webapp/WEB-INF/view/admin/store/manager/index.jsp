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
    <title>店铺管理</title>
    <jsp:include page="/resources/inc/head.jsp" flush="true"/>
    <link href="${basePath}/resources/common/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet"/>

</head>
<body>
<div id="main">
    <div id="toolbar">
        <a class="waves-effect waves-button" href="javascript:;" onclick="createAction()"><i class="zmdi zmdi-plus"></i> 新增店铺</a>
        <a class="waves-effect waves-button" href="javascript:;" onclick="updateAction()"><i class="zmdi zmdi-edit"></i> 编辑店铺</a>
        <a class="waves-effect waves-button" href="javascript:;" onclick="deleteAction()"><i class="zmdi zmdi-close"></i> 删除店铺</a>
        <a class="waves-effect waves-button" href="javascript:;" onclick="deleteAction()"><i class="zmdi zmdi-close"></i> 类型详情</a>
    </div>
    <table id="table"></table>
</div>
<jsp:include page="/resources/inc/footer.jsp" flush="true"/>
<script src="${basePath}/resources/common/plugins/bootstrap-switch/js/bootstrap-switch.min.js"></script>

<script>
    var $table = $('#table');
    $(function() {
        // bootstrap table初始化
        $table.bootstrapTable({
            url: '${basePath}/store/manager/list',
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
                {field: 'storeName', title: '店铺名称',align: 'center'},
                {field: '', title: '店主用户|店主姓名',align: 'center',formatter:'nameFormatter'},
                {field: '', title: '所在地',align: 'center',formatter:'areaFormatter'},
                {field: 'className', title: '店铺类别',align: 'center'},
                {field: 'gradeName', title: '店铺等级',align: 'center'},
                {field: 'validity', title: '有效期至',align: 'center',formatter:'validityFormatter'},
                {field: 'storeStatus', title: '状态',align: 'center',formatter: 'statusFormatter'},
                {field: 'storeRecommend', title: '推荐',align: 'center',formatter: 'recommendFormatter'},
                {field: 'action', title: '操作', align: 'center', formatter: 'actionFormatter', events: 'actionEvents', clickToSelect: false}
            ],
            onLoadSuccess: function(){  //加载成功时执行
                $(".push").bootstrapSwitch({
                    onText:'上架',
                    offText:'下架',
                    onColor : "success",
                    offColor : "warning",
                    size : "small",
                    onSwitchChange : function(event, state) {
                        //后台修改状态代码
                        $.post('${basePath}/store/manager/changeRecommend?id='+event.target.id+'&flag='+state,null,function(data){
                            console.log(data)
                        });
                    }
                });
            },
        });

    });


    function recommendFormatter(value, row, index) {
        if (value == "1"){
            return '<input class="push" type="checkbox" id="'+row.id+'" checked/>';
        }else{
            return '<input class="push" type="checkbox" id="'+row.id+'" />';
        }

    }

    function areaFormatter(value, row, index) {
        return "<span>"+"["+(row.parentName?row.parentName:'')+"] "+(row.areaName?row.areaName:'')+"</span>";
    }

    function nameFormatter(value, row, index) {
        return "<span>"+(row.userName?row.userName:'')+"|"+(row.storeOwer?row.storeOwer:'')+"</span>";
    }

    function validityFormatter(value, row, index) {
        if(value == ''){
           return '<span>无限制</span>';
        }else{
            return value;
        }
    }
    //处理状态
    function statusFormatter(value, row, index) {
        if (value == '1') {
            return '<span class="label label-warning">审批中</span>';
        }
        if (value == '2') {
            return '<span class="label label-success">正常</span>';
        }
        if (value == '3') {
            return '<span class="label label-danger">关闭</span>';

        }
    }
    // 新增
    function createAction() {
        window.location.href = "/goods/type/addPage";
    }

    // 格式化操作按钮
    function actionFormatter(value, row, index) {
        return [
            '<a class="update" href="javascript:;" onclick="updateAction()" data-toggle="tooltip" title="Edit"><i class="glyphicon glyphicon-edit"></i></a>　',
            '<a class="delete" href="javascript:;" onclick="deleteAction()" data-toggle="tooltip" title="Remove"><i class="glyphicon glyphicon-remove"></i></a>'
        ].join('');
    }

    // 编辑
    var updateDialog;
    function updateAction() {
        var rows = $table.bootstrapTable('getSelections');
        if (rows.length != 1) {
            $.confirm({
                title: false,
                content: '请选择一条记录！',
                autoClose: 'cancel|3000',
                backgroundDismiss: true,
                buttons: {
                    cancel: {
                        text: '取消',
                        btnClass: 'waves-effect waves-button'
                    }
                }
            });
        } else {
            window.location.href = "/store/manager/toEditStore?id="+rows[0].id;
        }
    }

    //删除记录
    var deleteDialog;
    function deleteAction(){
        var rows = $table.bootstrapTable('getSelections');
        if (rows.length == 0) {
            $.confirm({
                title: false,
                content: '请至少选择一条记录！',
                autoClose: 'cancel|3000',
                backgroundDismiss: true,
                buttons: {
                    cancel: {
                        text: '取消',
                        btnClass: 'waves-effect waves-button'
                    }
                }
            });
        }else{
            deleteDialog = $.confirm({
                type: 'red',
                animationSpeed: 300,
                title: false,
                content: '确认删除该店铺吗？',
                buttons: {
                    confirm: {
                        text: '确认',
                        btnClass: 'waves-effect waves-button',
                        action: function () {
                            $.ajax({
                                type: 'get',
                                url: '${basePath}/store/manager/deleteStoreById?id=' + rows[0].id,
                                success: function(result) {
                                    deleteDialog.close();
                                    $table.bootstrapTable('refresh');
                                },
                                error: function(XMLHttpRequest, textStatus, errorThrown) {
                                    $.confirm({
                                        theme: 'dark',
                                        animation: 'rotateX',
                                        closeAnimation: 'rotateX',
                                        title: false,
                                        content: textStatus,
                                        buttons: {
                                            confirm: {
                                                text: '确认',
                                                btnClass: 'waves-effect waves-button waves-light'
                                            }
                                        }
                                    });
                                }
                            });
                        }
                    },
                    cancel: {
                        text: '取消',
                        btnClass: 'waves-effect waves-button'
                    }
                }
            });
        }
    }
</script>
</body>
</html>
