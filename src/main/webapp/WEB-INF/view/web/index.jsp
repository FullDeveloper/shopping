<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%--<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>--%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>$!config.title - Powered by shopping</title>
    <meta name="keywords" content="$!config.keywords" >
    <meta name="description" content="$!config.description" >
    <meta name="generator" content="shopping 2.0">
    <meta name="author" content="www.shopping.com">
    <meta name="copyright" content="shopping Inc. All Rights Reserved">
    <meta content="IE=edge" http-equiv="X-UA-Compatible">

    <link href="${basePath}/resources/style/system/front/default/css/public.css" type="text/css" rel="stylesheet" />
    <link href="${basePath}/resources/style/system/front/default/css/public_auto.css" type="text/css" rel="stylesheet" />
    <link href="${basePath}/resources/style/system/front/default/css/index.css" type="text/css" rel="stylesheet" />

    <title>Title</title>
</head>
<body>
<!--低版本提示-->
<!--[if IE 6]>
<div class="top_tipe">
    <div class="top_tipe_center">
        <em><img src="${basePath}/resources/style/system/front/default/images/ie6_warning.png" style="height:16px; width:16px;"/></em><b>温馨提示：您当前使用的浏览器版本过低，兼容性和安全性较差，建议您升级：</b><em><img src="${basePath}/resources/style/system/front/default/images/ie_b.png"/></em><b><a href="http://windows.microsoft.com/zh-cn/internet-explorer/download-ie?tp=1.0.0.0.0.KdMt0Yu">IE8浏览器</a>或</b><em><img src="${basePath}/resources/style/system/front/default/images/google_b.png" /></em><b><a href="http://www.google.cn/intl/zh-CN/chrome/">谷歌浏览器</a></b>
        <span><a href="javascript:void(0);" onclick="javascript:jQuery('.top_tipe').hide();">x</a></span>
    </div>
</div>
<![endif]-->
<jsp:include page="top.jsp" flush="true"/><!--动态包含-->
<jsp:include page="head.jsp" flush="true"/><!--动态包含-->
<%--$!httpInclude.include("/top.htm")--%>
<%--$!httpInclude.include("/head.htm")--%>
<%--$!httpInclude.include("/nav.htm")--%>

<script src="${basePath}/advert_invoke.htm?id=1"></script>

