 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!-- 公用尾部 -->
<footer class="footer w">
  <div class="layout fix user-info">
  <div class="tr"><a href="#" class="backTop" id="backTop">回顶部</a></div>
  </div>  
  <ul class="list-ui-a foot-list tc">  
    <li>
      <s:a action="customer_login" namespace="/customer"  class="foot1">
           登录
      </s:a> ｜
      <s:a action="customer_register" namespace="/customer"  class="foot2">    
           注册
      </s:a>
    </li>
    <li>
      <s:if test="#session.customer != null">欢迎    
       <s:property value="#session.customer.realname"/>
       <s:a action="customer_logout" namespace="/customer">【退出】</s:a>      
     </s:if>
     <s:else>
        请先进行登录
     </s:else>
  </li>
  </ul>
  <div class="tc copyright">Copyright© 2015-2018 m.xintian.com</div>
</footer>  