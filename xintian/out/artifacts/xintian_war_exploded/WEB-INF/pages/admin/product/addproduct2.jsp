<%@page pageEncoding="GB2312" contentType="text/html; charset=GB2312" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>增加产品</title>
    <link href="./css/style.css" rel="stylesheet" type="text/css">
    <meta http-equiv="Content- Type" content="text/html; charset=GB2312"/>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <s:head theme="xhtml"/>
    <sx:head parseContent="true"/>
</head>

<body>
<s:form name="form" id="form" method="POST" action="product_add">

    <table border="0">
        <tr>
            <td colspan="3"><s:textfield name="name" label="产品名称"/></td>
        </tr>
        <tr>
            <td colspan="3">
                <s:textfield name="model" label="类型"/>
                <%--<s:doubleselect name="bigtype" list="bigtypeList" listKey="bigtypeid" listValue="bigtypename"--%>
                                <%--doubleName="smalltype" doubleList="smalltypeMap.get(top.bigtypeid)"--%>
                                <%--doubleListKey="smalltypeid" doubleListValue="smalltypename"/>--%>
            </td>
        </tr>
        <tr>
            <td colspan="2"><s:textfield
                    label="图片"
                    name="goodsImageAddress"
                    size="40"/></td>
            <td><s:a href="./upload/upload.jsp">上传图片</s:a></td>
        </tr>
        <tr>
            <td colspan="3"><s:textfield name="goodsPrice" label="价格" size="4"/></td>
            <td>元</td>
        </tr>
        <tr>
            <td>产品简介:</td>
            <td height="20">
                <sx:textarea name="commend"></sx:textarea>
            </td>
        </tr>
        <tr>
            <td colspan="3"><s:submit value="增加"/>
            </td>
        </tr>
    </table>
</s:form>
</body>

</html>
