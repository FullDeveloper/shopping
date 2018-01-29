<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title></title>
  <link href="${basePath}/resources/style/system/front/default/css/public.css" type="text/css" rel="stylesheet" />
  <link href="${basePath}/resources/style/shop/${store.template}/css/default.css" type="text/css" rel="stylesheet" />
  <link href="${basePath}/resources/style/common/css/overlay.css" type="text/css" rel="stylesheet" />
  <link href="${basePath}/resources/style/common/css/jquery.jqzoom.css" type="text/css" rel="stylesheet" />
  <script src="${basePath}/resources/js/jquery-1.6.2.js"></script>
  <script src="${basePath}/resources/js/jquery-ui-1.8.21.js"></script>
  <script src="${basePath}/resources/js/jquery.shop.common.js"></script>
  <script src="${basePath}/resources/js/jquery.validate.min.js"></script>
  <script src="${basePath}/resources/js/jquery.jqzoom-core.js"></script>
  <script src="${basePath}/resources/js/jquery.lazyload.js"></script>
</head>
<body>
<jsp:include page="/top" />
<jsp:include page="/storeHead.htm?id=${store.id}" />
<c:set var="banner" value="${basePath}/resoureces/style/shop/${store.template}/images/banner.jpg"/>
<c:if test="${store.storeBannerId != null}">
  <c:set var="banner" value="${basePath}/${banner.path}/${banner.name}"/>
</c:if>
</body>