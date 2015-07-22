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
    <title>商品列表</title>
    <link rel="stylesheet" type="text/css" href="${context_path}/css/base.css">
    <link rel="stylesheet" type="text/css" href="${context_path}/css/view.css">
    <script type="text/javascript" src="${context_path}/js/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            pHolder();
        });
        //搜索框获取焦点后文本变空
        function pHolder() {
            var elem = $("#keywordsTop");
            var dValue = $("#keywordsTop").val();
            elem.focus(function () {
                if (elem.val() == dValue) {
                    elem.val("");
                }
            });
            elem.blur(function () {
                if (elem.val() == "") {
                    elem.val(dValue);
                }
            });
        }
    </script>
</head>
<body>
<div id="filterPage">
    <!-- 公用头部导航 -->
    <%@include file="/WEB-INF/pages/common/top08.jsp" %>
    <!-- 用于取出 搜索关键字 -->
    <div class="search-box" style="position:relative;top:0;margin-top:10px;">
        <s:form action="product_findByName" method="post" namespace="/product">
            <div id="sou">
                <input type="search" name="name" id="keywordsTop" class="search-input" autocomplete="off"/>
            </div>
            <div id="sou_zi">
                <input type="submit" class="search-btn" style="border:none;text-indent:-99em;">
                <input type="hidden" name="ERROEVIEW" value="SNMWErrorView">
            </div>
        </s:form>
    </div>
    <s:if test="pageModel != null && pageModel.list.size() > 0">
        <div class="search-list w">
            <ul class="my-order-list pro-list list-ui-c" id="productList">
                <s:iterator value="pageModel.list">
                    <li>
                        <div class="wbox">
                            <div class="pro-img">
                                <s:a action="product_select" namespace="/product">
                                    <s:param name="id" value="id"></s:param>
                                    <img width="100" height="100"
                                         src="${context_path}/<s:property value="goodsImageAddress" />"
                                         alt="<s:property value="name" />">
                                </s:a>
                            </div>
                            <div class="pro-info">
                                <p class="pro-name">
                                    <s:a action="product_select" namespace="/product">
                                        <s:param name="id" value="id"></s:param>
                                        <s:property value="name"/>
                                    </s:a>
                                </p>

                                <p class="pro-tip gray6 mt10"><s:property value="model"/></p>

                                <p class="mt10">
                  <span class="snPrice" style="font-size:12px; color:grey">¥
                      <s><s:property value="goodsPrice"/></s>
                  </span>
                                </p>

                                <p class="mt10">
                  <span class="snPrice" style="font-size:14px;">¥
                      <em><s:property value="goodsPreferentialPrice"/></em>
                  </span>
                                </p>

                                <p class="pleft">
                                    <s:a action="cart_add" namespace="/product">
                                        <s:param name="productId" value="id"></s:param>
                                        <img alt="购买" src="${context_path}/images/but_buy.gif"/>
                                    </s:a>
                                    <img alt="收藏" src="${context_path}/images/bookz_save.gif"/>
                                </p>
                            </div>
                        </div>
                        <span class="arrow"></span>
                    </li>
                </s:iterator>
            </ul>
        </div>
        <div id="more_load w">
            <div class="load-more-lay" style="display: block;" id="loadingMore">
                <s:url var="first">
                    <s:param name="pageNo" value="1"></s:param>
                    <s:param name="product.name" value="product.name"></s:param>
                </s:url>
                <s:url var="previous">
                    <s:param name="pageNo" value="pageModel.pageNo-1"></s:param>
                    <s:param name="product.name" value="product.name"></s:param>
                </s:url>
                <s:url var="last">
                    <s:param name="pageNo" value="pageModel.bottomPageNo"></s:param>
                    <s:param name="product.name" value="product.name"></s:param>
                </s:url>
                <s:url var="next">
                    <s:param name="pageNo" value="pageModel.pageNo+1"></s:param>
                    <s:param name="product.name" value="product.name"></s:param>
                </s:url>
            </div>
            <div class="page">
                <s:include value="/WEB-INF/pages/common/page08.jsp"></s:include>
            </div>
        </div>
        <div id="BottomSearchDiv" class="search-box mt5" style="position:relative;">
            <s:form action="product_findByName" method="post" namespace="/product">
                <div id="sou">
                    　<input type="search" name="name" id="keywordsTop1" class="search-input" autocomplete="off"/>
                </div>
                <div id="sou_zi">
                    <input type="submit" class="search-btn" style="border:none;text-indent:-99em;">
                    <input type="hidden" name="ERROEVIEW" value="SNMWErrorView">
                </div>
            </s:form>
        </div>
    </s:if>
    <s:else>
        <div id="more_load w">
            <div class="page">
                <span>对不起，还没有添加商品信息。</span><br/>
                <s:a action="index" namespace="/">返回主页</s:a>
            </div>
        </div>
    </s:else>
    <!-- 公用尾部 -->
    <%@include file="/WEB-INF/pages/common/bottom08.jsp" %>
</div>
</body>
</html>