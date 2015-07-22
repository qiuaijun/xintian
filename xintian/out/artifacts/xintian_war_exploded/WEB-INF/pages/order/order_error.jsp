<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="context_path"
	value="#request.get('javax.servlet.forward.context_path')"></s:set>
<!DOCTYPE HTML>
<html>
<head>
  <meta charset="UTF-8">
  <title>错误信息页面</title>
<link rel="stylesheet" type="text/css" href="${context_path}/css/base.css">
<link rel="stylesheet" type="text/css" href="${context_path}/css/view.css">
</head>
<body>
<%@include file="/WEB-INF/pages/common/top08.jsp"%>	
<div class="info w">
  <img alt="页面出错"  src="${context_path}/images/error_img.gif">
</div>
<%@include file="/WEB-INF/pages/common/bottom08.jsp"%>
</body>
</html>