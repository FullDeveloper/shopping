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
    <title>品牌管理</title>
    <link href="${basePath}/resources/common/plugins/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/common/css/admin.css" rel="stylesheet"/>
    <link href="${basePath}/resources/common/plugins/bootstrap-fileinput-master/css/fileinput.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/common/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/common/plugins/jquery-confirm/jquery-confirm.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/common/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet"/>
    <link href="${basePath}/resources/common/css/templates.css" rel="stylesheet"/>

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
        <input name="id" type="hidden" id="id" value="${goodsType.id}"/>
        <div class="forms">
        <div class="form-grids widget-shadow" data-example-id="basic-forms">
            <div class="form-title">
                <h4>类型管理</h4>
            </div>
            <div class="form-body column">
                    <div class="form-group col-lg-3 col-sm-3" >
                        <label for="name">类型名称</label>
                        <input type="text" class="form-control" id="name" value="${goodsType.name}" name="name" placeholder="类型名称" />
                    </div>
                    <div class="form-group col-lg-3 col-sm-3" >
                        <label for="sort">排序</label>
                        <input type="text" class="form-control" id="sort" value="${goodsType.sort}" name="sort" placeholder="排序" />
                    </div>
            </div>
            <div class="form-title">
                <h4>选择关联规格</h4>
            </div>
            <div class="form-body column" style="padding-top: 0px;">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="addsx_table">
                    <tr id="goods_spec_">
                        <td width="82"><strong></strong></td>
                        <td width="271"><strong>规格名称</strong></td>
                        <td width="558"><strong>规格值</strong></td>
                    </tr>
                    <c:forEach items="${goodsSpecifications}" var="item" varStatus="status">
                     <tr>
                        <td>
                            <input type="checkbox" name="propertyIds" <c:if test="${item.checked}">checked</c:if> value="${item.id}" />
                        </td>
                         <td>${item.name}</td>
                         <td>
                             <c:forEach items="${item.specPropertyList}" var="itemSub" varStatus="statusSub">
                                 <c:if test="${statusSub.last}">
                                     ${itemSub.value}
                                 </c:if>
                                 <c:if test="${!statusSub.last}">
                                     ${itemSub.value},
                                 </c:if>
                             </c:forEach>
                         </td>
                     </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="form-title">
                <h4>选择关联品牌</h4>
            </div>
            <div class="form-body column">
                <c:forEach items="${brandCategories}" var="item" varStatus="status">
                    <div class="column" style="margin:5px;">
                        <h6 style="font-weight: bold">${item.name}</h6>
                        <div style="display: flex;flex-direction: row;margin-top:8px;flex-wrap: wrap">
                            <c:forEach items="${item.goodsBrandList}" var="itemSub" varStatus="status">
                                <div style="width: 25%;text-align: left">
                                    <label for="${itemSub.name}${status.index}">${itemSub.name}</label>
                                    <input type="checkbox" id="${itemSub.name}${status.index}" <c:if test="${itemSub.checked}">checked</c:if> name="brandId" value="${itemSub.id}">
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="form-title">
                <h4>新增属性</h4>
            </div>
            <div class="form-body column">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="addsx_table">
                    <tr id="goods_spec_2">
                        <td width="82"><strong>排序</strong></td>
                        <td width="271"><strong>属性名称</strong></td>
                        <td width="558"><strong>属性可选值(多个属性值用“,”分割)</strong></td>
                        <td width="558"><strong>显示</strong></td>
                        <td width="558"><strong>操作</strong></td>
                    </tr>
                    <c:forEach items="${goodsTypeProperties}" var="item">
                    <tr>
                        <td width="82">
                            <input class="form-control" type="hidden" name="id_1" value="${item.id}"  />
                            <input class="form-control" type="number" name="sort_1" value="${item.sort}"  />
                        </td>
                        <td width="271">
                            <input class="form-control" type="text" name="name_1" value="${item.name}" />
                        </td>
                        <td width="558">
                            <input class="form-control" type="text" name="value_1"  value="${item.value}"/>
                        </td>
                        <td width="558">
                            <input class="display" type="checkbox" value="1"
                                   <c:if test="${item.display == 1}">checked</c:if>
                                   name="display_1"  />
                        </td>
                        <td width="558">
                            <a class="delete" href="javascript:;" onclick="remove_goods_spec_property(this.parentNode.parentNode,'')" data-toggle="tooltip" title="Remove">
                                <i class="glyphicon glyphicon-remove"></i>
                            </a>
                        </td>
                    </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="4"><span class="newclass"><a href="javascript:void(0);" onclick="add_goods_spec_property();">新增规格值</a></span></td>
                        <td>&nbsp;</td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="submit">
            <input name="" type="button" value="提交" onclick="saveForm();">
        </div>
    </div>
    </form>
</div>
<script src="${basePath}/resources/common/plugins/jquery.1.12.4.min.js"></script>
<script src="${basePath}/resources/common/plugins/bootstrap-fileinput-master/js/plugins/sortable.min.js"></script>
<script src="${basePath}/resources/common/plugins/bootstrap-fileinput-master/js/fileinput.js"></script>
<script src="${basePath}/resources/common/plugins/bootstrap-fileinput-master/js/locales/zh.js"></script>
<script src="${basePath}/resources/common/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<script src="${basePath}/resources/common/plugins/bootstrap-switch/js/bootstrap-switch.min.js"></script>
<script src="${basePath}/resources/common/plugins/jquery-confirm/jquery-confirm.min.js"></script>

<script>

    var count = 1;
    function add_goods_spec_property(){
        var tr = '<tr><td width="82"><input class="form-control" type="number" name="sort_count"  /> </td> <td width="271"> <input class="form-control" type="text" name="name_count"  /> </td> <td width="558"> <input class="form-control" type="text" name="value_count"  /> </td> <td width="558"> <input class="display" type="checkbox" value="1" name="display_count" checked/> </td> <td width="558"> <a class="delete" href="javascript:;" onclick="remove_goods_spec_property(this.parentNode.parentNode,\'\')" data-toggle="tooltip" title="Remove"> <i class="glyphicon glyphicon-remove"></i> </a> </td></tr>';
        jQuery(".addsx_table tr[id^=goods_spec_]").last().after(tr.replace(/count/g,count));
        $(".display").bootstrapSwitch({
            onText:'显示',
            offText:'隐藏',
            onColor : "success",
            offColor : "danger",
            size : "small",
            onSwitchChange : function(event, state) {
                $(event.target).val(state?"1":"0")
            }
        });
    }

    function remove_goods_spec_property(obj,id){
        jQuery(obj).remove();
        count--;
    }

    function saveForm(){
        var obj = $("#saveForm").serialize();
        $("[name='display_1']").each(function(index, element) {
            obj +="&displayIds="+$(this).val();
        });
        console.log(obj);
        $.ajax({
            url:"${pageContext.request.contextPath}/goods/type/save",
            type:"post",
            data:obj,
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
                                    window.location.href = "${basePath}/goods/type/index";
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
        $(".display").bootstrapSwitch({
            onText:'显示',
            offText:'隐藏',
            onColor : "success",
            offColor : "danger",
            size : "small",
            onSwitchChange : function(event, state) {
                $(event.target).val(state?"1":"0")
            }
        });
    });


</script>
</body>
</html>
