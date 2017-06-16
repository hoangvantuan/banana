<%@include file="include_taglib.jsp"%>

<!DOCTYPE html>
<html lang="jp">
<%--Begin head --%>
<head>
<%@include file="include_head.jsp"%>
<title><s:message code="banana.home.label.title" /></title>
</head>
<%--Begin Body --%>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h3 class="text-center">
					<s:message code="banana.home.label.welcome" />
				</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<form:form method="POST" action="${pageContext.request.contextPath}/login" commandName="account" >
					<form:errors path="*" cssClass="errorblock" element="div" />
					<div class="form-group">
						<label for="username">Email address</label>
						<form:input path="username" type="text" class="form-control"/>
						<form:errors path="username" cssClass="error" />
					</div>
					<div class="form-group">
						<label for="password">Password</label>
						<form:input path="password" type="password" class="form-control"/>
						<form:errors path="password" cssClass="error" />
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form:form>
			</div>
		</div>
		<%@include file="include_footer.jsp"%>
	</div>
</body>
</html>
