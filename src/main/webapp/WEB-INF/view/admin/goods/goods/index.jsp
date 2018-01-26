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
        <title>规格管理</title>
        <jsp:include page="/resources/inc/head.jsp" flush="true"/>
    </head>
    <style>
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
        <div style="display: flex;flex-direction: row;flex-wrap: wrap">
            <div class="form-group-custom col-lg-3">
                <label  class="col-lg-3 control-label">商品名称</label>
                <div class="col-lg-9" style="margin-left: -20px;padding-top: 5px;">
                    <input id="goodsName" type="text" class="form-control"  placeholder="品牌名称" />
                </div>
            </div>
            <div class="form-group-custom col-lg-3">
                <label  class="col-lg-3 control-label">品牌名称</label>
                <div class="col-lg-9" style="margin-left: -20px;">
                    <select id="brandId" name="brandId" style="width: 100%">
                        <option value=""></option>
                        <c:forEach var="obj" items="${brandList}">
                            <option value="${obj.id}">${obj.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group-custom col-lg-3">
                <label  class="col-lg-3 control-label">类别</label>
                <div class="col-lg-9" style="margin-left: -20px;">
                    <select id="classType" name="classType" style="width: 100%">
                        <option value=""></option>
                        <c:forEach var="obj" items="${classList}">
                            <option value="${obj.id}">${obj.className}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group-custom col-lg-3">
                <button  class="btn btn-success" onclick="search()">搜索</button>
                <button  class="btn btn-danger" onclick="resetCondition()">重置</button>
            </div>
            <div class="form-group-custom col-lg-3">
                <label  class="col-lg-3 control-label">特别推荐</label>
                <div class="col-lg-9" style="margin-left: -20px;padding-top: 5px;">
                    <select id="recommend" name="recommend" style="width: 100%">
                        <option value="">是否特别推荐</option>
                        <option value="1">是</option>
                        <option value="0">否</option>
                    </select>
                </div>
            </div>

        </div>
    </div>

    <div id="toolbar">
        <a class="waves-effect waves-button" href="javascript:;" onclick="createAction()"><i class="zmdi zmdi-plus"></i> 新增商品</a>
    </div>
    <table id="table"></table>
</div>
<jsp:include page="/resources/inc/footer.jsp" flush="true"/>
<script>
    var $table = $('#table');
    $(function() {
        // bootstrap table初始化
        $table.bootstrapTable({
            url: '${basePath}/goods/goods/list',
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
                {field: 'goods_name', title: '商品名称',align: 'center'},
                {field: 'name', title: '品牌',align: 'center'},
                {field: 'class_name', title: '分类名',align: 'center'},
                {field: 'store_name', title: '所在店铺',align: 'center'},
                {field: 'goods_status', title: '商品状态',align: 'center',formatter:'statusFormatter'},
                {field: 'store_recommend', title: '特别推荐',align: 'center',formatter:'recommendFormatter'},
                {field: 'goods_click', title: '查看次数',align: 'center'},
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
                        $.post('${basePath}/goods/goods/changeRecommend',{
                            id: event.target.id,
                            storeRecommend: state?"1":"0"
                        },function(data){
                            console.log(data)
                        });
                    }
                });
            }
        });
    });

    function search() {
        $table.bootstrapTable('refresh');
    }

    function resetCondition() {
        $("#classType").val("");
        $("#brandId").val("");
        $("#select2-brandId-container").html("");
        $("#select2-classType-container").html("");
        $("#goodsName").val("");
        $("#recommend").val("");
        $("#select2-recommend-container").html("是否特别推荐");
    }

    function queryParams(params) {
        return {
            sort: params.sort,
            order: params.order,
            classId: $.trim($("#classType").val()),
            brandId: $.trim($("#brandId").val()),
            goodsName: $.trim($("#goodsName").val()),
            recommend: $.trim($("#recommend").val()),
            offset: params.offset,
            limit: params.limit
        };
    }

    function recommendFormatter(value,row,index){
        if (value == "1"){
            return '<input class="push" type="checkbox" id="'+row.id+'" checked/>';
        }else{
            return '<input class="push" type="checkbox" id="'+row.id+'" />';
        }
    }
    function statusFormatter(value,row,index) {
        if (value == '0') {
            return '<span class="label label-success">上架</span>';
        }
        if (value == '1') {
            return '<span class="label label-warning">仓库中</span>';
        }
        if (value == '-1') {
            return '<span class="label label-danger">已下架</span>';
        }
        if (value == '-2') {
            return '<span class="label label-danger">违规下架</span>';
        }
    }

    // 新增
    function createAction() {
        window.location.href = "/goods/type/addPage";
    }

    function details(id) {
        var url = '/goods/goods/goodsDetails?id='+id;
        window.open(url);
    }

    // 格式化操作按钮
    function actionFormatter(value, row, index) {
        return [
            '<a class="update" href="javascript:;" onclick="details('+row.id+')" data-toggle="tooltip" title="查看详情"><i class="glyphicon glyphicon-search"></i></a>　',
            '<a class="delete" href="javascript:;" onclick="deleteAction('+row.id+')" data-toggle="tooltip" title="违规下架"><i class="glyphicon glyphicon-remove"></i></a>',
        ].join('');
    }
</script>
</body>
</html>
