<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/15 0015
  Time: 下午 6:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
    <script src="${basePath}/resources/js/css3-mediaqueries.js"></script>
    <script src="${basePath}/resources/common/plugins/jquery.1.12.4.min.js"></script>
</head>
<body>
    <div id="header_form" >
        <script src="${basePath}/resources/js/jquery.cookie.js"></script>
        <div id="head_h" class="head_width">
            <div class="head clearFix">
                <div class="logo">
                      <a href="${basePath}/index.htm">
                          <img src="${basePath}/resources/style/system/front/default/images/logo.png" border="0" />
                      </a>
                </div>
                <div class="searchForm">
                    <form action="${basePath}/search.htm" method="post" target="_blank" id="searchForm">
                        <input name="type" type="hidden" id="type" value="$!type" />
                        <div class="toph_bigsearch">
                            <div class="toph_sear">
                                <ul class="toph_bgsear">
                                    <li class="this" type="goods"><a href="javascript:void(0);">宝贝<s></s></a></li>
                                    <li style="display:none" type="store"><a href="javascript:void(0);">店铺</a></li>
                                </ul>
                                <input name="keyword" type="text" id="keyword" placeholder="搜索其实真的很简单！" x-webkit-speech lang="zh-CN" onwebkitspeechchange="jQuery('#searchForm').submit()" class="toph_sear_txt"/>
                                <input name="input" type="button" value="搜索" style="cursor:pointer;" onclick="search_form();" class="toph_sear_btn" />
                            </div>
                            <div class="keyword"> #foreach($info in $CommUtil.splitByChar("$!config.hotSearch",",")) <a href="javascript:void(0);" onclick="search_form('$info','goods');">$!info</a> #end </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <script>
        jQuery(document).ready(function(){
            jQuery(".toph_bgsear li").mouseover(function(){
                jQuery(".toph_bgsear>li").show();
            }).mouseleave(function(){
                jQuery(".toph_bgsear>li").last().hide();
            }).click(function(){
                var index=jQuery(this).index();
                if(index==1){
                    var f_text=jQuery(".toph_bgsear li").find("a").first().text();
                    jQuery(".toph_bgsear li").find("a").first().html(jQuery(this).find("a").text()+"<s></s>");
                    jQuery(".toph_bgsear li").find("a").last().text(f_text);
                    jQuery("#type").val(jQuery(this).attr("type"));
                    jQuery(".toph_bgsear>li").last().hide();
                }
            });

            jQuery(".two_code_a").click(function(){
                jQuery(this).parent().remove();
            });

        });
        function search_form(){
            var keyword=arguments[0];
            var type=arguments[1];
            if(keyword!=""&&keyword!=undefined){
                jQuery("#keyword").val(keyword);
            }
            if(type!=""&&type!=undefined){
                jQuery("#type").val(type);
            }
            jQuery("#searchForm").submit();
            jQuery("#keyword").val("");
        }
    </script>

</body>
</html>
