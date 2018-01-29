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
                <div class="top_search_left">
                    <div class="filter_z">
                        <div class="top_searleft"> </div>
                        <div class="top_nofilter">
                            <div class="top_sear_kf">
                                <a href="$!webPath/store_$!{store.id}.htm">
                                    ${store.storeName}
                                </a>
                                <a style="height: 25px;" target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=$!store.store_qq&Site=$!store.store_qq&Menu=yes">
                                    <img alt="点击这里给我发消息" src="http://wpa.qq.com/pa?p=2:${store.storeQq}:51" />
                                </a>
                            </div>
                            <c:set var="levelImg" value="${basePath}/resources/style/common/images/level_0.gif"/>
                            <c:set var="credit" value="${store.storeCredit}"/>
                            <c:choose>
                                <c:when test="${credit < 10 && credit > 0}">
                                    <c:set var="credit" value="${credit/2}"/>
                                    <c:set var="credit" value="${credit+1}"/>
                                </c:when>
                                <c:when test="${credit >= 10 && credit <= 20}">
                                    <c:set var="credit" value="${(credit-10)/2}"/>
                                    <c:set var="credit" value="${credit+1}"/>
                                    <c:set var="levelImg" value="${basePath}/resources/style/common/images/level_1.gif"/>
                                </c:when>
                                <c:when test="${credit > 20}">
                                    <c:set var="credit" value="${(credit-20)/2}"/>
                                    <c:set var="credit" value="${credit+1}"/>
                                    <c:set var="levelImg" value="${basePath}/resources/style/common/images/level_2.gif"/>
                                </c:when>
                            </c:choose>
                            <c:if test="${credit > 5}">
                                <c:set var="credit" value="5"/>
                            </c:if>
                            <div class="top_sear_star">
                                <a href="javascript:void(0);" class="top_sc"
                                   <c:if test="${user != null}">
                                       dialog_uri="${basePath}/user_dialog_login.htm"
                                       dialog_title="会员登录"
                                       dialog_width="450"
                                       dialog_height="100"
                                       dialog_id="user_login"
                                   </c:if>>
                                    点击收藏
                                </a>
                                <style>
                                    .levelImageView img{
                                        float: left;
                                    }
                                </style>
                                <span class="levelImageView">
                                    <c:choose>
                                        <c:when test="${credit == 0}">
                                            <img src="${basePath}/resources/style/common/images/level_-1.gif"/>
                                        </c:when>
                                        <c:otherwise>
                                            <c:forEach  begin="${1}" end="${credit}"   >
                                                <img style="margin-left:1px;" src="${levelImg}" />
                                            </c:forEach>
                                        </c:otherwise>
                                    </c:choose>
                                </span>
                            </div>
                        </div>
                    </div>
                    <b class="top_b" ></b><b class="top_b2" style="display:none"></b>
                    <div class="top_sear_bom" style="display:none;" >
                        <dl class="top_dl">
                            <dt><b>店铺动态评分</b><i>与同行业相比</i></dt>
                            <dd>
                                <ul class="top_dl_ul">
                                    <li><i>描述相符：</i><b>$!{store.point.description_evaluate}</b><em class="$!description_css"><strong>$!description_type</strong>$!description_result</em></li>
                                    <li><i>服务态度：</i><b>$!{store.point.service_evaluate}</b><em class="$!service_css"><strong>$!service_type</strong>$!service_result</em></li>
                                    <li><i>发货速度：</i><b>$!{store.point.ship_evaluate}</b><em class="$!ship_css"><strong>$!ship_type</strong>$!ship_result</em></li>
                                </ul>
                            <dd>
                        </dl>
                        <dl class="top_dl">
                            <dt>店铺认证</dt>
                            <dd>
                                <span>
                                    <img src="${basePath}/resources/style/common/images/card_approve_${store.cardApprove}.gif" />
                                </span>
                                <span>
                                    <img src="${basePath}/resources/style/common/images/realstore_approve_${store.realstoreApprove}.gif" />
                                </span>
                            <dd>
                        </dl>
                        <dl  class="top_dl">
                            <dt>店铺信息</dt>
                            #set($store_evaluate1="$!CommUtil.mul($!{store.point.store_evaluate1},100)%")
                            #set($goods_count=0)
                            #foreach($!goods_info in $!store.goods_list)
                            #if($!goods_info.goods_status==0)
                            #set($goods_count=$goods_count+1)
                            #end
                            #end
                            <dd>
                                <span class="top_dl_width">商品数量：$!{goods_count}件</span>
                                <span class="top_dl_width">好评率：$!store_evaluate1</span>
                                <span class="top_dl_width">创店时间：<fmt:formatDate value="${store.addTime}" type="date" pattern="yyyy-MM-dd"/></span>
                                <span class="top_dl_width">收藏人气：${store.favoriteCount}</span>
                            </dd>
                        </dl>
                    </div>
                </div>
                <form method="post" target="_blank" id="store_top_search_form">
                    <input name="store_id" type="hidden" value="${store.id}"/>
                    <div class="top_search_right">
                        <div class="top_search_bg"></div>
                        <div class="top_shop_seacher">
                            <span class="sear_shop">
                                <input name="keyword" type="text" id="keyword"/>
                            </span>
                            <span class="all_sear_btn">
                                <input name="" type="button" value="搜全站" search_area="site" style="cursor:pointer;"/>
                            </span>
                            <span class="shop_sear_btn">
                                <input name="" type="button" value="搜本店" search_area="store" style="cursor:pointer;"/>
                            </span>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script>

    <c:if test="${user != null}">
        $(".top_sc").click(function(){
            <c:choose>
                <c:when test="${user.storeId == store.id}">
                  alert("不能收藏自己的店铺");
                </c:when>
                <c:otherwise>
                    jQuery.post("$!webPath/add_store_favorite.htm",{"id":"$!store.id"},function(data){
                        if(data==0){
                            alert("店铺收藏成功！");
                        }
                        if(data==1){
                            alert("该店铺已经被收藏！");
                        }
                    },"text");
                </c:otherwise>
            </c:choose>
            });
    </c:if>

    jQuery(".top_shop_seacher input[type=button]").click(function(){
        var search_area=jQuery(this).attr("search_area");
        if(search_area=="site"){
            jQuery("#store_top_search_form").attr("action","$!webPath/search.htm");
        }
        if(search_area=="store"){
            jQuery("#store_top_search_form").attr("action","$!webPath/store_goods_search.htm");
        }
        jQuery("#store_top_search_form").submit();
    });
    jQuery(".top_nofilter").mouseover(function(){
        jQuery(".top_b").hide();
        jQuery(".top_b2").show();
        jQuery(".top_sear_bom").fadeIn("normal");
    });
    jQuery(".top_search_left").css("cursor","pointer").mouseleave(function(){
        jQuery(".top_b").show();
        jQuery(".top_b2").hide();
        jQuery(".top_sear_bom").fadeOut("normal");
    });
</script>


