<%@ page language="java" contentType="text/html; charset=gb2312" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>    
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">  
    <title>修改产品</title>
     
    <meta http-equiv="Content- Type" content="text/html; charset=GB2312"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="./css/style.css" rel="stylesheet" type="text/css">
  <s:head theme="xhtml"/>   
  <sx:head parseContent="true"/>   
  </head>
  
  <body>
    <s:set id="product" value="#request.product"/> 
<s:form name="form" method="POST" action="modifyProduct!modify.action?id=%{#product.id}">  

<table border="0">
  <tr> 
    <td colspan="3"><s:textfield  name="productname" label="产品名称" value="%{#product.productname}"/></td>
  </tr>
  <tr> 
    <td colspan="3">
	 <s:action name="questionType" executeResult="true"></s:action>
</td>
  </tr>
  <tr> 
    <td colspan="2"><s:textfield
label="图片" 
name="pic" 
size="40" value="%{#product.pic}"/> </td>
    <td><s:a href="./upload/upload.jsp">上传图片</s:a></td>
  </tr>
    <tr>
  <td><s:textfield  name="price" label="价格" value="%{#product.price}" size="4"/></td><td>元</td>
  </tr>
  <tr> 
    <td>产品简介:</td>
    <td colspan="2"><sx:textarea name="introduce" value="%{#product.introduce}" cols="100" rows="10"></sx:textarea></td>
  </tr>
  <tr>
  <td colspan="3"><s:submit value="修改" />
  </td></tr>
</table>
 </s:form> 
</body>
  
</html>
