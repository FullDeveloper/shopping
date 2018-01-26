<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%--<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>--%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<div class="top">
    <div class="top_page">
        <div class="pageright" id="site-nav">
            <ul class="quick-menu">
                <li class="mytaobao menu-item menupx">
                    <div class="menu"> <a class="menu-hd" href="${basePath}/buyer/index.htm" rel="nofollow">我的订单<b></b></a>
                        <div class="menu-bd">
                            <div class="menu-bd-panel">
                                <div>
                                    <!-- <a href="${basePath}/buyer/order.htm" rel="nofollow">已买到的宝贝</a>
                                    <a href="${basePath}/buyer/index.htm?type=4"  rel="nofollow">店铺动态</a>
                                    <a href="${basePath}/buyer/index.htm?type=2"  rel="nofollow">好友动态</a> -->
                                    <a href="${basePath}/buyer/order.htm?order_status=order_submit" rel="nofollow">待支付</a>
                                    <a href="${basePath}/buyer/order.htm?order_status=order_shipping" rel="nofollow">待收货</a>
                                    <a href="${basePath}/buyer/order.htm?order_status=order_receive" rel="nofollow">待评价</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="mytaobao menu-item menupx">
                    <div class="menu"> <a class="menu-hd" href="${basePath}/seller/index.htm" rel="nofollow">商家支持<b></b></a>
                        <div class="menu-bd">
                            <div class="menu-bd-panel">
                                <div>
                                    <a href="${basePath}/seller/index.htm" rel="nofollow">商家中心</a>
                                    <a href="${basePath}/seller/order.htm"  rel="nofollow">商家订单</a>
                                    <a href="${basePath}/seller/goods.htm" rel="nofollow">商家商品</a>
                                    <c:choose>
                                        <c:when test="${!user.store}">
                                            <a href="${basePath}/store_$!{user.store.id}.htm" rel="nofollow">我的店铺</a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="${basePath}/seller/store_create_first.htm" rel="nofollow">商家入驻</a>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="search menu-item menupx">
                    <div class="menu" id="cart_menu">
                        <span class="menu-hd" id="cart_goods_top_menu"><s></s>购物车
                            <span id="cart_goods_count_top" class="top_car">0</span>
                            种商品<b></b>
                        </span>
                        <div class="menu-bd" id="cart_goods_top_info">
                            <div class="menu-bd-panel">
                                <div style="text-align:center;"><img src="${basePath}/resources/style/common/images/loader.gif" /></div>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="menupx">
                    <a href="${basePath}/buyer/message.htm">
                        站内短信<span style="color:#FF3300;">5</span>
                    </a>
                </li>
                <li class="mytaobao menu-item menupx">
                    <div class="menu"> <a class="menu-hd" href="${basePath}/buyer/favorite_goods.htm" rel="nofollow">收藏夹<b></b></a>
                        <div class="menu-bd">
                            <div class="menu-bd-panel">
                                <div>
                                    <a href="${basePath}/buyer/favorite_goods.htm" rel="nofollow">收藏商品</a>
                                    <a href="${basePath}/buyer/favorite_store.htm"  rel="nofollow">收藏店铺</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="menupx"><a href="${basePath}/admin/index.htm" target="_blank">管理后台</a></li>
                <li class="menupx"><a href="${basePath}/articlelist_help.htm">帮助中心</a></li>
                <li class="menupx" style="background:none;">
                    <a href="${basePath}/articlelist_help.htm">帮助中心</a>
                </li>
                <li class="mytaobao menu-item menupx" style="background:none;">
                    <div class="menu"> <a class="menu-hd" href="${basePath}/buyer/index.htm" rel="nofollow">更多链接<b></b></a>
                        <div class="menu-bd" style="height:auto;">
                            <div class="menu-bd-panel">
                                <div>
                                    <a href="$!url"  #if($!new_win==1)target="_blank"#end  rel="nofollow">测试</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
        <div class="pageleft">
            <span class="pxlr">
                <a href="${basePath}/user/login.htm" class="lightblue">登录</a>
            </span>
            <span class="pxlr">或</span>
            <span class="pxlr">
                <a href="${basePath}/register.htm" class="lightblue">注册</a>
            </span>
        </div>
    </div>
</div>