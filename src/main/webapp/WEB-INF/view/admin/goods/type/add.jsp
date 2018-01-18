<%--
  Created by IntelliJ IDEA.
  User: 周润斌
  Date: 2018/1/16 0016
  Time: 10:08
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
    <title>类型管理</title>
    <link href="${basePath}/resources/common/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/common/plugins/bootstrap-treeview/css/bootstrap-treeview.css" rel="stylesheet"/>
    <link href="${basePath}/resources/common/css/admin.css" rel="stylesheet"/>
    <style>

    .form-title {
        padding: 1em 2em;
        background-color: #29A176;
        border-bottom: 1px solid #D6D5D5;
    }
    .panel {
        background: #FFFFFF;
        padding: 20px;
        margin-bottom: 20px;
        border-radius: 0;
        position: relative;
        box-shadow: 0 -1px 3px rgba(0,0,0,.12), 0 1px 2px rgba(0,0,0,.24);
        border: 1px solid transparent;
    }
    .widget-shadow {
        border: solid 1px #EAEBEC;
    }
    .forms h4 {
        font-size: 1.3em;
        color: #FFFFFF;
        font-family: inherit;
        font-weight: 500;
        line-height: 1.1;
    }

    .form-body {
        padding: 1.5em 2em;
    }

    .row-flex {
        display: flex;
        flex-direction: column;
    }
</style>
</head>
<body>
<div class="panel panel-widget forms-panel">
    <div class="forms">
        <div class="form-grids widget-shadow" data-example-id="basic-forms">
            <div class="form-title">
                <h4>商品分类</h4>
            </div>
            <div class="form-body row-flex">
                    <div class="form-group col-lg-3 " >
                        <label for="name">分类名称</label>
                        <input type="text" class="form-control" id="name" name="name" placeholder="分类名称">
                    </div>
                    <div>
                        <div class="form-group col-lg-3 ">
                            <label for="pid">上级分类</label>
                            <input type="text" id="pid" name="pid" class="form-control" value=""
                                   onclick="$('#treeview').show()" placeholder="分类名称">
                            <div id="treeview" style="display: none;"></div>
                        </div>
                    </div>
                    <div>
                        <div class="form-group col-lg-3 ">
                            <label for="type">类型</label>
                            <input type="text" id="type" name="type" class="form-control" value=""
                                   onclick="$('#treeview2').show()" placeholder="关联类型到下级">
                            <div id="treeview2" style="display: none;"></div>
                        </div>
                    </div>
                    <div class="form-group col-lg-3 ">
                        <label for="type">显示</label>

                    </div>
                    <div class="form-group col-lg-3 ">
                        <label for="type">推荐</label>

                    </div>
                    <div class="form-group col-lg-3 " >
                        <label for="sort">排序</label>
                        <input type="text" class="form-control" id="sort" name="sort" placeholder="排序">
                    </div>
                    <div class="form-group col-lg-3 " >
                        <label for="seoKeyWords">SEO关键字</label>
                        <textarea class="form-control" id="seoKeyWords"></textarea>
                    </div>
                    <div class="form-group col-lg-3 " >
                        <label for="seoDescription">SEO描述</label>
                        <textarea class="form-control" id="seoDescription"></textarea>
                    </div>
                    <div class="form-group col-lg-3 " >
                        <button type="submit" class="btn btn-success">Submit</button>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<jsp:include page="/resources/inc/footer.jsp" flush="true"/>
<script src="${basePath}/resources/common/plugins/bootstrap-treeview/js/bootstrap-treeview.js"></script>
<script>
    var tree = [
        {
            id: 1,
            text: "Parent 1",
            nodes: [
                {
                    text: "Child 1",
                    nodes: [
                        {
                            text: "Grandchild 1"
                        },
                        {
                            text: "Grandchild 2"
                        }
                    ]
                },
                {
                    text: "Child 2"
                }
            ]
        },
        {
            text: "Parent 2"
        },
        {
            text: "Parent 3"
        },
        {
            text: "Parent 4"
        },
        {
            text: "Parent 5"
        }
    ];


    $("#pid").click(function() {
        var options = {
            bootstrap2 : false,
            showTags : true,
            levels : 5,
            showCheckbox : true,
            checkedIcon : "glyphicon glyphicon-check",
            data : tree,
            onNodeSelected : function(event, data) {
                $("#pid").val(data.text);
                $("#treeview").hide();
            }
        };
        $('#treeview').treeview(options);
    });
</script>
</body>
</html>