<div class="main">

    <div class="index">

        <div class="top_index">

            <div class="top_mid">
                <div class="top_mid">
                    <div class="banner_nothing"></div>
                </div>
            </div>

            <div class="top_mid_right">
                <style>
                    .phone_txt.error{width: 120px;
                        height: 20px;
                        line-height: 20px;
                        border: 1px solid #f00;}
                </style>

                <script>
                    jQuery(function(){

                        jQuery(".top_mid_nav div").css("cursor","pointer").mouseover(function(){
                            var target_tab_id=jQuery(this).attr("target_tab_id");
                            jQuery(".top_mid_nav div").removeClass("this");
                            jQuery(this).addClass("this");
                            jQuery("#news_tab").hide();
                            jQuery("#group_tab").hide();
                            jQuery("#"+target_tab_id).show();
                        });
                        //
                        jQuery(".group_tab").slide({mainCell:".top_regiment ul",autoPlay:true,interTime:3000,prevCell:".top_mid_regiment_img_left",nextCell:".top_mid_regiment_img_right"});
                        jQuery(".goods_tab").slide({mainCell:".top_regiment ul",autoPlay:true,interTime:3000,prevCell:".top_mid_regiment_img_left",nextCell:".top_mid_regiment_img_right"});
                        //
                        jQuery(".top_regiment").mouseenter(function(){
                            jQuery(".top_mid_regiment_img_left").show();
                            jQuery(".top_mid_regiment_img_right").show();
                        }).mouseleave(function(){
                            jQuery(".top_mid_regiment_img_left").hide();
                            jQuery(".top_mid_regiment_img_right").hide();
                        });
                    })
                </script>

                <!-- 右上角轮播推荐商品 -->
                <div class="goods_tab">
                    <div style="" id="" class="top_regiment">
                        <ul class="top_mid_regiment_t">
                            <%--<c:forEach items="${store_reommend_goods}" var="${obj}">
                                <c:if test="${obj.goods_main_photo}"></c:if>
                            </c:forEach>--%>
                            #foreach($obj in $store_reommend_goods)
                            #if($!obj.goods_main_photo)
                            #set($img="$!imageWebServer/$!{obj.goods_main_photo.path}/$!{obj.goods_main_photo.name}_middle.$!{obj.goods_main_photo.ext}")
                            #else
                            #set($img="$!imageWebServer/$!{config.goodsImage.path}/$!{config.goodsImage.name}")
                            #end
                            #set($goods_url="${basePath}/goods_$!{obj.id}.htm")
                            #if($!config.second_domain_open)
                            #set($goods_url="http://$!{obj.goods_store.store_second_domain}.$!{domainPath}/goods_$!{obj.id}.htm")
                            #end

                            <li style="display: none;">
                                <span class="top_mid_regiment_img_t"><a href="$!goods_url" target="_blank"><img src="$!imageWebServer/resources/style/common/images/loader.gif" original="$!img" onerror="this.src='$!imageWebServer/$!{config.goodsImage.path}/$!{config.goodsImage.name}';" width='28' height='28'></a></span>
                                <span class="top_mid_regiment_name_t">$!CommUtil.substring("$!obj.goods_name",18)</span>
                                <p class="top_mid_regiment_img_bottom_t">
                                    <span class="top_mid_regiment_img_bottom_left_t"><strong><i>¥</i>$!{obj.goods_current_price}</strong></span>
                                    <span class="top_mid_regiment_img_bottom_right_t"><a href="$!goods_url" target="_blank">立即购买</a></span>
                                </p>
                            </li>
                            #end
                        </ul>
                    </div>
                </div>

                <div class="top_mid_phone">

                    <div class="top_mid_nav">
                        <div target_tab_id="news_tab" class="top_mid_nav_phone this" style="cursor: pointer;">公告</div>
                        <div target_tab_id="group_tab" class="top_mid_nav_phone" style="cursor: pointer;">团购</div>
                    </div>

                    <div id="news_tab" class="top_mr_news">
                        <ul style=" display: block " u_id="1" class="top_mr_box">

                            #foreach($article in $articles)
                            #if($!article.url!="")
                            #set($url="$!article.url")
                            #else
                            #set($url="${basePath}/article_$!{article.id}.htm")
                            #end
                            <li><b><a href="$!url" target="_blank">$!CommUtil.formatShortDate($!article.addTime)</a></b><a href="$!url" target="_blank">$!CommUtil.substring("$!article.title",19)</a></li>
                            #end

                        </ul>
                    </div>

                    <div class="group_tab">
                        <div style="display:none;" id="group_tab" class="top_regiment top_tg">
                            <ul class="top_mid_regiment">
                                #foreach($group in $ggs)
                                <li style="display: none;">
                                    <span class="top_mid_regiment_img"><a href="${basePath}/group_view_$!{group.id}.htm" target="_blank"><img src="$!imageWebServer/$!group.gg_img.path/$!group.gg_img.name" /></a></span>
                                    <p class="top_mid_regiment_img_bottom">
                                        <span class="top_mid_regiment_img_bottom_left">团购价：<strong>¥$!{group.gg_goods.goods_price}</strong></span>
                                        <span class="top_mid_regiment_img_bottom_right"><a href="${basePath}/group_view_$!{group.id}.htm" target="_blank"><img src="${basePath}/resources/style/system/front/default/images/ct.png"></a></span>
                                    </p>
                                </li>
                                #end
                            </ul>
                            <div style="display: none;" class="top_mid_regiment_img_left"><a href="javascript:void(0);"></a></div>
                            <div style="display: none;" class="top_mid_regiment_img_right"><a href="javascript:void(0);"></a></div>
                        </div>
                    </div>

                </div>
                <!-- top_mid_phone end -->

            </div>
            <!-- top_mid_right end -->

        </div>
        <!-- top_index end -->


        <!-- 中间广告 -->
        <!-- <script src="${basePath}/advert_invoke.htm?id=4"></script> -->


        <!-- tab页商品 -->
        <div class="index_center_box">

            <div class="index_sale">
                <div id="index_sale_tab" class="index_sale_tab">
                    <!-- <a onclick="change_case_goods();" id="sale_change" mark="2" class="sale_change" href="javascript:void(0);">换一组</a> -->
                    <ul>
                        <li goods_random="1" id="goodscase2" class="this">疯狂抢购<s></s></li>
                        <li goods_random="1" id="goodscase3" class="">猜您喜欢<s></s></li>
                        <li goods_random="1" id="goodscase4" class="">新品上架<s></s></li>
                        <li goods_random="1" id="goodscase5" class="">满送商品<s></s></li>
                        <li goods_random="1" id="goodscase6" class="">人气商品<s></s></li>
                    </ul>
                </div>

                <!-- 疯狂抢购 -->
                <div id="index_sale_box_2" class="index_sale_box" style="display: block;">
                    <div id="index_sale_con_2" class="index_sale_con">
                        #foreach($!fengKuang in $fengKuangs)
                        #if($!fengKuang.goods_main_photo)
                        #set($img="$!imageWebServer/$!{fengKuang.goods_main_photo.path}/$!{fengKuang.goods_main_photo.name}_small.$!{fengKuang.goods_main_photo.ext}")
                        #else
                        #set($img="$!imageWebServer/$!{config.goodsImage.path}/$!{config.goodsImage.name}")
                        #end
                        #set($goods_url="${basePath}/goods_$!{fengKuang.id}.htm")
                        #if($!config.second_domain_open)
                        #set($goods_url="http://$!{fengKuang.goods_store.store_second_domain}.$!{domainPath}/goods_$!{fengKuang.id}.htm")
                        #end
                        <ul class="index_sale_two">
                            <li class="sale_two_img">
                                <a target="_blank" href="$!goods_url">
		          	<span class="img_cspan">
		              <p>
		              <img width="28" height="28" src="$!imageWebServer/resources/style/common/images/loader.gif" onerror="this.src='${basePath}/resources/style/common/images/good.jpg';" original="$!img" style="display: inline;">
		              </p>
		            </span>
                                </a>
                            </li>
                            <li class="sale_two_name"><a target="_blank" href="$!goods_url">$!CommUtil.substring("$!fengKuang.goods_name",20)</a></li>
                            <li class="sale_two_price">售价：<strong>¥$!{fengKuang.goods_current_price}</strong></li>
                        </ul>
                        #end
                    </div>
                </div>

                <!-- 猜您喜欢 -->
                <div id="index_sale_box_3" style="display: none;" class="index_sale_box">

                    <div id="index_sale_con_3" class="index_sale_con">
                        #foreach($!niCai in $cais)
                        #if($!niCai.goods_main_photo)
                        #set($img="$!imageWebServer/$!{niCai.goods_main_photo.path}/$!{niCai.goods_main_photo.name}_small.$!{niCai.goods_main_photo.ext}")
                        #else
                        #set($img="$!imageWebServer/$!{config.goodsImage.path}/$!{config.goodsImage.name}")
                        #end
                        #set($goods_url="${basePath}/goods_$!{niCai.id}.htm")
                        #if($!config.second_domain_open)
                        #set($goods_url="http://$!{niCai.goods_store.store_second_domain}.$!{domainPath}/goods_$!{niCai.id}.htm")
                        #end
                        <ul class="index_sale_two">
                            <li class="sale_two_img">
                                <a target="_blank" href="$!goods_url">
		            <span class="img_cspan">
		              <p>
		              <img width="150" height="150" src="$!imageWebServer/resources/style/common/images/loader.gif" onerror="this.src='${basePath}/resources/style/common/images/good.jpg';" original="$!img" style="display: inline;">
		              </p>
		              </span>
                                </a>
                            </li>
                            <li class="sale_two_name"><a target="_blank" href="$!goods_url">$!CommUtil.substring("$!niCai.goods_name",20)</a></li>
                            <li class="sale_two_price">售价：<strong>¥$!{niCai.goods_current_price}</strong></li>
                        </ul>
                        #end
                    </div>

                </div>

                <!-- 新品上架 -->
                <div id="index_sale_box_4" style="display: none;" class="index_sale_box">
                    <div id="index_sale_con_4" class="index_sale_con">
                        #foreach($!xinShang in $xinShangs)
                        #if($!xinShang.goods_main_photo)
                        #set($img="$!imageWebServer/$!{xinShang.goods_main_photo.path}/$!{xinShang.goods_main_photo.name}_small.$!{xinShang.goods_main_photo.ext}")
                        #else
                        #set($img="$!imageWebServer/$!{config.goodsImage.path}/$!{config.goodsImage.name}")
                        #end
                        #set($goods_url="${basePath}/goods_$!{xinShang.id}.htm")
                        #if($!config.second_domain_open)
                        #set($goods_url="http://$!{xinShang.goods_store.store_second_domain}.$!{domainPath}/goods_$!{xinShang.id}.htm")
                        #end
                        <ul class="index_sale_two">
                            <li class="sale_two_img">
                                <a target="_blank" href="$!goods_url">
		          	<span class="img_cspan">
		              <p>
		              <img width="150" height="150" src="$!imageWebServer/resources/style/common/images/loader.gif" onerror="this.src='${basePath}/resources/style/common/images/good.jpg';" original="$!img" style="display: inline;">
		              </p>
		            </span>
                                </a>
                            </li>
                            <li class="sale_two_name"><a target="_blank" href="$!goods_url">$!CommUtil.substring("$!xinShang.goods_name",20)</a></li>
                            <li class="sale_two_price">售价：<strong>¥$!{xinShang.goods_current_price}</strong></li>
                        </ul>
                        #end
                    </div>
                </div>

                <!-- 满送商品 -->
                <div id="index_sale_box_5" style="display: none;" class="index_sale_box">
                    <div id="index_sale_con_5" class="index_sale_con">
                        #foreach($obj in $dgs)
                        #set($goods_url="${basePath}/goods_$!{obj.d_goods.id}.htm")
                        #if($!config.second_domain_open)
                        #set($goods_url="http://$!{obj.d_goods.goods_store.store_second_domain}.$!{domainPath}/goods_$!{obj.d_goods.id}.htm")
                        #end

                        #if($!obj.d_goods.goods_main_photo)
                        #set($img="$!imageWebServer/$!{obj.d_goods.goods_main_photo.path}/$!{obj.d_goods.goods_main_photo.name}_small.$!{obj.d_goods.goods_main_photo.ext}")
                        #else
                        #set($img="$!imageWebServer/$!{config.goodsImage.path}/$!{config.goodsImage.name}")
                        #end
                        <ul class="index_sale_two">
                            <li class="sale_two_img">
                                <a target="_blank" href="$!goods_url">
		          	<span class="img_cspan">
		              <p>
		              <img width="150" height="150" src="$!imageWebServer/resources/style/common/images/loader.gif" onerror="this.src='${basePath}/resources/style/common/images/good.jpg';" original="$!img" style="display:inline;">
		              </p>
		            </span>
                                </a>
                            </li>
                            <li class="sale_two_name"><a target="_blank" href="$!goods_url">$!CommUtil.substring("$!obj.d_goods.goods_name",20)</a></li>
                            <li class="sale_two_price">售价：<strong>¥$!{obj.d_goods.goods_current_price}</strong></li>
                        </ul>
                        #end

                    </div>
                </div>

                <!-- 人气商品 -->
                <div id="index_sale_box_6" style="display: none;" class="index_sale_box">
                    <div id="index_sale_con_6" class="index_sale_con">

                        #foreach($obj in $hots)
                        #set($goods_url="${basePath}/goods_$!{obj.id}.htm")
                        #if($!config.second_domain_open)
                        #set($goods_url="http://$!{obj.goods_store.store_second_domain}.$!{domainPath}/goods_$!{obj.id}.htm")
                        #end
                        #if($!obj.goods_main_photo)
                        #set($img="$!imageWebServer/$!{obj.goods_main_photo.path}/$!{obj.goods_main_photo.name}_small.$!{obj.goods_main_photo.ext}")
                        #else
                        #set($img="$!imageWebServer/$!{config.goodsImage.path}/$!{config.goodsImage.name}")
                        #end
                        <ul class="index_sale_two">
                            <li class="sale_two_img">
                                <a target="_blank" href="$!goods_url">
		          	<span class="img_cspan">
		              <p>
		              <img width="150" height="150" src="$!imageWebServer/resources/style/common/images/loader.gif" onerror="this.src='${basePath}/resources/style/common/images/good.jpg';" original="$!img" style="display: inline;">
		              </p>
		            </span>
                                </a>
                            </li>
                            <li class="sale_two_name"><a target="_blank" href="$!goods_url">$!CommUtil.substring("$!obj.goods_name",20)</a></li>
                            <li class="sale_two_price">售价：<strong>¥$!{obj.goods_current_price}</strong></li>
                        </ul>
                        #end

                    </div>
                </div>

            </div>


            <div class="index_brand_right">

                <div class="brand">
                    <h3><span><a target="_blank" href="${basePath}/brand.htm">更多</a></span>推荐品牌</h3>
                    <ul>
                        #foreach($gb in $gbs)
                        <li #if($!velocityCount>4)style="display:none;"#end><img width="142" height="66" src="$!imageWebServer/$!gb.brandLogo.path/$!gb.brandLogo.name"/><a href="${basePath}/brand_goods_$!{gb.id}.htm" target="_blank">$!gb.name</a></li>
                        #end
                    </ul>
                </div>
                <div class="brand_bottom_adv">
                    <script src="${basePath}/advert_invoke.htm?id=262150"></script>
                </div>

            </div>


        </div>

        <!-- 楼层 -->
        $!httpInclude.include("/floor.htm")


        <div class="back_box_x">
            <div class="back_floor" >
                <ul>
                    <li floor_id="floor_1"><a href="javascript:void(0);"><b style="display: none;">
                        <img src="${basePath}/upload/common/fushi.jpg">
                    </b><span>流行服饰</span></a></li>
                    <li floor_id="floor_2"><a href="javascript:void(0);"><b style="display: block;">
                        <img src="${basePath}/upload/common/diannao.jpg">
                    </b><span>鞋包配饰</span></a></li>
                    <li floor_id="floor_3"><a href="javascript:void(0);"><b style="display: block;">
                        <img src="${basePath}/upload/common/shuma.jpg">
                    </b><span>家电数码</span></a></li>
                    <li floor_id="floor_4"><a href="javascript:void(0);"><b style="display: block;">
                        <img src="${basePath}/upload/common/meizhuang.jpg">
                    </b><span>运动户外</span></a></li>
                </ul>
            </div>
        </div>

        <script src="${basePath}/advert_invoke.htm?id=5"></script>
        <div class="friendlink">
            <h1>合作伙伴</h1>
            <ul class="linkimg">
                <li> <a href="#" target="_blank"><img src="$!imageWebServer/resources/style/common/images/shopping.jpg" width="92" height="35" /></a></li>
                #foreach($info in $img_partners)
                <li> <a href="$!info.url" target="_blank"><img src="$!imageWebServer/$!info.image.path/$!info.image.name" width="92" height="35" /></a></li>
                #end
            </ul>
            <div class="linka"> #foreach($info in $text_partners)<a href="$!info.url" target="_blank">$!info.title</a>#end </div>
        </div>

        <div class="shopping">
            #foreach($ac in $acs)
            <div class="shopone">
                <h1>$!ac.className</h1>
                <ul>
                    #foreach($article in $ac.articles)
                    #if($!article.url!="")
                    #set($url="$!article.url")
                    #else
                    #set($url="${basePath}/article_$!{article.id}.htm")
                    #end
                    <li><a  href="$!url" target="_blank">$!CommUtil.substring("$!article.title",12)</a></li>
                    #end
                </ul>
            </div>
            #end
        </div>

        <script>
            jQuery(document).ready(function(){
                jQuery(window).scroll(function(){
                    var top = jQuery(document).scrollTop();
                    if(top==0){
                        jQuery("#back_box").hide();
                        jQuery(".back_box_x").hide();
                    }else{
                        jQuery("#back_box").show();
                        jQuery(".back_box_x").show();
                    }
                });
                jQuery("#toTop").click(function(){
                    jQuery('body,html').animate({scrollTop:0},1000);
                    return false;
                });
            });
        </script>

    </div>
</div>
$!httpInclude.include("/footer.htm")
<script>var BASE_PATH = '${basePath}';</script>
<script src="${basePath}/resources/js/jquery-1.6.2.js"></script>
<script src="${basePath}/resources/js/DataLazyLoad.min.js"></script>
<script src="${basePath}/resources/js/jquery.lazyload.js"></script>
<script src="${basePath}/resources/js/jquery.SuperSlide.2.1.1.js"></script>
<script src="${basePath}/resources/js/jquery.shop.common.js"></script>
<script src="${basePath}/resources/js/jquery.validate.min.js"></script>
<script src="${basePath}/resources/js/jquery-ui-1.8.21.js"></script>
<script src="${basePath}/resources/js/jquery.shop.validate.js"></script>
<script src="${basePath}/resources/js/jquery.KinSlideshow.min.js"></script>
</body>

</html>
