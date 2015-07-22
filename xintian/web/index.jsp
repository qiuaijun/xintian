<%--
  Created by IntelliJ IDEA.
  User: aijun
  Date: 15/6/27
  Time: 下午5:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta content="telephone=no" name="format-detection">
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="${context_path}/css/base.css">
    <link rel="stylesheet" type="text/css" href="${context_path}/css/view.css">
</head>
<body>
<s:action name="product_findCommendProduct" namespace="/product" executeResult="true"></s:action>
</body>
</html>