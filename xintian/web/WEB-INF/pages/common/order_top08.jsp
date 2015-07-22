 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<div class="site-nav">
  <ul class="fix">
    <li class="mysn"><s:a action="customer_login" namespace="/customer">登录</s:a></li>
    <li class="mycart"><s:a action="cart_list" namespace="/product">购物车</s:a></li>
    <li class="home"><s:a action="index" namespace="/">返回首页</s:a></li>
  </ul>
</div>