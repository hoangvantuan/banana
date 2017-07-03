<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/views/tiles/tablib.jsp"%>

<div class="container">
	<div class="row">
		<h3 class="text-center"><s:message code="banana.login.label.title" /></h3>
		<div class="col-md-6 col-md-offset-3">
			<form:form class="form-horizontal" action="${pageContext.request.contextPath}/login" method="POST" modelAttribute="userForm">
			<div class="form-group">
				<s:hasBindErrors name="userForm">
					<c:forEach var="error" items="${errors.allErrors}">
					<p class="text-danger"><s:message code="${error.getDefaultMessage()}" /></p>
					<br />
					</c:forEach>
    			</s:hasBindErrors>
			</div>
			<div class="form-group">
				<c:forEach var="message" items="${messages }">
					<p class="text-danger"><s:message code="${message }"></s:message></p>
				</c:forEach>
			</div>
				<div class="form-group">
					<label for="email"><s:message code="banana.login.label.email"/><span class="text-danger">*</span></label>
					<form:input type="email" class="form-control" path="email" value="${user.email }" required="required" autocomplete="on" autofocus="autofocus" />
				</div>
				<div class="form-group">
					<label for="password"><s:message code="banana.login.label.password"/><span class="text-danger">*</span></label>
					<form:input type="password" class="form-control" path="password" value="${user.password }" autocomplete="on" required="required" />
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-block"><s:message code="banana.login.btn.login"/></button>
				</div>
				<div class="pull-right form-group">
					<a href="#"><s:message code="banana.login.txt.fogotpassword"/></a>
				</div>
				<div class="form-group">
					<a class="btn btn-block btn-social btn-facebook"><span class="fa fa-facebook"></span><s:message code="banana.login.btn.login.fb"/></a>
					<a class="btn btn-block btn-social btn-google"><span class="fa fa-google"></span><s:message code="banana.login.btn.login.gg"/></a>
				</div>
			</form:form>
		</div>
	</div>
</div>

