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
        .form-title1 {
            margin-top: 20px;
            padding: 0.3em 3em;
            background-color: #eead00;
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
        .forms h5 {
            font-size: 1em;
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
        .reputation_table {
            width:100%;
            border-collapse:collapse;
            border:none;
            margin-left:10px;
            border:0px ;
            cellspacing:0px;
            cellpadding:0px;
        }
        .spoprat span {
            margin-left:3px;
            margin-right:3px;
        }
        .allmen input {
            height:30px;
            line-height:22px;
            padding-left:5px;
            border:1px solid #C6C6C6;
            border-radius: 4px;
        }
        .size5 input {
            width:100px;
        }
        .mgr5 {
            margin-right: 5px;
        }
    </style>
</head>
<body style="overflow: auto">
    <div class="panel panel-widget forms-panel">
        <div class="forms">
            <div class="form-grids widget-shadow" data-example-id="basic-forms">
                <div class="form-title1">
                    <h5>店铺管理</h5>
                </div>
                <div class="form-body row ">
                    <div class="col-lg-3 col-sm-3 column">
                        <label for="applyStatus">开店申请</label>
                        <input class="push" id="applyStatus" name="applyStatus"  <c:if test="${storeAllow==true}">checked</c:if> type="checkbox"/>
                        <span class="alert alert-info" style="margin-top: 10px">开启后用户可以申请开店,关闭后不可以申请开店!</span>
                    </div>
                </div>
                <form id="formId">
                    <div class="form-title1">
                        <h5>信用额度</h5>
                    </div>
                    <div class="form-body row" style="width: 2000px">
                        <table class="table table-hover" style="width:0">
                            <tr>
                                <td width="215"><strong>等级</strong></td>
                                <td><strong>信用介于</strong></td>
                            </tr>
                            <tr>
                                <td class="spoprat"><span><img class="mgr5" class="mgr5" src="${basePath}\resources\images\level_0.gif" width="15" height="14" /></span></td>
                                <td class="spoprat"><span class="allmen size5">
                                    <input name="creditrule0" type="text" id="creditrule0" value="${creditRules.creditrule0}"/>
                                    </span><span>-</span><span class="allmen size5">
                                    <input name="creditrule1" type="text" id="creditrule1" value="${creditRules.creditrule1}"/>
                                    </span></td>
                            </tr>
                            <tr>
                                <td class="spoprat"><span><img class="mgr5" src="${basePath}\resources\images\level_0.gif" width="15" height="14" /><img class="mgr5" src="${basePath}\resources\images\level_0.gif" width="15" height="14" /></span></td>
                                <td class="spoprat"><span class="allmen size5">
                                    <input name="creditrule2" type="text" id="creditrule2" value="${creditRules.creditrule2}"/>
                                    </span><span>-</span><span class="allmen size5">
                                    <input name="creditrule3" type="text" id="creditrule3" value="${creditRules.creditrule3}"/>
                                    </span></td>
                            </tr>
                            <tr>
                                <td class="spoprat"><span><img class="mgr5" src="${basePath}\resources\images\level_0.gif" width="15" height="14" /><img class="mgr5" src="${basePath}\resources\images\level_0.gif" width="15" height="14" /><img class="mgr5" src="${basePath}\resources\images\level_0.gif" width="15" height="14" /></span></td>
                                <td class="spoprat"><span class="allmen size5">
                                    <input name="creditrule4" type="text" id="creditrule4" value="${creditRules.creditrule4}"/>
                                    </span><span>-</span><span class="allmen size5">
                                    <input name="creditrule5" type="text" id="creditrule5" value="${creditRules.creditrule5}"/>
                                    </span></td>
                            </tr>
                            <tr>
                                <td class="spoprat"><span><img class="mgr5" src="${basePath}\resources\images\level_0.gif" width="15" height="14" /><img class="mgr5" src="${basePath}\resources\images\level_0.gif" width="15" height="14" /><img class="mgr5" src="${basePath}\resources\images\level_0.gif" width="15" height="14" /><img class="mgr5" src="${basePath}\resources\images\level_0.gif" width="15" height="14" /></span></td>
                                <td class="spoprat"><span class="allmen size5">
                                    <input name="creditrule6" type="text" id="creditrule6" value="${creditRules.creditrule6}"/>
                                    </span><span>-</span><span class="allmen size5">
                                    <input name="creditrule7" type="text" id="creditrule7" value="${creditRules.creditrule7}"/>
                                    </span></td>
                            </tr>
                            <tr>
                                <td class="spoprat"><span><img class="mgr5" src="${basePath}\resources\images\level_0.gif" width="15" height="14" /><img class="mgr5" src="${basePath}\resources\images\level_0.gif" width="15" height="14" /><img class="mgr5" src="${basePath}\resources\images\level_0.gif" width="15" height="14" /><img class="mgr5" src="${basePath}\resources\images\level_0.gif" width="15" height="14" /><img class="mgr5" src="${basePath}\resources\images\level_0.gif" width="15" height="14" /></span></td>
                                <td class="spoprat"><span class="allmen size5">
                                    <input name="creditrule8" type="text" id="creditrule8" value="${creditRules.creditrule8}"/>
                                    </span><span>-</span><span class="allmen size5">
                                    <input name="creditrule9" type="text" id="creditrule9" value="${creditRules.creditrule9}"/>
                                    </span></td>
                            </tr>
                            <tr>
                                <td class="spoprat"><span><img class="mgr5" src="${basePath}\resources\images\level_1.gif" width="15" height="14" /></span></td>
                                <td class="spoprat"><span class="allmen size5">
                                    <input name="creditrule10" type="text" id="creditrule10" value="${creditRules.creditrule10}"/>
                                    </span><span>-</span><span class="allmen size5">
                                    <input name="creditrule11" type="text" id="creditrule11" value="${creditRules.creditrule11}"/>
                                    </span></td>
                            </tr>
                            <tr>
                                <td class="spoprat"><span><img class="mgr5" src="${basePath}\resources\images\level_1.gif" width="15" height="14" /><img class="mgr5" src="${basePath}\resources\images\level_1.gif" width="15" height="14" /></span></td>
                                <td class="spoprat"><span class="allmen size5">
                                    <input name="creditrule12" type="text" id="creditrule12" value="${creditRules.creditrule12}"/>
                                    </span><span>-</span><span class="allmen size5">
                                    <input name="creditrule13" type="text" id="creditrule13" value="${creditRules.creditrule13}"/>
                                    </span></td>
                            </tr>
                            <tr>
                                <td class="spoprat"><span><img class="mgr5" src="${basePath}\resources\images\level_1.gif" width="15" height="14" /><img class="mgr5" src="${basePath}\resources\images\level_1.gif" width="15" height="14" /><img class="mgr5" src="${basePath}\resources\images\level_1.gif" width="15" height="14" /></span></td>
                                <td class="spoprat"><span class="allmen size5">
                                    <input name="creditrule14" type="text" id="creditrule14" value="${creditRules.creditrule14}"/>
                                    </span><span>-</span><span class="allmen size5">
                                    <input name="creditrule15" type="text" id="creditrule15" value="${creditRules.creditrule15}"/>
                                    </span></td>
                            </tr>
                            <tr>
                                <td class="spoprat"><span><img class="mgr5" src="${basePath}\resources\images\level_1.gif" width="15" height="14" /><img class="mgr5" src="${basePath}\resources\images\level_1.gif" width="15" height="14" /><img class="mgr5" src="${basePath}\resources\images\level_1.gif" width="15" height="14" /><img class="mgr5" src="${basePath}\resources\images\level_1.gif" width="15" height="14" /></span></td>
                                <td class="spoprat"><span class="allmen size5">
                                    <input name="creditrule16" type="text" id="creditrule16" value="${creditRules.creditrule16}"/>
                                    </span><span>-</span><span class="allmen size5">
                                    <input name="creditrule17" type="text" id="creditrule17" value="${creditRules.creditrule17}"/>
                                    </span></td>
                            </tr>
                            <tr>
                                <td class="spoprat"><span><img class="mgr5" src="${basePath}\resources\images\level_1.gif" width="15" height="14" /><img class="mgr5" src="${basePath}\resources\images\level_1.gif" width="15" height="14" /><img class="mgr5" src="${basePath}\resources\images\level_1.gif" width="15" height="14" /><img class="mgr5" src="${basePath}\resources\images\level_1.gif" width="15" height="14" /><img class="mgr5" src="${basePath}\resources\images\level_1.gif" width="15" height="14" /></span></td>
                                <td class="spoprat"><span class="allmen size5">
                                    <input name="creditrule18" type="text" id="creditrule18" value="${creditRules.creditrule18}"/>
                                    </span><span>-</span><span class="allmen size5">
                                    <input name="creditrule19" type="text" id="creditrule19" value="${creditRules.creditrule19}"/>
                                    </span></td>
                            </tr>
                            <tr>
                                <td class="spoprat"><span><img class="mgr5" src="${basePath}\resources\images\level_2.gif" width="15" height="14" /></span></td>
                                <td class="spoprat"><span class="allmen size5">
                                    <input name="creditrule20" type="text" id="creditrule20" value="${creditRules.creditrule20}"/>
                                    </span><span>-</span><span class="allmen size5">
                                    <input name="creditrule21" type="text" id="creditrule21" value="${creditRules.creditrule21}"/>
                                    </span></td>
                            </tr>
                            <tr>
                                <td class="spoprat"><span><img class="mgr5" src="${basePath}\resources\images\level_2.gif" width="15" height="14" /><img class="mgr5" src="${basePath}\resources\images\level_2.gif" width="15" height="14" /></span></td>
                                <td class="spoprat"><span class="allmen size5">
                                    <input name="creditrule22" type="text" id="creditrule22" value="${creditRules.creditrule22}"/>
                                    </span><span>-</span><span class="allmen size5">
                                    <input name="creditrule23" type="text" id="creditrule23" value="${creditRules.creditrule23}"/>
                                    </span></td>
                            </tr>
                            <tr>
                                <td class="spoprat"><span><img class="mgr5" src="${basePath}\resources\images\level_2.gif" width="15" height="14" /><img class="mgr5" src="${basePath}\resources\images\level_2.gif" width="15" height="14" /><img class="mgr5" src="${basePath}\resources\images\level_2.gif" width="15" height="14" /></span></td>
                                <td class="spoprat"><span class="allmen size5">
                                    <input name="creditrule24" type="text" id="creditrule24" value="${creditRules.creditrule24}"/>
                                    </span><span>-</span><span class="allmen size5">
                                    <input name="creditrule25" type="text" id="creditrule25" value="${creditRules.creditrule25}"/>
                                    </span></td>
                            </tr>
                            <tr>
                                <td class="spoprat"><span><img class="mgr5" src="${basePath}\resources\images\level_2.gif" width="15" height="14" /><img class="mgr5" src="${basePath}\resources\images\level_2.gif" width="15" height="14" /><img class="mgr5" src="${basePath}\resources\images\level_2.gif" width="15" height="14" /><img class="mgr5" src="${basePath}\resources\images\level_2.gif" width="15" height="14" /></span></td>
                                <td class="spoprat"><span class="allmen size5">
                                    <input name="creditrule26" type="text" id="creditrule26" value="${creditRules.creditrule26}"/>
                                    </span><span>-</span><span class="allmen size5">
                                    <input name="creditrule27" type="text" id="creditrule27" value="${creditRules.creditrule27}"/>
                                    </span></td>
                            </tr>
                            <tr>
                                <td class="spoprat"><span><img class="mgr5" src="${basePath}\resources\images\level_2.gif" width="15" height="14" /><img class="mgr5" src="${basePath}\resources\images\level_2.gif" width="15" height="14" /><img class="mgr5" src="${basePath}\resources\images\level_2.gif" width="15" height="14" /><img class="mgr5" src="${basePath}\resources\images\level_2.gif" width="15" height="14" /><img class="mgr5" src="${basePath}\resources\images\level_2.gif" width="15" height="14" /></span></td>
                                <td class="spoprat"><span class="allmen size5">
                                    <input name="creditrule28" type="text" id="creditrule28" value="${creditRules.creditrule28}"/>
                                    </span><span>-</span><span class="allmen size5">
                                    <input name="creditrule29" type="text" id="creditrule29" value="${creditRules.creditrule29}"/>
                                    </span></td>
                            </tr>
                        </table>
                        <div class="form-group col-lg-3 col-sm-3" >
                            <a href="javascript:" class="btn btn-success" onclick="submitInfo()">提交</a>
                            <span class="alert alert-info" style="margin-left: 30px">修改店铺等级的信誉分值区间值!</span>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    </div>
    <script src="${basePath}/resources/common/plugins/jquery.1.12.4.min.js"></script>
    <script src="${basePath}/resources/common/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
    <script src="${basePath}/resources/common/plugins/bootstrap-switch/js/bootstrap-switch.min.js"></script>
    <script src="${basePath}/resources/common/plugins/jquery-confirm/jquery-confirm.min.js"></script>

    <script>
        function submitInfo() {
            $.ajax({
                type: 'post',
                data: $("#formId").serialize(),
                url: '${pageContext.request.contextPath}/store/credit/commitCredit',
                success: function(data) {
                    console.log("data>>>",data);
                    if(data.code==200){
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
                                        window.location.href = "${basePath}/store/credit/index";
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

        $("#applyStatus").bootstrapSwitch({
            onText:'开启',
            offText:'关闭',
            onColor : "success",
            offColor : "danger",
            size : "small",
            onSwitchChange : function(event, state) {
                //后台修改状态代码
                $.post('${basePath}/store/credit/changeSetNewStore?flag='+state,null,function(data){
                    if(data.code==200){
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
                                        window.location.href = "${basePath}/store/credit/index";
                                    }
                                }
                            }
                        });
                    }
                });
            }
        });
    </script>
</body>
</html>
