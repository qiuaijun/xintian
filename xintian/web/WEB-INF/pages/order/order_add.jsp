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
<title>添加订单</title>
<link rel="stylesheet" type="text/css" href="${context_path}/css/module.css">
<link rel="stylesheet" type="text/css" href="${context_path}/css/cart.css">
<script type="text/javascript">
function orderSubmit(){
	formorder.submit();		
	return true;
}
</script>
</head>
<body data-role="page">
<div id="header" class="title-ui-a w">
  <div class="back-ui-a">
    <a href="javascript:history.back(1)">返回</a>
  </div>
  <div class="header-title">添加订单</div>
  <%@include file="/WEB-INF/pages/common/order_top08.jsp"%>	
</div>

<div class="cart-2 w" id="shopCarSendgood">
<s:fielderror></s:fielderror>
<s:form action="order_confirm" namespace="/product" method="post" id="formorder" >
  <ul class="cart-list-2">
  <li id="other1">
  <s:textfield name="name" cssClass="input-ui-a"  maxlength="6"  id="name" placeholder="收货人姓名:" onBlur="if(!valDlvReceiver(0))return;"></s:textfield>
  <span id="error0" class="err-tips mt5" style="display:none"></span>
  </li>
  <li id="other2">
  <s:textfield name="phone" cssClass="input-ui-a" maxlength="11" placeholder="手机号码:" id="phone" onBlur="if(!valDlvRecMobile(1))return;"></s:textfield>
  <span id="error1" class="err-tips mt5" style="display:none"></span>
  </li>
  <li id="other3">
  <s:textarea name="address" cssClass="textarea-ui-a" cols="50" rows="3"  maxlength="30" id="address" placeholder="收货人地址：" onBlur="if(!valOtherAdd(6))return;"></s:textarea>
  <span id="error6" class="err-tips mt5" style="display:none"></span>
  </li>
  </ul>
  <div class="cate-list">
    <ul class="fix"> 
      <li>
        <dl>
          <dt class="list-ui-div cur">支付方式</dt>
          <dd style="display:block;">
            <div class="cart3-pay-type label-bind f14" style="padding:10px 25px;">
              <p>
              <input class="input-radio-a" type="radio" name="paymentWay" value="货到付款" checked="CHECKED">货到付款</p>
              <p><label style="filter:gray; color:gray">
              <input class="input-radio-a" type="radio" name="paymentWay" value="网上银行" >网上银行</label></p>
              <p><label style="filter:gray; color:gray">
              <input class="input-radio-a" type="radio" name="paymentWay" value="移动POS机" >移动POS机</label></p>
              <p><label style="filter:gray; color:gray">
              <input class="input-radio-a" type="radio" name="paymentWay" value="支付宝" >支付宝</label></p>
              <p><label style="filter:gray; color:gray">
              <input class="input-radio-a" type="radio" name="paymentWay" value="邮局汇款" >邮局汇款</label></p>
            </div>
          </dd>
        </dl>
      </li>
    </ul>
  </div>  
  <div class="btn-ui-c mt10">
  <a id="savaAddr" href="javascript:void(0);" onclick="return orderSubmit();">提交</a>
  </div>
</s:form>
</div>
<!-- 底部开始 -->
<%@include file="/WEB-INF/pages/common/order_bottom08.jsp"%>
</body>
</html>