<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%--<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>--%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>

<html>
    <head>
        <title>Title</title>
    </head>
<body>
<div class="top" style="">
    <div class="top_page">
        <div class="pageright" id="site-nav">
            <ul class="quick-menu">
                <li class="mytaobao menu-item menupx">
                    <div class="menu"> <a class="menu-hd" href="${basePath}/buyer/index.htm" rel="nofollow">我的订单<b></b></a>
                        <div class="menu-bd">
                            <div class="menu-bd-panel">
                                <div>
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
                                    #if($!user.store)
                                    <a href="${basePath}/store_$!{user.store.id}.htm" rel="nofollow">我的店铺</a>
                                    #else
                                    <a href="${basePath}/seller/store_create_first.htm" rel="nofollow">商家入驻</a>
                                    #end
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
                <script>
                    var goods_count=$!cart.size();
                    var total_price=0;
                    #set($total_price=0)
                    #foreach($gc in $cart)
                    #if($!gc.goods.group_buy==2)
                    #set($total_price=$!{gc.goods.group_goods.gg_price}*$!{gc.count}+$total_price)
                    #else
                    #set($total_price=$!{gc.goods.store_price}*$!{gc.count}+$total_price)
                    #end
                    #end
                    function cart_remove(id,store_id){
                        jQuery.post('${basePath}/remove_goods_cart.htm',{"id":id,"store_id":store_id},function(data){
                            jQuery("div[class=table] tr[id="+id+"]").remove();
                            jQuery(".shopping[id="+id+"]").remove();
                            jQuery(".shopp_ingtop[id="+id+"]").remove();
                            jQuery("#cart_goods_count_top").html(data.count);
                            jQuery("#cart_goods_price_top").html(data.total_price);
                            jQuery("#top_total_price_"+store_id).html(data.total_price);
                            if(store_id!=""){
                                jQuery("#total_price_"+store_id).html(data.sc_total_price);
                            }
                            if( jQuery("form[id=cart_"+store_id+"]").find("tr[goods_list^=goods_info]").length==0){
                                jQuery("form[id=cart_"+store_id+"]").remove();
                            }
                            if(jQuery("tr[goods_list^=goods_info]").length==0){
                                jQuery(".car_nogoods").show();
                            }
                        },"json");
                    }
                    jQuery(document).ready(function(){
                        jQuery("#cart_goods_top_menu").mouseover(function(){
                            jQuery.ajax({type:'POST',url:'${basePath}/cart_menu_detail.htm',data:'',
                                beforeSend:function(){
                                    jQuery("#cart_goods_top_info").empty().html('<div class="menu-bd-panel"><div style="text-align:center;"><img src="${basePath}/resources/style/common/images/loader.gif" /></div></div>');
                                    jQuery("#cart_goods_top_info").show();
                                },
                                success:function(data){
                                    jQuery("#cart_goods_top_info").empty();
                                    jQuery("#cart_goods_top_info").html(data);
                                }
                            });
                        });
                        jQuery("#cart_menu").mouseleave(function(){
                            jQuery("#cart_goods_top_info").hide();
                        });
                    });
                </script>
                <li class="search menu-item menupx">
                    <div class="menu" id="cart_menu"><span class="menu-hd" id="cart_goods_top_menu"><s></s>购物车<span id="cart_goods_count_top" class="top_car">$!cart.size()</span>种商品<b></b></span>
                        <div class="menu-bd" id="cart_goods_top_info">
                            <div class="menu-bd-panel">
                                <div style="text-align:center;"><img src="${basePath}/resources/style/common/images/loader.gif" /></div>
                            </div>

                        </div>
                    </div>
                </li>
                <li class="menupx"><a href="${basePath}/buyer/message.htm">站内短信#if($!msgs.size()>0)(<span style="color:#FF3300;">$!{msgs.size()}</span>)#end</a></li>

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

                #if($!CommUtil.indexOf("$!user.userRole","ADMIN")>=0)
                <li class="menupx"><a href="${basePath}/admin/index.htm" target="_blank">管理后台</a></li>
                #end
                #set($navs=$!navTools.queryNav(-1,-1))
                #if($!navs.size()>0)
                <li class="menupx"><a href="${basePath}/articlelist_help.htm">帮助中心</a></li>
                #else
                <li class="menupx" style="background:none;"><a href="${basePath}/articlelist_help.htm">帮助中心</a></li>
                #end
                #if($!navs.size()>0)
                <li class="mytaobao menu-item menupx" style="background:none;">
                    <div class="menu"> <a class="menu-hd" href="${basePath}/buyer/index.htm" rel="nofollow">更多链接<b></b></a>
                        <div class="menu-bd" style="height:auto;">
                            <div class="menu-bd-panel">
                                <div>
                                    #foreach($nav in $navs)
                                    #set($map=$!navTools.genericURL("${basePath}","$!nav.id"))
                                    #set($url=$!map.get("url"))
                                    <a href="$!url"  #if($!new_win==1)target="_blank"#end  rel="nofollow">$!nav.title</a>
                                    #end
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
                #end
            </ul>
        </div>
        <div class="pageleft">
            #if($!user)
                <span>
                    ${user.userName}
                    <%--$!CommUtil.substring("$!{user.userName}",12)您好,欢迎来到$!CommUtil.substring("$!{config.websiteName}",30)！--%>
                </span>
                <a href="${basePath}/shopping_logout.htm" class="lightblue">
                    [退出]
                </a>
            #else
                <span>亲，欢迎来到$!{config.websiteName}！</span>
                <span class="pxlr">
                    <a href="${basePath}/user/login.htm" class="lightblue">登录</a>
                </span>
                <span class="pxlr">或</span>
                <span class="pxlr">
                    <a href="${basePath}/register.htm" class="lightblue">注册</a>
                </span>
            #end
        </div>
    </div>
</div>
</body>
</html>
