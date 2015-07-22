<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<s:set var="context_path"
	value="#request.get('javax.servlet.forward.context_path')"></s:set>
<!DOCTYPE html>
<html class="ui-mobile">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<base href=".">
<meta charset="UTF-8">
<title>订单确认</title>
<link rel="stylesheet" type="text/css" href="${context_path}/css/module.css">
<link rel="stylesheet" type="text/css" href="${context_path}/css/cart.css">
<link rel="stylesheet" type="text/css" href="${context_path}/css/ticket.css">
<script type="text/javascript">
function orderSubmit(){
	formorder.submit();		
	return true;
}	
</script>
</head>
<body data-role="page">
<s:set value="%{0}" var="sumall"></s:set>
<s:set value="%{0}" var="saveall"></s:set>
<div id="header" class="title-ui-a w">
  <div class="back-ui-a">
    <a href="javascript:history.back(1)">返回</a>
  </div>
  <div class="header-title">订单确认</div>
  <%@include file="/WEB-INF/pages/common/order_top08.jsp"%>	
</div>

<div class="cart-2 w">
 <s:form action="order_save" namespace="/product"  method="post" id="formorder" >
        <s:hidden name="name"></s:hidden>
		<s:hidden name="address"></s:hidden>
		<s:hidden name="phone"></s:hidden>
		<s:hidden name="paymentWay"></s:hidden>
		<s:set value="%{0}" var="sumall"></s:set>
<div class="title-sub-ui-a mt10">送货方式：配送</div>
<h4 class="mt10">客户信息</h4>
<ul class="cart-list-info-2-2 list-ui-d mt10 f14">
  <li>
    <p><span class="grayA">收货姓名：</span><s:property value="name"/></p>
    <p><span class="grayA">联系电话：</span><s:property value="phone"/></p>
    <p><span class="grayA">收货地址：</span><s:property value="address"/></p>
    <p><span class="grayA">支付方式：</span><s:property value="paymentWay"/></p>
  </li>
</ul>

<h4 class="mt10">商品信息</h4>
<ul class="cart-list-info-2 list-ui-c f14">
  <s:iterator value="#session.cart">
	<s:set value="%{#sumall +productPreferentialPrice*buyNum}" var="sumall"/>
   <s:set value="%{#saveall +productPrice*buyNum - productPreferentialPrice*buyNum}" var="saveall"/>
    <li>
      <div class="wbox">
        <div class="mr10" style="margin-top:32px;">
          <input type="checkbox" class="input-checkbox-a" name="checkbox_1" checked="CHECKED">
        </div>
        <p class="pro-img"><span>
        <img src="${context_path}/<s:property value="imageAddress"/>" alt="<s:property value="productName"/>"></span></p>
        <div class="wbox-flex">
          <p><span class="attr">编号：</span><s:property value="productCode"/></p>
          <p class="pro-name"><span class="attr">名称：</span>
          <a id="name_1" ><s:property value="productName"/>
          </a>
          </p>
          <div class="count">
            <span class="attr">数量：</span>    
            <div class="countArea">
            <input class="count-input" type="text" value="<s:property value="buyNum"/>" name="quantity" id="quantity_1" disabled="disabled">
            </div>    
          </div>
          <p>
          <span class="attr">易购价：</span>    
          <span class="price">￥<s:property value="productPreferentialPrice"/></span>
          </p>
          <p>
          <span class="attr">已节省：</span>  
          <span class="price">￥<s:property value="productPrice*buyNum - productPreferentialPrice*buyNum"/></span>
          </p>
        </div>
      </div>
    </li>    
   </s:iterator>	
</ul>
<div class="cart-ticket f14">
  <p class="wbox"><span class="cart-ticket-infotitle">商品金额</span>
  <span class="price">¥<s:property value="#sumall"/></span></p>
  <p class="wbox"><span class="cart-ticket-infotitle">优惠金额</span>
  <span class="price">¥<s:property value="#saveall"/></span></p>
  <p class="wbox"><span class="cart-ticket-infotitle bold">应付金额</span>
  <span class="price">¥<s:property value="#sumall"/></span>
  <span class="cr">（免运费）</span></p>
</div>
<div class="btn-ui-b mt10">
   <a id="PayAccounts" href="javascript:void(0);" onclick="return orderSubmit();">提交订单</a>   
</div>
</s:form>
</div>
<!-- 底部开始 -->
<%@include file="/WEB-INF/pages/common/order_bottom08.jsp"%>
</body>
</html>