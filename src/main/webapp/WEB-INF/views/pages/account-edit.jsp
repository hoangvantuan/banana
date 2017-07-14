<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/tiles/tablib.jsp"%>

<!-- BEGIN CONTENT -->
<div class="container">
	<div class="col-md-6 col-md-offset-3">
		<h3 class="text-center">
			<s:message code="banana.account.add.label.title"></s:message>
		</h3>
		<div>
			<c:forEach var="message" items="${messages}">
				<p class="text-danger"><s:message code="${message}" /></p>
			</c:forEach>
		</div>
		<form:form method="post" action="${pageContext.request.contextPath }/account/edit" modelAttribute="account">
			<form:input type="hidden" path="id" value="${account.id }"/>
			<div class="form-group">
				<label for="url"><s:message code="banana.account.add.label.email"></s:message><span class="text-danger">*</span></label>
				<form:input type="text" class="form-control" path="url" value="${account.url }" autofocus="autofocus"/>
			</div>
			<div class="form-group">
				<label for="account"><s:message code="banana.account.add.label.account"></s:message><span class="text-danger">*</span></label>
				<form:input type="text" class="form-control" path="accountName" value="${account.accountName }"/>
			</div>
			<div class="form-group">
				<label for="password"><s:message code="banana.account.add.label.password"></s:message><span class="text-danger">*</span></label>
				<form:input type="password" class="form-control" path="password" value="${account.password }"/>
			</div>
			<button type="submit" class="btn btn-primary btn-block">
				<s:message code="banana.account.add.btn.add"></s:message>
			</button>
		</form:form>
	</div>
</div>
<!-- END CONTENT -->