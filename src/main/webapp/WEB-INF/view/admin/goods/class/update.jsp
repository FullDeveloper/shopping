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
    <form id="saveForm">
    <div class="forms">
        <div class="form-grids widget-shadow" data-example-id="basic-forms">
            <div class="form-title">
                <h4>商品分类</h4>
            </div>
            <div class="form-body column">
                    <div class="form-group col-lg-3 col-sm-3" >
                        <label for="name">分类名称</label>
                        <input type="text" class="form-control" id="name" name="className" value="${goods.className}" placeholder="分类名称" />
                    </div>
                    <div>
                        <div class="form-group col-lg-3 col-sm-3">
                            <label for="pid">上级分类</label>
                            <input type="text" id="pid" name="pid" class="form-control" value="${typeName}"  onclick="$('#treeview').show()" placeholder="分类名称" />
                            <input type="hidden" id="parentId" name="parentId" class="form-control" value="" />
                            <input type="hidden" id="level" name="level" class="form-control" value="${goods.parentId}" />
                            <div id="treeview" style="display: none;"></div>
                        </div>
                    </div>
                    <div>
                        <div class="form-group col-lg-3 col-sm-3">
                            <label for="type">类型</label>
                            <input type="text" id="type" name="type" class="form-control" value="" onclick="$('#treeview2').show()" placeholder="关联类型到下级">
                            <div id="treeview2" style="display: none;"></div>
                            <input type="hidden" id="goodsTypeId" name="goodsTypeId" value="${goods.goodsTypeId}"/>

                        </div>
                    </div>
                    <div class="form-group col-lg-3 col-sm-3 column">
                        <label for="display">显示</label>
                        <input class="push" id="display" <c:if test="${goods.display==1}">checked</c:if> type="checkbox"/>
                        <input id="display_value" name="display" type="hidden" value="${goods.display}"/>
                    </div>
                    <div class="form-group col-lg-3 col-sm-3 column">
                        <label for="recommend">推荐</label>
                        <input class="push" id="recommend" checked type="checkbox"/>
                        <input id="recommend_value" name="recommend" type="hidden" value="1"/>
                    </div>
                    <div class="form-group col-lg-3 col-sm-3 column">
                        <label>图标</label>
                        <div>
                            <div class="radio radio-inline radio-success">
                                <input id="locked_0" type="radio" name="iconType" value="0" checked onclick="changeImg('0')">
                                <label for="locked_0">系统上传</label>
                            </div>
                            <div class="radio radio-inline radio-info">
                                <input id="sex_1" type="radio" name="iconType" value="1" onclick="changeImg('1')">
                                <label for="sex_1">图片上传 </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group col-lg-3 col-sm-3" id="upload" style="display: none">

                    </div>
                    <div class="form-group col-lg-3 col-sm-3 icon_sys" id="system">
                        <a href="javascript:void(0);" icon="0" class="this"><img src="${basePath}/resources/style/common/images/icon/default_icon.png" /></a>
                        <a href="javascript:void(0);" icon="1"><img src="${basePath}/resources/style/common/images/icon/icon_1.png" /></a>
                        <a href="javascript:void(0);" icon="2"><img src="${basePath}/resources/style/common/images/icon/icon_2.png" /></a>
                        <a href="javascript:void(0);" icon="3"><img src="${basePath}/resources/style/common/images/icon/icon_3.png" /></a>
                        <a href="javascript:void(0);" icon="4"><img src="${basePath}/resources/style/common/images/icon/icon_4.png" /></a>
                        <a href="javascript:void(0);" icon="5"><img src="${basePath}/resources/style/common/images/icon/icon_5.png" /></a>
                        <a href="javascript:void(0);" icon="6"><img src="${basePath}/resources/style/common/images/icon/icon_6.png" /></a>
                        <a href="javascript:void(0);" icon="7"><img src="${basePath}/resources/style/common/images/icon/icon_7.png" /></a>
                        <a href="javascript:void(0);" icon="8"><img src="${basePath}/resources/style/common/images/icon/icon_8.png" /></a>
                        <a href="javascript:void(0);" icon="9"><img src="${basePath}/resources/style/common/images/icon/icon_9.png" /></a>
                        <a href="javascript:void(0);" icon="10"><img src="${basePath}/resources/style/common/images/icon/icon_10.png" /></a>
                        <a href="javascript:void(0);" icon="11"><img src="${basePath}/resources/style/common/images/icon/icon_11.png" /></a>
                        <a href="javascript:void(0);" icon="12"><img src="${basePath}/resources/style/common/images/icon/icon_12.png" /></a>
                        <a href="javascript:void(0);" icon="13"><img src="${basePath}/resources/style/common/images/icon/icon_13.png" /></a>
                        <a href="javascript:void(0);" icon="14"><img src="${basePath}/resources/style/common/images/icon/icon_14.png" /></a>
                        <a href="javascript:void(0);" icon="15"><img src="${basePath}/resources/style/common/images/icon/icon_15.png" /></a>
                        <a href="javascript:void(0);" icon="16"><img src="${basePath}/resources/style/common/images/icon/icon_16.png" /></a>
                        <a href="javascript:void(0);" icon="17"><img src="${basePath}/resources/style/common/images/icon/icon_17.png" /></a>
                        <a href="javascript:void(0);" icon="18"><img src="${basePath}/resources/style/common/images/icon/icon_18.png" /></a>
                        <a href="javascript:void(0);" icon="19"><img src="${basePath}/resources/style/common/images/icon/icon_19.png" /></a>
                        <a href="javascript:void(0);" icon="20"><img src="${basePath}/resources/style/common/images/icon/icon_20.png" /></a>
                        <a href="javascript:void(0);" icon="21"><img src="${basePath}/resources/style/common/images/icon/icon_21.png" /></a>
                        <a href="javascript:void(0);" icon="22"><img src="${basePath}/resources/style/common/images/icon/icon_22.png" /></a>
                        <a href="javascript:void(0);" icon="23"><img src="${basePath}/resources/style/common/images/icon/icon_23.png" /></a>
                        <a href="javascript:void(0);" icon="24"><img src="${basePath}/resources/style/common/images/icon/icon_24.png" /></a>
                        <a href="javascript:void(0);" icon="25"><img src="${basePath}/resources/style/common/images/icon/icon_25.png" /></a>
                        <a href="javascript:void(0);" icon="26"><img src="${basePath}/resources/style/common/images/icon/icon_26.png" /></a>
                        <a href="javascript:void(0);" icon="27"><img src="${basePath}/resources/style/common/images/icon/icon_27.png" /></a>
                        <a href="javascript:void(0);" icon="28"><img src="${basePath}/resources/style/common/images/icon/icon_28.png" /></a>
                        <a href="javascript:void(0);" icon="29"><img src="${basePath}/resources/style/common/images/icon/icon_29.png" /></a>
                        <a href="javascript:void(0);" icon="30"><img src="${basePath}/resources/style/common/images/icon/icon_30.png" /></a>
                        <a href="javascript:void(0);" icon="31"><img src="${basePath}/resources/style/common/images/icon/icon_31.png" /></a>
                        <a href="javascript:void(0);" icon="32"><img src="${basePath}/resources/style/common/images/icon/icon_32.png" /></a>
                        <a href="javascript:void(0);" icon="33"><img src="${basePath}/resources/style/common/images/icon/icon_33.png" /></a>
                        <a href="javascript:void(0);" icon="34"><img src="${basePath}/resources/style/common/images/icon/icon_34.png" /></a>
                        <a href="javascript:void(0);" icon="35"><img src="${basePath}/resources/style/common/images/icon/icon_35.png" /></a>
                        <a href="javascript:void(0);" icon="36"><img src="${basePath}/resources/style/common/images/icon/icon_36.png" /></a>
                        <a href="javascript:void(0);" icon="38"><img src="${basePath}/resources/style/common/images/icon/icon_38.png" /></a>
                        <a href="javascript:void(0);" icon="39"><img src="${basePath}/resources/style/common/images/icon/icon_39.png" /></a>
                        <a href="javascript:void(0);" icon="40"><img src="${basePath}/resources/style/common/images/icon/icon_40.png" /></a>
                        <input type="hidden" id="iconSys" name="iconSys" value="0"/>
                    </div>
                    <div class="form-group col-lg-3 col-sm-3" >
                        <label for="sort">排序</label>
                        <input type="text" class="form-control" id="sort" name="sort" placeholder="排序">
                    </div>
                    <div class="form-group col-lg-3 col-sm-3" >
                        <label for="seoKeyWords">SEO关键字</label>
                        <textarea class="form-control" id="seoKeyWords" name="seoKeywords"></textarea>
                    </div>
                    <div class="form-group col-lg-3 col-sm-3" >
                        <label for="seoDescription">SEO描述</label>
                        <textarea class="form-control" id="seoDescription" name="seoDescription"></textarea>
                    </div>
                    <div class="form-group col-lg-3 col-sm-3" >
                        <a href="javascript:" class="btn btn-success" onclick="saveForm()">保存</a>
                    </div>
                </div>

            </div>
        </div>
    </form>
