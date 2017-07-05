<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/tiles/tablib.jsp"%>

<!--BEGIN CONTENT -->
<div class="container">
   <h3 class="text-center"><s:message code="banana.user.reset.page.title"/></h3>
  <div class="col-md-6 col-md-offset-3">
    <form:form class="form-horizontal" method="POST" action="${pageContext.request.contextPath }/reset" modelAttribute="userForm">
    <div class="form-group">
					<c:forEach var="message" items="${messages}">
					<p class="text-danger"><s:message code="${message}" arguments="${userForm.email }" /></p>
					</c:forEach>
	</div>
      <div class="form-group">
        <label for="email"><s:message code="banana.user.reset.label.email"></s:message><span class="text-danger">*</span></label>
          <form:input type="email" class="form-control" path="email"  required="required" autocomplete="on" autofocus="autofocus" />
      </div>
      <div class="form-group">
          <button type="submit" class="btn btn-primary btn-block"><s:message code="banana.user.reset.btn.reset"/></button>
      </div>
    </form:form>
  </div>
</div>
<!-- END CONTENT -->