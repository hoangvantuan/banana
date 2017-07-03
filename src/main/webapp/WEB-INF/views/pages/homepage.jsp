<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/tiles/tablib.jsp"%>

<c:forEach var="account" items="${accounts }">
	<p>${account.url }</p>
	<p>${account.user.email }
</c:forEach>
