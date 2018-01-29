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
    <div id="toolbar" style="flex: 1;">
        <div style="float: left">
            <a class="waves-effect waves-button" href="javascript:;" onclick="createAction()"><i class="zmdi zmdi-plus"></i> 新增类型</a>
            <a class="waves-effect waves-button" href="javascript:;" onclick="updateAction()"><i class="zmdi zmdi-edit"></i> 编辑类型</a>
            <a class="waves-effect waves-button" href="javascript:;" onclick="deleteAction()"><i class="zmdi zmdi-close"></i> 删除类型</a>
        </div>
        <div style="float:left;margin-left: 100px">
            <input id="keywords" type="text" name="keywords" class="form-control" onblur="searchCondition()" placeholder="输入类型名称进行搜索"/>
        </div>
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
            url: '${basePath}/store/type/list',
            height: getHeight(),
            striped: true,
            search: false,
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
            queryParams: queryParams,
            columns: [
                {field: 'ck', checkbox: true},
                {field: 'gradeName', title: '等级名称',align: 'center'},
                {field: 'goodsCount', title: '允许发布商品数量(件)',align: 'center'},
                {field: 'acountNum', title: '可选模板(个)',align: 'center'},
                {field: 'content', title: '收费标准',align: 'center'},
                {field: 'spacesize', title: '附件空间(M)',align: 'center'},
                {field: 'audit', title: '需要审核',align: 'center',formatter:'formatterAudit'},
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

    function searchCondition() {
        $table.bootstrapTable('refresh');
        $("#keywords").val("");
    }
    function queryParams(params) {
        return {
            sort: params.sort,
            order: params.order,
            keywords: $.trim($("#keywords").val()),
            offset: params.offset,
            limit: params.limit
        };
    }

    function formatterAudit(value, row, index) {
        console.log("value>",value)
        console.log("value>",typeof value)
        if (value == true){
            return '<span>是</span>';
        }else{
            return '<span>否</span>';
        }

    }


    // 新增
    function createAction() {
        window.location.href = "/store/type/toAddPage";
    }

    // 格式化操作按钮
    function actionFormatter(value, row, index) {
        return [
            '<a class="update" href="javascript:;" onclick="updateAction()" data-toggle="tooltip" title="Edit"><i class="glyphicon glyphicon-edit"></i></a>　',
            '<a class="delete" href="javascript:;" onclick="deleteAction()" data-toggle="tooltip" title="Remove"><i class="glyphicon glyphicon-remove"></i></a>'
        ].join('');
    }

    // 编辑
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
            window.location.href = "/store/type/toEditType?id="+rows[0].id;
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
            var items="";
            if(rows.length!=1){
                for(var i = 0;i<rows.length;i++){
                   items += rows[i].id+",";
                }
            }else if(rows.length == 1){
                items = rows[0].id
            }
            deleteDialog = $.confirm({
                type: 'red',
                animationSpeed: 300,
                title: false,
                content: '确认删除选中的店铺吗？',
                buttons: {
                    confirm: {
                        text: '确认',
                        btnClass: 'waves-effect waves-button',
                        action: function () {
                            $.ajax({
                                type: 'get',
                                url: '${basePath}/store/type/deleteTypeById?id=' + items,
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
