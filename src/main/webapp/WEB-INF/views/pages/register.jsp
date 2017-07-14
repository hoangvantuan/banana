<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/tiles/tablib.jsp"%>

<script>
	function checkPasswordMatch() {
		var password = $("#password").val();
		var confirmPassword = $("#confirm-password").val();

		if (confirmPassword == "") {
			$("#checkpassword").html("");
			$("#checkpassword").removeClass();
			$("button, input[type='submit']").addClass("disabled");
		} else {
			if (password != confirmPassword) {
				$("#checkpassword").removeClass();
				$("#checkpassword").html("Passwords do not match!");
				$("#checkpassword").addClass("text-danger");
				$("button, input[type='submit']").addClass("disabled");
			} else {
				$("#checkpassword").removeClass();
				$("#checkpassword").html("Passwords match.");
				$("#checkpassword").addClass("text-info");
				$("button, input[type='submit']").removeClass("disabled");
			}
		}
	}
</script>

<!-- BEGIN CONTENT -->
<div class="container">
	<div class="col-md-6 col-md-offset-3">
		<h3 class="text-center">
			<s:message code="banana.register.label.title"></s:message>
		</h3>
		<form:form method="post" action="${pageContext.request.contextPath }/register" modelAttribute="user">
			<div class="form-group">
				<c:forEach var="message" items="${messages}">
					<p class="text-danger">
						<s:message code="${message}" arguments="${user.email }" />
					</p>
				</c:forEach>
			</div>
			<div class="form-group">
				<label for="email"><s:message code="banana.register.label.email" /><span class="text-danger">*</span></label>
				<form:input type="email" class="form-control" path="email" value="${user.email }" required="required" />
			</div>
			<div class="form-group">
				<label for="password"><s:message code="banana.register.label.password" /><span class="text-danger">*</span></label>
				<form:input type="password" class="form-control" required="required" path="password" value="${user.password }" />
			</div>
			<script type="text/javascript">
				$(document).ready(function() {
					$('#password').complexify({}, function(valid, complexity) {
						var progressBar = $('#complexity-bar');

						progressBar.toggleClass('progress-bar-success', valid);
						progressBar.toggleClass('progress-bar-danger', !valid);
						progressBar.css({
							'width' : complexity + '%'
						});

						$('#complexity').text(Math.round(complexity) + '%');
					});
				});
			</script>
			<div class="progress">
				<div id="complexity-bar" class="progress-bar progress-bar-danger" role="progressbar" style="width: 0%;"></div>
				<p id="complexity">0%</p>
			</div>
			<div class="form-group">
				<label for="confirm-password"><s:message code="banana.register.label.comfirmpassword" /><span class="text-danger">*</span></label> <input onkeyup="checkPasswordMatch()" type="password" class="form-control" name="confirm-password" id="confirm-password" required="required"> <br> <span id="checkpassword"></span>
			</div>
			<button type="submit" class="btn btn-primary btn-block disabled">
				<s:message code="banana.register.btn.register" />
			</button>
		</form:form>
	</div>
</div>
<!-- END CONTENT -->