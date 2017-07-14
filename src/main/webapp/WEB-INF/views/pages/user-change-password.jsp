<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/tiles/tablib.jsp"%>

<script>
	function checkPasswordMatch() {
		var password = $("#password").val();
		var confirmPassword = $("#confirm-new-password").val();

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
			<s:message code="banana.user.changepassword.label.title" />
		</h3>
		<form:form method="post" action="${pageContext.request.contextPath }/changepassword" modelAttribute="user">
			<div class="form-group">
				<c:forEach var="message" items="${messages}">
					<p class="text-danger">
						<s:message code="${message}" arguments="${user.email }" />
					</p>
				</c:forEach>
			</div>
			<div class="form-group">
				<label for="new-password"><s:message code="banana.user.changepassword.label.newpassword" /><span class="text-danger">*</span></label>
				<form:input type="password" class="form-control" path="password" autofocus="on" />
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

					});
				});
			</script>
			<div class="progress">
				<div id="complexity-bar" class="progress-bar progress-bar-danger" role="progressbar" style="width: 0%;"></div>
			</div>
			<div class="form-group">
				<label for="confirm-new-password"><s:message code="banana.user.changepassword.label.newpasswordconfirm" /><span class="text-danger">*</span></label> <input onkeyup="checkPasswordMatch()" type="password" class="form-control" name="confirm-new-password" id="confirm-new-password">
			</div>
			<span id="checkpassword"></span>
			<button type="submit" class="btn btn-primary btn-block disabled">
				<s:message code="banana.user.changepassword.btn.change" />
			</button>
		</form:form>
	</div>
</div>
<!-- END CONTENT -->