</div>
<jsp:include page="/resources/inc/footer.jsp" flush="true"/>
<script src="${basePath}/resources/common/plugins/bootstrap-switch/js/bootstrap-switch.min.js"></script>
<script src="${basePath}/resources/common/plugins/bootstrap-treeview/js/bootstrap-treeview.js"></script>
<script src="${basePath}/resources/common/plugins/jquery-confirm/jquery-confirm.min.js"></script>

<script>
    var tree = ${jsonStr};
    var treeType = ${typeStr};

    function changeImg(type){
        if(type == "0"){
            $("#upload").hide();
            $("#system").show();
        }else{
            $("#system").hide();
            $("#upload").show();
        }
    }

    function saveForm(){
        $.ajax({
            url:"${pageContext.request.contextPath}/goods/class/save",
            type:"post",
            data:$("#saveForm").serialize(),
            success:function(data){
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
                                action: function (){
                                    window.location.href = "${basePath}/goods/class/index";
                                }
                            }
                        }
                    });
                }
            },
            error:function(e){
            }
        });
    }

    $(function(){
        $("#pid").click(function() {
            var options = {
                bootstrap2 : false,
                showTags : true,
                levels : 1,
                showCheckbox : true,
                checkedIcon : "glyphicon glyphicon-check",
                data : tree,
                onNodeSelected : function(event, data) {
                    $("#pid").val(data.text);
                    $("#treeview").hide();
                    $("#parentId").val(data.id);
                    $("#level").val(data.level);
                }
            };
            $('#treeview').treeview(options);
        });
        $("#type").click(function() {
            var options = {
                bootstrap2 : false,
                showTags : true,
                levels : 1,
                showCheckbox : true,
                checkedIcon : "glyphicon glyphicon-check",
                data : treeType,
                onNodeSelected : function(event, data) {
                    $("#type").val(data.text);
                    $("#treeview2").hide();
                    $("#goodTypeId").val(data.id);
                }
            };
            $('#treeview2').treeview(options);
        });


        $(".icon_sys a").on('click',function(){
            $(this).parent().find("a").removeClass("this");
            $(this).addClass("this");
            $("#iconSys").val($(this).attr('icon'));
        });

        $("#display").bootstrapSwitch({
            onText:'显示',
            offText:'隐藏',
            onColor : "success",
            offColor : "danger",
            size : "small",
            onSwitchChange : function(event, state) {
                if(state){
                    $("#display_value").val("1");
                }else{
                    $("#display_value").val("0");
                }
            }
        });
        $("#recommend").bootstrapSwitch({
            onText:'推荐',
            offText:'不推荐',
            onColor : "success",
            offColor : "danger",
            size : "small",
            onSwitchChange : function(event, state) {
                if(state){
                    $("#recommend_value").val("1");
                }else{
                    $("#recommend_value").val("0");
                }
            }
        });
    });


</script>
</body>
</html>
