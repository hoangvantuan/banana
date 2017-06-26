<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/tiles/tablib.jsp" %>

<!DOCTYPE html>
<html>
	<head>
		<tiles:insertAttribute name="head"></tiles:insertAttribute>
		<c:set var="title"><tiles:getAsString name="title"></tiles:getAsString></c:set>
		<title><s:message code="${title }"></s:message></title>
	</head>
	<nav>
		<tiles:insertAttribute name="navigation"></tiles:insertAttribute>
	</nav>
	<body>
		<tiles:insertAttribute name="body"></tiles:insertAttribute>
	</body>
	<footer>
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</footer>
</html>