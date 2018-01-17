<%--
  Created by IntelliJ IDEA.
  User: 周润斌
  Date: 2018/1/16 0016
  Time: 15:00
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
    <title>新增规格</title>
    <link href="${basePath}/resources/common/css/templates.css" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <h1 class="head-text">规格管理</h1>
    <div class="tab">
        <span class="tab-one"></span>
        <span class="tabs">
            <a href="/goods/specification/index">管理</a>
            |
            <a href="#" class="this">新增</a>
        </span>
        <span class="tab-two"></span>
    </div>
    <form id="saveForm">
        <div class="edit">
            <div class="edit-input">
                <ul class="set3">
                    <li>
                        <strong class="span-red">*</strong>
                        规格名称
                    </li>
                    <li>
                        <span class="pxnum">
                            <input name="name" type="text" id="name" value=""/>
                        </span>
                        <span class="nothis">
                            <strong class="q"></strong>
                            <strong class="w">请填写常用的商品规格的名称；例如：颜色；尺寸等。</strong>
                            <strong class="c"></strong>
                        </span>
                    </li>
                </ul>
                <ul class="set3">
                    <li>
                        <strong class="span-red">*</strong>
                        排序
                    </li>
                    <li>
                        <span class="pxnum">
                            <input name="sort" type="text" id="sort" value=""/>
                        </span>
                        <span class="nothis">
                            <strong class="q"></strong>
                            <strong class="w">请填写整数。类型列表将会根据排序进行由小到大排列显示。</strong>
                            <strong class="c"></strong>
                        </span>
                    </li>
                </ul>
            </div>
            <div class="spec_type">
                <h3>规格类型</h3>
                <ul class="set3">
                    <li>
                        <span class="ssp1">
                            <input name="type" type="radio" id="type1" value="text" checked="checked"  onclick="img_spec('0')"/>文字
                        </span>
                        <span class="ssp2">
                            <input name="type" id="type2" type="radio" value="img" onclick="img_spec('1')"/>图片
                        </span>
                        <span class="nothis">
                            <strong class="q"></strong>
                            <strong class="w">图片类型的规格值用于直观表现某些特殊规格类型，例如颜色规格，可用对应的色彩图片来表现其各种颜色值。</strong>
                            <strong class="c"></strong>
                        </span>
                    </li>
                </ul>
            </div>
            <div class="specification">
                <h2>新增规格值</h2>
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="addsx_table">
                    <tr id="goods_spec_">
                        <td width="82"><strong>排序</strong></td>
                        <td width="271"><strong>规格值</strong></td>
                        <td width="558"><strong><div id="goods_spec_property_img_">规格图片</div></strong></td>
                        <td  align="center">操作</td>
                    </tr>
                    <tr id="goods_spec_property">
                        <td width="82">
                            <span class="pxnum size5">
                                <input name="sequence_1" type="text" id="sequence_1" value=""/>
                            </span>
                        </td>
                        <td width="271">
                            <span class="pxnum size7">
                                <input name="value_1" type="text" id="value_1" value=""/>
                            </span>
                        </td>
                        <td width="558" class="liul" >
                            <div id="goods_spec_property_img_">
                                <span class="size13">
                                    <input name="textfield_1" type="text" id="textfield_1" />
                                 </span>
                                <span class="filebtn">
                                    <input name="button" type="button" id="button1"/>
                                 </span>
                                <span style="float:left;" class="file" >
                                    <input name="specImage_1" type="file" id="specImage_1" size="30"  onchange="change_img(this);"/>
                                </span>
                                <span class="pic_spe">
                                    <%--<img id="image_1" name="image_1" src="${basePath}/resources/common/css/images/transparent.gif" width="16" height="16"/>--%>
                                </span>
                            </div>
                        </td>
                        <td width="116" align="center" class="ac8"><a href="javascript:void(0);" onclick="remove_goods_spec_property(this.parentNode.parentNode,'')">删除</a></td>
                    </tr>
                    <tr>
                        <td colspan="3"><span class="newclass"><a href="javascript:void(0);" onclick="add_goods_spec_property();">新增规格值</a></span></td>
                        <td>&nbsp;</td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="submit">
            <input name="" type="button" value="提交" onclick="saveForm();">
        </div>
        <input type="hidden" id="count" name="count" />
    </form>
