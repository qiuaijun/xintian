<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="pageModel.pageNo > 1">
		<a href="${first}">首页</a>　<a href="${previous}">上一页</a>
</s:if>
<s:else>
	<span>首页　上一页</span>
</s:else>
	<span style="color: red;">
		   【<s:property value="pageModel.pageNo"/>】  
	</span>
<s:if test="pageModel.pageNo < pageModel.bottomPageNo">
	<a href="${next}">下一页</a>　<a href="${last}">末页</a>
</s:if>
<s:else>
	<span>下一页　末页</span>
</s:else>