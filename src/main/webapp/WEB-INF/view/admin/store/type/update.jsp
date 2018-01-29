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
    <%--<link href="${basePath}/resources/common/plugins/bootstrap-treeview/css/bootstrap-treeview.css" rel="stylesheet"/>--%>
    <link href="${basePath}/resources/common/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/common/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet"/>
    <link href="${basePath}/resources/common/css/admin.css" rel="stylesheet"/>
    <link href="${basePath}/resources/common/plugins/jquery-confirm/jquery-confirm.min.css" rel="stylesheet"/>


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

        .column {
            display: flex;
            flex-direction: column;
        }
        .icon_sys img {
            width: 20px;
            height: 18px;
            margin-top: -5px;
        }

        .this {
            background: url(/resources/common/css/images/this.gif) no-repeat;
            color: #FFF;
        }

        .icon_sys a {
            border: 1px solid #CCC;
            width: 22px;
            height: 19px;
            margin-right: 5px;
            float: left;
            margin-bottom: 5px;
        }

        .icon_sys a.this {
            border: 1px solid #F00;
            background: none;
        }
    </style>
</head>
<body style="overflow: auto">
    <div class="panel panel-widget forms-panel">
        <div class="forms">
            <form id="formId">
                <div class="form-grids widget-shadow" data-example-id="basic-forms">
                    <div class="form-title">
                        <h4>新增类型</h4>
                    </div>
                    <div class="form-body column">
                        <div class="form-group col-lg-3 col-sm-3">
                            <label for="gradeName">等级名称</label>
                            <input type="text" class="form-control" id="gradeName" name="gradeName" value="${shopStoreGrade.gradeName}" placeholder="等级名称">
                            <input type="hidden" name="id" value="${shopStoreGrade.id}">
                        </div>
                        <div class="form-group col-lg-3 col-sm-3" >
                            <label for="goodsCount">允许发布商品数</label>
                            <input type="text" class="form-control" id="goodsCount"  name="goodsCount" value="${shopStoreGrade.goodsCount}" placeholder="允许发布商品数">
                        </div>
                        <div class="form-group col-lg-3 col-sm-3" >
                            <label for="spacesize">店铺附件空间</label>
                            <input type="text" class="form-control" id="spacesize" value="${shopStoreGrade.spacesize}"  name="spacesize" placeholder="店铺附件空间">
                        </div>
                        <div class="form-group col-lg-3 col-sm-3" >
                            <label for="gradeLevel">等级序号</label>
                            <input type="text" class="form-control" id="gradeLevel" value="${shopStoreGrade.gradeLevel}" name="gradeLevel" placeholder="越小显示越靠前">
                        </div>
                        <div class="form-group col-lg-3 col-sm-3" >
                            <label for="sequence">等级级别</label>
                            <input type="text" class="form-control" id="sequence" value="${shopStoreGrade.sequence}" name="sequence" placeholder="数值越大级别越高，用于店铺升级">
                        </div>
                        <div class="form-group col-lg-3 col-sm-3" >
                            <label for="acountNum">允许子账户个数</label>
                            <input type="text" class="form-control" id="acountNum" value="${shopStoreGrade.acountNum}" name="acountNum" placeholder="允许卖家添加的子账户个数">
                        </div>
                        <div class="form-group col-lg-3 col-sm-3 column">
                            <label for="audit">是否需要审核</label>
                            <input class="push" id="audit" name="audit1" <c:if test="${shopStoreGrade.audit}">checked</c:if> type="checkbox"/>
                            <span>需要审核等级，用户提交申请后需管理员确认方可开通</span>
                        </div>
                        <div class="form-group col-lg-3 col-sm-3" >
                            <label for="templates">可选模板套数</label>
                            <div>
                                <span id="templates"  name="templates">0(在店铺等级列表设置)</span>
                            </div>
                            <%--<input type="text" disabled class="form-control" id="availableModel"  name="availableModel" placeholder="允许子账户个数">--%>
                        </div>
                        <div class="form-group col-lg-3 col-sm-3 column">
                            <label>可用附加功能</label>
                            <div>
                                <label class="checkbox-inline">
                                    <input type="checkbox" id="addFunction" name="addFunction" value="编辑器多媒体功能">编辑器多媒体功能
                                </label>
                            </div>
                        </div>
                        <div class="form-group col-lg-3 col-sm-3" >
                            <label for="price">收费标准</label>
                            <input type="text" class="form-control" id="price" value="${shopStoreGrade.price}" name="price" placeholder="收费标准，在会员开通或升级店铺时将显示在前台">
                        </div>
                        <div class="form-group col-sm-3">
                            <label for="content1">申请说明</label>
                            <textarea name="content" class="form-control" id="content1" cols="30" rows="5">${shopStoreGrade.content}</textarea>
                        </div>
                        <div class="form-group col-lg-3 col-sm-3" >
                            <a href="javascript:" class="btn btn-success" onclick="submitInfo()">提交</a>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
    </div>
    <script src="${basePath}/resources/common/plugins/jquery.1.12.4.min.js"></script>
    <script src="${basePath}/resources/common/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
    <script src="${basePath}/resources/common/plugins/bootstrap-switch/js/bootstrap-switch.min.js"></script>
    <script src="${basePath}/resources/common/plugins/jquery-confirm/jquery-confirm.min.js"></script>

    <%--<script src="${basePath}/resources/common/plugins/bootstrap-treeview/js/bootstrap-treeview.js"></script>--%>
    <script>
        function submitInfo() {
            var formData = new FormData(document.getElementById("formId"));
            console.log(formData)
            $.ajax({
                type: 'post',
                data: formData,
                url: '${pageContext.request.contextPath}/store/type/updateTypeInfo',
                processData:false,
                contentType:false,
                success: function(result) {
                   if(result.code==200){
                       $.confirm({
                           theme: 'dark',
                           animation: 'rotateX',
                           closeAnimation: 'rotateX',
                           title: false,
                           content: result.message,
                           buttons: {
                               confirm: {
                                   text: '确认',
                                   btnClass: 'waves-effect waves-button waves-light',
                                   action: function (){
                                       window.location.href = "${basePath}/store/type/index";
                                   }
                               }
                           }
                       });
                   }
                },
                error: function (result) {
                    alert("修改错误!"+result.message);
                }
            });

        }
        $(function () {
            if(${shopStoreGrade.audit}){
                $("#audit").val("on");
            }

            $("#className").val(${requestScope.map.scId});
        })

        $(".icon_sys a").on('click',function(){
            $(this).parent().find("a").removeClass("this");
            $(this).addClass("this");
            $("#iconSys").val($(this).attr('icon'));
        });

        $("#audit").bootstrapSwitch({
            onText:'需要',
            offText:'不需要',
            onColor : "success",
            offColor : "danger",
            size : "small",
            onSwitchChange : function(event, state) {


            }
        });
    </script>
</body>
</html>
