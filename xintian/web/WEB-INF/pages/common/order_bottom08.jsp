 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!-- 底部开始 -->
<div id="footer" class="w">
  <div class="w fix user-info">
    <div class="user-name fl" id="footerUserName">当前用户： 
    <span class="a">
    <s:if test="#session.customer != null">    
       <s:property value="#session.customer.username"/>  
     </s:if>
    </span>
    </div>
    <div class="fr"><a id="backTop" href="javascript:;" >回顶部</a></div>
  </div>
  <ul class="list-ui-a">
    <li>
      <div class="w user-login">
        <s:a action="customer_login" namespace="/customer">
            登录
        </s:a> 
        <s:a action="cart_list" namespace="/product">购物车</s:a>       
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