</div>
<script src="${basePath}/resources/common/plugins/jquery.1.12.4.min.js"></script>
<script src="${basePath}/resources/common/js/util.js"></script>
<script>

    $(function() {
        var type=jQuery(":radio:checked").val();
        if(type=="img"){
            jQuery("div[id^=goods_spec_property_img_]").show();
        }else{
            jQuery("div[id^=goods_spec_property_img_]").hide();
        }
    });

    var count = 1;
    function change_img(obj) {
        var sequence=jQuery(obj).attr("id").substring(10);
        var path=jQuery(obj).val();
        jQuery("#textfield_"+sequence).val(path);
    }

    function add_goods_spec_property(){
        count ++;
        var tr = '<tr id="goods_spec_"><td width="82"><span class="pxnum size5"><input name="sequence_count" type="text" id="sequence_count" value="" /></span></td><td width="271"><span class="pxnum size7"><input name="value_count" type="text" id="value_count" value=""/></span></td><td width="558" class="liul" ><div id="goods_spec_property_img_"><span class="size13"><input name="textfield_count" type="text" id="textfield_count" /></span><span class="filebtn"><input name="button" type="button"/></span><span style="float:left;" class="file" ><input name="specImage_count" type="file" id="specImage_count" size="30"  onchange="change_img(this);"/></span></div></td><td width="116" align="center" class="ac8"><a href="javascript:void(0);" onclick="remove_goods_spec_property(this.parentNode.parentNode,\'\')">删除</a></td>';
        var none = '<tr id="goods_spec_"><td width="82"><span class="pxnum size5"><input name="sequence_count" type="text" id="sequence_count" value="" /></span></td><td width="271"><span class="pxnum size7"><input name="value_count" type="text" id="value_count" value=""/></span></td><td width="558" class="liul" ><div id="goods_spec_property_img_" style="display: none;"><span class="size13"><input name="textfield_count" type="text" id="textfield_count" /></span><span class="filebtn"><input name="button" type="button"/></span><span style="float:left;" class="file" ><input name="specImage_count" type="file" id="specImage_count" size="30"  onchange="change_img(this);"/></span></div></td><td width="116" align="center" class="ac8"><a href="javascript:void(0);" onclick="remove_goods_spec_property(this.parentNode.parentNode,\'\')">删除</a></td>';
        var type=jQuery(":radio:checked").val();
        if(type=="img"){
            jQuery(".addsx_table tr[id^=goods_spec_]").last().after(tr.replace(/count/g,count));
        }else{
            jQuery(".addsx_table tr[id^=goods_spec_]").last().after(none.replace(/count/g,count));
        }

    }

    function img_spec(status){
        if(status=="1"){
            jQuery("div[id^=goods_spec_property_img_]").show();
        }
        if(status=="0"){
            jQuery("div[id^=goods_spec_property_img_]").hide();
        }
    }

    function remove_goods_spec_property(obj,id){
        jQuery(obj).remove();
        count--;
    }

    function saveForm() {
        $("#count").val(count);
        var form = new FormData(document.getElementById("saveForm"));
        $.ajax({
            url:"${pageContext.request.contextPath}/goods/specification/save",
            type:"post",
            data:form,
            processData:false,
            contentType:false,
            success:function(data){
                if(data.code == 1){
                    alert(data.message);
                    window.location.href = "${basePath}/goods/sepcification/index";
                }
            },
            error:function(e){
            }
        });
    }

</script>
</body>
</html>
