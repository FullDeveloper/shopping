<%--
  Created by IntelliJ IDEA.
  User: 周润斌
  Date: 2018/1/26 0026
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<div class="page_width">
    <div class="main_top">
        <div class="head">
            <div class="logo">
                <c:choose>
                    <c:when test="${config.accessoryId != null}">
                        <a href="${basePath}/index.htm">
                            <img src="${basePath}/${websiteLogo.path}/${websiteLogo.name}" border="0" />
                        </a>
                    </c:when>
                    <c:otherwise>
                        <a href="${basePath}/index.htm">
                            <img src="${basePath}/resources/style/system/front/default/images/logo.png"  width="200" border="0" />
                        </a>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="shop_top_search">
                <div class="filter_z">
                    <div class="top_searleft"> </div>
                    <div class="top_nofilter">
                        <div class="top_sear_kf">
                            <a href="$!webPath/store_$!{store.id}.htm">
                                ${store.storeName}
                            </a>
                            <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=$!store.store_qq&Site=$!store.store_qq&Menu=yes">
                                <img alt="点击这里给我发消息" src="http://wpa.qq.com/pa?p=2:${store.storeQq}:51" />
                            </a>
                        </div>
                        #set($credit=$!storeViewTools.generic_store_credit("$!store.id"))
                        #set($img="$!imageWebServer/resources/style/common/images/level_0.gif")
                        #if($credit<10 && $credit>0)
                        #set($credit=${credit} / 2)
                        #set($credit=$credit+1)
                        #end
                        #if($credit>=20)
                        #set($img="$!imageWebServer/resources/style/common/images/level_2.gif")
                        #set($credit=($credit - 20)/2)
                        #set($credit=$credit+1)
                        #end
                        #if($credit>=10)
                        #set($img="$!imageWebServer/resources/style/common/images/level_1.gif")
                        #set($credit=($credit - 10)/2)
                        #set($credit=$credit+1)
                        #end
                        #if($credit>5)#set($credit=5)#end
                        <div class="top_sear_star"><a href="javascript:void(0);" class="top_sc" #if(!$!user)dialog_uri="$!webPath/user_dialog_login.htm" dialog_title="会员登录" dialog_width="450" dialog_height="100" dialog_id="user_login"#end>点击收藏</a><span>#if($!credit==0) <img src="$!imageWebServer/resources/style/common/images/level_-1.gif"/> #else #foreach($count in [1..$!credit])<img style="margin-left:1px;" src="$!img" />#end #end</span></div>
                    </div>
                </div>
                <form method="post" target="_blank" id="store_top_search_form">
                    <input name="store_id" type="hidden" value="$!{store.id}"/>
                    <div class="top_search_right">
                        <div class="top_search_bg"></div>
                        <div class="top_shop_seacher"> <span class="sear_shop">
              <input name="keyword" type="text" id="keyword"/>
              </span><span class="all_sear_btn">
              <input name="" type="button" value="搜全站" search_area="site" style="cursor:pointer;"/>
              </span><span class="shop_sear_btn">
              <input name="" type="button" value="搜本店" search_area="store" style="cursor:pointer;"/>
              </span></div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


