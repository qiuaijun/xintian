<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:set var="context_path"
       value="#request.get('javax.servlet.forward.context_path')"></s:set>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta content="telephone=no" name="format-detection">
    <title>购物车_易购网触屏版</title>
    <link rel="stylesheet" type="text/css" href="${context_path}/css/module.css">
    <%--<link rel="stylesheet" type="text/css" href="${context_path}/css/cart.css">--%>
    <script type="text/javascript" src="${context_path}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${context_path}/js/snmwshopCart1.js"></script>
    <script type="text/javascript" src="${context_path}/js/snmwshopCart1_v2.js"></script>
</head>
<body data-role="page">
<s:set value="%{0}" var="sumall"></s:set>
<s:set value="%{0}" var="saveall"></s:set>
<div id="header" class="title-ui-a w">
    <div class="back-ui-a">
        <a href="javascript:history.back(1)">返回</a>
    </div>
    <div class="header-title">购物车</div>
    <div class="site-nav">
        <ul class="fix">
            <li class="mysn"><s:a action="order_findByCustomer" namespace="/product">我的订单</s:a></li>
            <li class="mycart"><s:a action="cart_list" namespace="/product">我的购物车</s:a></li>
            <li class="home"><s:a action="index" namespace="/">返回首页</s:a></li>
        </ul>
    </div>
</div>
<!-- 头部结束 -->
<div class="cart-list-1 w f14">
    <ul class="cart-list list-ui-c" id="Cart_List">
        <s:iterator value="#session.cart">
            <s:set value="%{#sumall +productPreferentialPrice*buyNum}" var="sumall"/>
            <s:set value="%{#saveall +productPrice*buyNum - productPreferentialPrice*buyNum}" var="saveall"/>
            <li>
                <div class="wbox">
                    <div class="mr10" style="margin-top:32px;">
                        <input type="checkbox" class="input-checkbox-a" onclick="doForSelectSNShop(&#39;1&#39;);"
                               name="checkbox_1" id="checkbox_1" checked="CHECKED">
                    </div>
                    <p class="pro-img"><span>
        <img src="${context_path}/<s:property value="imageAddress"/>" alt="<s:property value="productName"/>"></span>
                    </p>

                    <div class="wbox-flex">
                        <p><span class="attr">编号：</span><s:property value="productCode"/></p>

                        <p class="pro-name"><span class="attr">名称：</span>
                            <a id="name_1"><s:property value="productName"/>
                            </a>
                        </p>

                        <div class="count">
                            <span class="attr">数量：</span>

                            <div class="countArea">
                                <s:a action="cart_editNum" namespace="/product">
                                    <s:param name="productId" value="productId"></s:param>
                                    <s:param name="flag">min</s:param>
                                    <span class="min" onclick="javascript:lesV2(this,&#39;1&#39;);"></span>
                                </s:a>
                                <input class="count-input" type="text" value="<s:property value="buyNum"/>"
                                       name="quantity" id="quantity_1"
                                       onkeyup="javascript:validateProdQuantityV2(this,&#39;error_message_1&#39;,&#39;1&#39;);inputQuantityV2();return false;">
                                <s:a action="cart_editNum" namespace="/product">
                                    <s:param name="productId" value="productId"></s:param>
                                    <s:param name="flag">add</s:param>
                                    <span class="add" onclick="javascript:addV2(this,&#39;1&#39;);"></span>
                                </s:a>
                            </div>
                        </div>
                        <p>
                            <span class="attr">易购价：</span>
                            <span class="price">￥<s:property value="productPreferentialPrice"/></span>
                        </p>

                        <p>
                            <span class="attr">已节省：</span>
                            <span class="price">￥<s:property
                                    value="productPrice*buyNum - productPreferentialPrice*buyNum"/></span>
                        </p>
                        <s:a action="cart_delete" namespace="/product">
                            <s:param name="productId" value="productId"></s:param>
                            <div class="trash" onclick="javascript:deleteCartItem(this);">
                                <span class="lid"></span><span class="can"></span>
                            </div>
                        </s:a>
                    </div>
                </div>
            </li>
        </s:iterator>
    </ul>
    <p class="mt5 tr">商品总计 :
        <span><em id="userPayAllprice">￥<s:property value="#sumall"/></em></span>
    <span id="promotionAmountSpan">- 优惠：<em id="totalPromotionAmount">￥<s:property value="#saveall"/></em>
    </span>
    </p>

    <p class="mt5 tr">应付总额(未含运费) : <span class="price"><em id="userPayAllpriceList">￥<s:property value="#sumall"/></em></span>
    </p>

    <div class="btn-ui-b mt10" id="checkOutButton">
        <s:a action="order_add" namespace="/product">
            <span title="去结算">去结算</span>
        </s:a>　
    </div>
    <div class="btn-ui-c mt10">
        <s:a action="index" namespace="/">
            <span title="继续购物">&lt;&lt;继续购物</span>
        </s:a>
    </div>
    <div class="btn-ui-b mt10" id="checkOutButton">
        <s:a action="cart_clear" namespace="/product">
            <span title="清空购物车">清空购物车</span>
        </s:a>
    </div>
</div>
<!-- 底部开始 -->
<div id="footer" class="w">
    <div class="layout fix user-info">
        <div class="user-name fl" id="footerUserName">当前用户：
    <span class="a">
    <s:if test="#session.customer != null">
        <s:property value="#session.customer.username"/>
    </s:if>
    </span>
        </div>
        <div class="fr"><a id="backTop" href="javascript:;">回顶部</a></div>
    </div>
    <ul class="list-ui-a">
        <li>
            <div class="w user-login">
                <s:a action="customer_login" namespace="/customer">
                    登录
                </s:a>
                <s:a action="customer_register" namespace="/customer" name="wap_home_bottom02002" id="footerRegister">
                    注册
                </s:a>
                <s:if test="#session.customer != null">
                    <s:a action="customer_logout" namespace="/customer">退出</s:a>
                </s:if>
                <s:else>
                    请先进行登录
                </s:else>
            </div>
        </li>
    </ul>
    <div class="copyright">Copyright© 2012-2018 m.ebuy.com</div>
</div>
</body>
</html>