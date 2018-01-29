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
                        <h4>新增店铺</h4>
                    </div>
                    <div class="form-body column">
                        <div class="form-body" style="margin-bottom: -45px">
                            <div class="form-group col-lg-3 col-sm-3" >
                                <label for="userName">店主用户名</label>
                                <input type="text" class="form-control" id="userName" onblur="checkStore()"  name="userName" placeholder="店主用户名">
                            </div>
                        </div>

                        <div id="showAll" class="hidden form-body column">
                            <div class="form-group col-lg-3 col-sm-3" >
                                <label for="storeName">店铺名称</label>
                                <input type="text" class="form-control" id="storeName"  name="storeName" placeholder="店铺名称">
                            </div>
                            <div class="form-group col-lg-3 col-sm-3" >
                                <label for="storeOwer">店主姓名</label>
                                <input type="text" class="form-control" id="storeOwer"  name="storeOwer" placeholder="店主姓名">
                            </div>
                            <div class="form-group col-lg-3 col-sm-3" >
                                <label for="storeOwerCard">店主身份证</label>
                                <input type="text" class="form-control" id="storeOwerCard"  name="storeOwerCard" placeholder="店主身份证">
                            </div>
                            <div class="form-group col-lg-3 col-sm-3" >
                                <label for="className">店铺类型</label>
                                <select id="className" class="form-control" name="className">
                                    <option value="0">请选择店铺类型</option>
                                    <c:forEach var="shopStoreClass" items="${requestScope.shopStoreClasses}">
                                        <option value="${shopStoreClass.id}">${shopStoreClass.className}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group col-lg-3 col-sm-3" style="flex: 1;width: 1000px">
                                <label for="Province">店铺所在地</label>
                                <div id="select1" style="float:none">
                                    <div style="float:left">
                                        <select id="Province" class="form-control" name="Province">
                                            <option value="0">==请选择省==</option>
                                        </select>
                                    </div>
                                    <div style="float:left">
                                        <select id="City" class="form-control" name="City">
                                            <option value="0">==请选择市==</option>
                                        </select>
                                    </div>
                                    <div style="float:left">
                                        <select id="Village" class="form-control" name="Village">
                                            <option value="0">==请选择区==</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group col-lg-3 col-sm-3" >
                                <label for="storeAddress">详细地址</label>
                                <input type="text" class="form-control" id="storeAddress" name="storeAddress" placeholder="详细地址">
                            </div>
                            <div class="form-group col-lg-3 col-sm-3" >
                                <label for="storeZip">店铺邮编</label>
                                <input type="text" class="form-control" id="storeZip" name="storeZip" placeholder="店铺邮编">
                            </div>
                            <div class="form-group col-lg-3 col-sm-3" >
                                <label for="storeTelephone">店铺联系电话</label>
                                <input type="text" class="form-control" id="storeTelephone" name="storeTelephone" placeholder="店铺联系电话">
                            </div>
                            <div class="form-group col-lg-3 col-sm-3" >
                                <label for="gradeName">店铺等级</label>
                                <select id="gradeName" class="form-control" name="gradeName">
                                    <option value="0">请选择店铺等级</option>
                                    <c:forEach var="shopStoreGrades" items="${requestScope.shopStoreGrades}">
                                        <option value="${shopStoreGrades.id}">${shopStoreGrades.gradeName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group col-lg-3 col-sm-3" >
                                <label for="validity">有效期至</label>
                                <input type="date" class="form-control" id="validity" name="validity" placeholder="店铺联系电话">
                                <span style="background-color: #ced1d2;float: left;margin-top: 5px">为空表示无期限</span>
                            </div>
                            <div class="form-group col-lg-3 col-sm-3" >
                                <label for="storeStatus">店铺状态</label>
                                <select id="storeStatus" class="form-control" name="storeStatus">
                                    <option value="0">请选择店铺状态</option>
                                    <option value="1">等待审核</option>
                                    <option value="2">正常营业</option>
                                    <option value="3">违规关闭</option>
                                </select>
                            </div>
                            <div class="form-group col-lg-3 col-sm-3 column">
                                <label for="recommend">是否推荐</label>
                                <input class="push" id="recommend" name="recommend" checked type="checkbox"/>
                            </div>
                            <div class="form-group col-lg-3 col-sm-3 column">
                                <label>认证情况</label>
                                <div>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" name="cardApprove" value="实名认证">实名认证
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" name="realstoreApprove" value="实体店铺认证">实体店铺认证
                                    </label>
                                </div>
                            </div>
                            <div class="form-group col-lg-3 col-sm-3" >
                                <a href="javascript:" class="btn btn-success" onclick="submitInfo()">提交</a>
                            </div>
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
            $.ajax({
                type: 'post',
                data: $("#formId").serialize(),
                url: '${pageContext.request.contextPath}/store/manager/saveStoreInfo',
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
                                       window.location.href = "${basePath}/store/manager/index";
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
            //默认绑定省
            ProviceBind();
            //绑定事件
            $("#Province").change( function () {
                CityBind();
            })

            $("#City").change(function () {
                VillageBind();
            })

            $("#storeStatus").val(${requestScope.map.storeStatus});
            $("#className").val(${requestScope.map.scId});
        })
        function Bind(str) {
            alert($("#Province").html());
            $("#recommend").val(str);
        }

        function ProviceBind() {
            //清空下拉数据
            $("#Province").html("");

            var str = "<option>==请选择===</option>";

            $.ajax({
                type: 'get',
                url: '${basePath}/store/manager/getAddress?item=province&id=0',
                success: function(data) {
                    //从服务器获取数据进行绑定
                    $.each(data, function (i, item) {
                        str += "<option value=" + item.id + ">" + item.areaName + "</option>";
                    })
                    //将数据添加到省份这个下拉框里面
                    $("#Province").append(str);

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
        function checkStore() {
            $.ajax({
                type: 'get',
                url: '${basePath}/store/manager/toCheckStore?userName='+$("#userName").val(),
                success: function(result) {

                    if(result.code==200){
                        $("#showAll").removeClass("hidden");
                    } else{
                        $("#showAll").addClass("hidden");
                        $.confirm({
                            theme: 'dark',
                            animation: 'rotateX',
                            closeAnimation: 'rotateX',
                            title: false,
                            content: result.message,
                            buttons: {
                                confirm: {
                                    text: '确认',
                                    btnClass: 'waves-effect waves-button waves-light'
                                }
                            }
                        });
                    }

                },
                error: function(result) {
                    $.confirm({
                        theme: 'dark',
                        animation: 'rotateX',
                        closeAnimation: 'rotateX',
                        title: false,
                        content: result.message,
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
        function CityBind() {
            var provice = $("#Province").attr("value");
            //判断省份这个下拉框选中的值是否为空
            if (provice == "") {
                return;
            }
            $("#City").html("");
            var str = "<option>==请选择===</option>";

            $.ajax({
                type: 'get',
                url: '${basePath}/store/manager/getAddress?item=city&id='+$("#Province").val(),
                success: function(data) {
                    console.log('result>',data)
                    //从服务器获取数据进行绑定
                    $.each(data, function (i, item) {
                        str += "<option value=" + item.id + ">" + item.areaName + "</option>";
                    })
                    //将数据添加到省份这个下拉框里面
                    $("#City").append(str);

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
        function VillageBind() {
            console.log(document.getElementById("City").value)

            var provice = $("#City").attr("value");
            //判断市这个下拉框选中的值是否为空
            if (provice == "") {
                return;
            }
            $("#Village").html("");
            var str = "<option>==请选择===</option>";
            //将市的ID拿到数据库进行查询，查询出他的下级进行绑定
            $.ajax({
                type: 'get',
                url: '${basePath}/store/manager/getAddress?item=county&id='+$("#City").val(),
                success: function(data) {
                    console.log('result>',data)
                    //从服务器获取数据进行绑定
                    $.each(data, function (i, item) {
                        str += "<option value=" + item.id + ">" + item.areaName + "</option>";
                    })
                    //将数据添加到省份这个下拉框里面
                    $("#Village").append(str);

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


        $(".icon_sys a").on('click',function(){
            $(this).parent().find("a").removeClass("this");
            $(this).addClass("this");
            $("#iconSys").val($(this).attr('icon'));
        });

        $("#recommend").bootstrapSwitch({
            onText:'推荐',
            offText:'不推荐',
            onColor : "success",
            offColor : "danger",
            size : "small",
            onSwitchChange : function(event, state) {


            }
        });
    </script>
</body>
</html>
