<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="context_path"
	value="#request.get('javax.servlet.forward.context_path')"></s:set>	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>商品信息详情</title>
<link rel="stylesheet" type="text/css" href="${context_path}/css/base.css">
<link rel="stylesheet" type="text/css" href="${context_path}/css/view.css">
</head>

<body>
<input type="hidden" id="resourceType" value="wap">
<input type="hidden" id="ga_itemDataBean_itemID" value="id">
<!-- 公用头部导航 -->
<nav class="nav nav-sub pr w">  
  <a class="goback" href="javascript:history.back(1)">返回</a>
  <div class="nav-title wb">商品信息详情</div>  
  <a href="#" class="my-account" ></a>
  <a href="#" class="my-cart my-cart-in"></a>  
  <a href="index.jsp" class="home"></a>  
</nav>
<!-- 头部结束 -->
<div class="detailBox w" id="DetailBox">
  <s:push value="product">
    <div class="tabBox mt10">
      <div class="pro_gallery w" id="Detail_Gallery">
        <div class="pro_gallery_box">
          <ul class="slide_ul">
          <li>
            <img width="260" src="${context_path}/<s:property value="bigImageAddress"/>" alt="<s:property value="name" />">
          </li>
          </ul>
        </div>
      </div>
      <h1 id="productName" class="pro-h1">商品编码：<s:property value="goodsCode" /> <br />
      商品名称：<s:property value="name" /></h1>
      <ul class="pro_buy_detail">
        <li class="pdtn bbc">
          <div class="attr">优惠价格：</div>
          <div class="data-box">
            <span class="snPrice f16" id="mainPrice">¥<s:property value="goodsPreferentialPrice"/></span>
          </div>
        </li>
      </ul>
      <div class="w">
        <div id="comAddCart" class="wbox">
          <div class="mt10" style="margin-right:10px;">
             <img id="changeImg" src="${context_path}/images/fav2.png" width="80" height="40">
          </div>
          <div class="btn-sn-b mt10 wbox-flex">
              <s:a action="cart_add" namespace="/product">
                  <s:param name="productId" value="id"></s:param>
                  <span>放入购物车</span>
              </s:a>
          </div>
          <div class="btn-sn-e mt10 wbox-flex" style="display: none;" id="productWarning"><span>暂时无货</span></div>
        </div>
      </div>
    </div>
  </s:push> 
</div>
<!-- 公用尾部 -->
<%@include file="/WEB-INF/pages/common/bottom08.jsp"%>	
</body>
</html>