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
    <link href="${basePath}/resources/common/css/templates.css" rel="stylesheet"/>
    <link href="${basePath}/resources/common/plugins/bootstrap-fileinput-master/css/fileinput.min.css" rel="stylesheet"/>
    <link href="${basePath}/resources/common/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet"/>
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
        <input type="hidden" id="id" name="id" class="form-control" value="${brand.id}" />
        <input type="hidden" name="accessoryId" class="form-control" value="${brand.accessoryId}" />
        <div class="forms">
        <div class="form-grids widget-shadow" data-example-id="basic-forms">
            <div class="form-title">
                <h4>品牌管理</h4>
            </div>
            <div class="form-body column">
                    <div class="form-group col-lg-3 col-sm-3" >
                        <label for="name">品牌名称</label>
                        <input type="text" class="form-control" id="name" name="name" value="${brand.brandName}" placeholder="品牌名称" />
                    </div>
                    <div class="form-group col-lg-3 col-sm-3" >
                        <label for="firstWord">首字母</label>
                        <input type="text" class="form-control" id="firstWord" value="${brand.firstWord}" name="firstWord" placeholder="首字母" />
                    </div>
                    <div class="form-group col-lg-3 col-sm-3" >
                        <label for="className">类别</label>
                        <input type="text" class="form-control" id="className" value="${brand.categoryName}" name="className" placeholder="分类名称" />
                    </div>
                    <div class="form-group col-lg-3 col-sm-3" >
                        <label for="name">品牌图片</label>
                        <div class="file-loading">
                            <input id="brandImage" type="file" name="accessoryImage" />
                        </div>
                    </div>
                    <div class="form-group col-lg-3 col-sm-3 column">
                        <label for="recommend">是否推荐</label>
                        <input class="push" id="recommend" <c:if test="${brand.recommend == '1'}">checked</c:if> type="checkbox"/>
                        <input id="recommend_value" name="recommend" type="hidden" value="${brand.recommend}"/>
                    </div>
                    <div class="form-group col-lg-3 col-sm-3" >
                        <label for="sort">排序</label>
                        <input type="text" class="form-control" id="sort" name="sort" value="${brand.sort}" placeholder="排序">
                    </div>
                    <div class="form-group col-lg-3 col-sm-3" >
                        <a href="javascript:" class="btn btn-success" onclick="saveForm()">保存</a>
                    </div>
                </div>

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
    function saveForm(){
        var form = new FormData(document.getElementById("saveForm"));
        $.ajax({
            url:"${pageContext.request.contextPath}/goods/brand/save",
            type:"post",
            data:form,
            processData:false,
            contentType:false,
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
                                    window.location.href = "${basePath}/goods/brand/index";
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
        //初始化fileinput控件
        $("#brandImage").fileinput({
            language: 'zh', //设置语言
            uploadUrl:"http://127.0.0.1/testDemo/fileupload/upload.do", //上传的地址
            allowedFileExtensions: ['jpg', 'gif', 'png'],//接收的文件后缀
            //uploadExtraData:{"id": 1, "fileName":'123.mp3'},
            uploadAsync: false, //默认异步上传
            showUpload:false, //是否显示上传按钮
            showRemove :true, //显示移除按钮
            showBrowse:true, //是否显示浏览按钮
            showCancel: true, //是否显示取消按钮
            autoReplace: true, //是否自动替换当前图片，设置为true时，再次选择文件， 会将当前的文件替换掉。
            showPreview :true, //是否显示预览
            showCaption:true,//是否显示标题
            browseClass:"btn btn-primary", //按钮样式
            dropZoneEnabled: false,//是否显示拖拽区域
            initialPreviewAsData: true,
            initialPreview: [
                "${basePath}/${brand.path}/${brand.logoName}",
            ],
            //minImageWidth: 50, //图片的最小宽度
            //minImageHeight: 50,//图片的最小高度
            //maxImageWidth: 1000,//图片的最大宽度
            //maxImageHeight: 1000,//图片的最大高度
            //maxFileSize:0,//单位为kb，如果为0表示不限制文件大小
            //minFileCount: 0,
            maxFileCount:1, //表示允许同时上传的最大文件个数
            enctype:'multipart/form-data',
            validateInitialCount:true,
            previewFileIcon: "<iclass='glyphicon glyphicon-king'></i>",
            msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
        }).on("fileuploaded", function (event, data, previewId, index){

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
