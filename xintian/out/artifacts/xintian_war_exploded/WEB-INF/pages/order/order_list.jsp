<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="context_path"
	value="#request.get('javax.servlet.forward.context_path')"></s:set>
<!DOCTYPE html>
<html class="ui-mobile"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href=".">
<meta charset="UTF-8">
<title>订单详情_易购网触屏版</title>
<link rel="stylesheet" type="text/css" href="${context_path}/css/module.css">
<link rel="stylesheet" type="text/css" href="${context_path}/css/member.css">
<link rel="stylesheet" type="text/css" href="${context_path}/css/base.css">
</head>
<body>
<div id="header" class="title-ui-a w">
  <div class="back-ui-a">
  <a href="javascript:history.back(1)">返回</a>
  </div>
  <div class="header-title">订单详情</div>
  <div class="site-nav">
    <ul class="fix">
      <li class="mysn"><s:a action="order_findByCustomer" namespace="/product">我的订单</s:a></li>
      <li class="mycart"><s:a action="cart_list" namespace="/product">购物车</s:a></li>
      <li class="home"><s:a action="index" namespace="/">返回首页</s:a></li>
    </ul>
  </div>
</div>

<div class="mysuning w f14">
  <s:iterator value="pageModel.list">
  <div class="pbox mt10">
    <p><span class="grayA">订单编号：</span><em><strong><s:property value="orderCode"/></strong></em></p>
    <p><span class="grayA">下单时间：</span><s:date name="createTime" format="yyyy年MM月d日 HH:mm"/></p>
    <p><span class="grayA">订单状态：</span><s:property value="orderState"/></p>
  </div>
  </s:iterator>
  <div class="pbox mt10">
    <p><span class="grayA">收货姓名：</span><s:property value="name"/></p>
    <p><span class="grayA">联系电话：</span><s:property value="phone"/></p>
    <p><span class="grayA">收货地址：</span><s:property value="address"/></p>
    <p><span class="grayA">付款方式：</span><s:property value="paymentWay"/></p>
    <p><span class="grayA">配送方式：</span>配送</p>
    <p><span class="grayA">商品金额：</span>￥<s:property value="totalPrice"/></p>
    <p><span class="grayA">优惠金额：</span>￥0.00</p>
    <p><span class="grayA">应付金额：</span><span class="price">￥<s:property value="totalPrice"/></span></p>
  </div>
  
  <div class="line"></div>
  <s:url var="first">
    <s:param name="pageNo" value="1"></s:param>
  </s:url>
  <s:url var="previous">
    <s:param name="pageNo" value="pageModel.pageNo-1"></s:param>
  </s:url>
  <s:url var="last">
    <s:param name="pageNo" value="pageModel.bottomPageNo"></s:param>
  </s:url>
  <s:url var="next">
    <s:param name="pageNo" value="pageModel.pageNo+1"></s:param>
  </s:url>
  <div class="w page">
    <s:include value="/WEB-INF/pages/common/page08.jsp"></s:include>
  </div>
  <div class="line"></div>
</div>
<!-- 底部开始 -->
<%@include file="/WEB-INF/pages/common/order_bottom08.jsp"%>
</body>
</html>