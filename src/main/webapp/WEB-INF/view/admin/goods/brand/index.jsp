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
        <title>品牌管理</title>
        <jsp:include page="/resources/inc/head.jsp" flush="true"/>
    </head>
    <style>

        #table tr td{
            line-height: 44px;
        }

        .form-group-custom {
            line-height: 40px;
        }

    </style>
<body>
<div id="main" style="display: flex;flex-direction: column;">
    <div class="panel panel-default" >
        <div class="panel-heading">
            查询条件
        </div>
        <div style="display: flex;flex-direction: row;">
            <div class="form-group-custom col-lg-3">
                <label  class="col-lg-3 control-label">品牌名称</label>
                <div class="col-lg-9" style="margin-left: -20px;padding-top: 5px;">
                    <input id="brandName" type="text" class="form-control"  placeholder="品牌名称" />
                </div>
            </div>
            <div class="form-group-custom col-lg-3">
                <label  class="col-lg-3 control-label">分类名称</label>
                <div class="col-lg-9" style="margin-left: -20px;padding-top: 5px;">
                    <input id="categoryName" type="text" class="form-control"   placeholder="分类名称">
                </div>
            </div>
            <div class="form-group-custom col-lg-3">
                <button  class="btn btn-success" onclick="search()">搜索</button>
                <button  class="btn btn-danger" onclick="resetCondition()">重置</button>
            </div>
        </div>

    </div>
    <div id="toolbar">
        <a class="waves-effect waves-button" href="javascript:;" onclick="createAction()"><i class="zmdi zmdi-plus"></i> 新增品牌</a>
    </div>
    <table id="table"></table>
</div>
<jsp:include page="/resources/inc/footer.jsp" flush="true"/>
<script>
    var $table = $('#table');
    $(function() {
        // bootstrap table初始化
        $table.bootstrapTable({
            url: '${basePath}/goods/brand/list',
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
                {field: 'sort', title: '排序', sortable: true, align: 'center'},
                {field: 'first_word', title: '首字母',align: 'center'},
                {field: 'brandName', title: '品牌名称',align: 'center'},
                {field: 'categoryName', title: '类别',align: 'center'},
                {field: 'name', title: '品牌图片标识',align: 'center',formatter:'imageFormatter'},
                {field: 'recommend', title: '推荐',align: 'center',formatter:'recommendFormatter'},
                {field: 'action', title: '操作', align: 'center', formatter: 'actionFormatter', events: 'actionEvents', clickToSelect: false}
            ],
            onLoadSuccess: function(){  //加载成功时执行
                $(".push").bootstrapSwitch({
                    onText:'推荐',
                    offText:'不推荐',
                    onColor : "success",
                    offColor : "danger",
                    size : "small",
                    onSwitchChange : function(event, state) {
                        //后台修改状态代码
                        //后台修改状态代码
                        $.post('${basePath}/goods/brand/changeRecommend',{
                            id: event.target.id,
                            recommend: state?"1":"0"
                        },function(data){
                            console.log(data)
                        });
                    }
                });
            }
        });
    });

    function queryParams(params) {
        return {
            sort: params.sort,
            order: params.order,
            categoryName: $.trim($("#categoryName").val()),
            brandName: $.trim($("#brandName").val()),
            offset: params.offset,
            limit: params.limit
        };
    }

    function search() {
        $table.bootstrapTable('refresh');
    }

    function resetCondition() {
        $("#categoryName").val("");
        $("#brandName").val("");
    }

    function recommendFormatter(value,row,index){
        if (value == "1"){
            return '<input class="push" type="checkbox" id="'+row.id+'" checked/>';
        }else{
            return '<input class="push" type="checkbox" id="'+row.id+'" />';
        }
    }

    function imageFormatter(value,row,index){

        return "<img src='${basePath}/"+row.path+"/"+row.logoName+"' height='44px' width='88px' />"
    }

    // 新增
    function createAction() {
        window.location.href = "/goods/brand/addPage";
    }

    function updateAction(id) {
        window.location.href = "/goods/brand/toUpdatePage?id="+id;
    }

    function deleteAction(id) {
        $.confirm({
            type: 'red',
            animationSpeed: 300,
            title: false,
            content: '确认是否删除该商品品牌？',
            buttons: {
                confirm: {
                    text: '确认',
                    btnClass: 'waves-effect waves-button',
                    action: function () {
                        $.post('${basePath}/goods/brand/deleteBrand',{id:id},function(data){
                            if(data.code == 1){
                                $.confirm({
                                    theme: 'dark',
                                    animation: 'rotateX',
                                    closeAnimation: 'rotateX',
                                    title: false,
                                    content: data.message,
                                    buttons: {
                                        confirm: {
                                            text: '确认',
                                            btnClass: 'waves-effect waves-button waves-light',
                                            /*action: function(){
                                                window.location.reload();
                                            }*/
                                        }
                                    }
                                });
                            } else{
                                $.confirm({
                                    theme: 'dark',
                                    animation: 'rotateX',
                                    closeAnimation: 'rotateX',
                                    title: false,
                                    content: data.message,
                                    buttons: {
                                        confirm: {
                                            text: '确认',
                                            btnClass: 'waves-effect waves-button waves-light'
                                        }
                                    }
                                });
                            }
                            $table.bootstrapTable('refresh');
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

    // 格式化操作按钮
    function actionFormatter(value, row, index) {
        return [
            '<a class="update" href="javascript:;" onclick="updateAction('+row.id+')" data-toggle="tooltip" title="Edit"><i class="glyphicon glyphicon-edit"></i></a>　',
            '<a class="delete" href="javascript:;" onclick="deleteAction('+row.id+')" data-toggle="tooltip" title="Remove"><i class="glyphicon glyphicon-remove"></i></a>'
        ].join('');
    }
</script>
</body>
</html>
