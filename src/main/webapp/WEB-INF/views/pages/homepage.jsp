<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/tiles/tablib.jsp"%>

<script>
	var clipboard = new Clipboard('a');

	function showPassword(id) {
		var obj = document.getElementById(id);
		obj.type = "text";
	}

	function hidePassword(id) {
		var obj = document.getElementById(id);
		obj.type = "password";
	}

	function hideToogle() {
		setTimeout(function() {
			$('a[data-toggle="tooltip"]').tooltip('hide');
		}, 200);
	}

	function deleteAccount(id) {
		if (confirm('Realy want delete this?')) {
			$.ajax({
				type: 'GET',
				url: '${pageContext.request.contextPath}/account/delete/' + id,
				data: {}
			}).done(function(responses, textStatus, xhr) {
				var element = "#account" + id;
				$(element).remove();
			}).fail(function(responses, textStatus, xhr) {
			}).always(function(responses) {
				$("#message").html(responses);
			})
		}
	}

	$(document).ready(function() {
		$('a[data-toggle="tooltip"]').tooltip({
		    animated: true,
		    placement: 'bottom',
		    trigger: 'click',
		    title: 'Copied'
		});
	})

</script>

<!-- BEGIN SEARCH BOX -->
<div class="container-fluid">
	<div class="row">
		<div class="col-md-3 col-md-offset-9">
			<form method="GET" action="${pageContext.request.contextPath }/search" class="form-inline">
				<div class="form-group">
					<input type="text" class="form-control" id="search-key" name="key" autofocus="autofocus">
				</div>
				<button type="submit" class="btn btn-primary"><s:message code="banana.home.search.label"></s:message></button>
			</form>
		</div>
	</div>
</div>
<!-- END SEARCH BOX-->
<!-- BEGIN CONTENT -->
<div class="container-fluid">
	<!-- TITLE -->
	<div class="row">
		<h3 class="text-center">
			<s:message code="banana.home.label.title"></s:message>
		</h3>
	</div>
	<!-- END TITLE -->
	<div class="row">
		<c:forEach var="message" items="${messages}">
			<p class="text-danger">
				<s:message code="${message}" />
			</p>
		</c:forEach>
		<p id="message" class="text-danger text-center"></p>
	</div>
	<!-- DATA -->
	<div class="row">
		<div class="col-md-10 col-md-offset-1">
			<a href="${pageContext.request.contextPath }/account/add"><span class="glyphicon glyphicon-plus btn-add"></span>
			<s:message code="banana.home.add.account.link"></s:message></a>
			<div>
				<table class="table table-bordered table-striped">
					<thead>
						<th class="text-center" style="width: 50px;"><s:message code="banana.home.account.table.label.no"></s:message></th>
						<th class="text-center" style="width: 600px;"><s:message code="banana.home.account.table.label.domain"></s:message></th>
						<th class="text-center" style="width: 400px;"><s:message code="banana.home.account.table.label.account"></s:message></th>
						<th class="text-center" style="width: 300px;"><s:message code="banana.home.account.table.label.password"></s:message></th>
						<th class="text-center" style="width: 250px;"><s:message code="banana.home.account.table.label.password.strength"></s:message></th>
						<th class="text-center" style="width: 50px;"><s:message code="banana.home.account.table.label.edit"></s:message></th>
						<th class="text-center" style="width: 70px;"><s:message code="banana.home.account.table.label.delete"></s:message></th>
					</thead>
					<tbody>
						<c:forEach var="account" items="${user.accounts }" varStatus="loop">
							<tr id="account${account.id }">
								<td class="text-center col-md-1">${loop.index +1}</td>
								<td>${account.url }</td>
								<td>${account.accountName }</td>
								<td>
									<form class="form-inline">
										<div class="form-group">
											<div class="input-group">
												<input type="password" class="form-control" id="password${loop.index }" value="${account.password }" readonly />
												<div class="input-group-addon">
													<a href="#" onmousedown="showPassword('password${loop.index}')" onmouseup="hidePassword('password${loop.index}')"><span class="glyphicon glyphicon-eye-open btn-show"></span></a>
												</div>
												<div class="input-group-addon">
													<a href="#" onmouseleave="hideToogle()" data-toggle="tooltip" data-clipboard-text="${account.password }"><span class="glyphicon glyphicon-share btn-copy"></span></a>
												</div>
											</div>
										</div>
									</form>
								</td>
								<td>
									<div>
										<script type="text/javascript">
									$(document).ready(function(){
										$('#password${loop.index}').complexify({}, function (valid, complexity) {
											var progressBar = $('#complexity-bar${loop.index}');

											progressBar.toggleClass('progress-bar-success', valid);
											progressBar.toggleClass('progress-bar-danger', !valid);
											progressBar.css({'width': complexity + '%'});
										});
									});
									</script>
										<div class="progress">
											<div id="complexity-bar${loop.index }" class="progress-bar progress-bar-danger" role="progressbar" style="width: 0%;"></div>
										</div>
									</div>
								</td>
								<td class="text-center"><a href="${pageContext.request.contextPath }/account/edit/${account.id}"><span class="glyphicon glyphicon-edit"></span></a></td>
								<td class="text-center"><a href="#" onclick="deleteAccount(${account.id})"><span class="glyphicon glyphicon-trash"></span></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- END DATA -->
	<div class="col-md-4 col-md-offset-4 text-center">
		<nav aria-label="pagination">
			<ul class="pagination">
				<c:if test="${key != null}">
					<c:set var="search" value="/search/page/"></c:set>
					<c:set var="keySearch" value="?key=${key }"></c:set>
				</c:if>
				<c:if test="${key == null }">
					<c:set var="search" value="/page/"></c:set>
					<c:set var="keySearch" value=""></c:set>
				</c:if>
				<c:forEach var="page" items="${pages }">
					<c:if test="${page == currentPage }">
						<li class="active"><a href="${pageContext.request.contextPath }${search}${page}${keySearch}">${page }<span class="sr-only">(current)</span></a></li>
					</c:if>
					<c:if test="${page != currentPage }">
						<li class=""><a href="${pageContext.request.contextPath }${search }${page}${keySearch }">${page }<span class="sr-only">(current)</span></a></li>
					</c:if>
				</c:forEach>
			</ul>
		</nav>
	</div>
</div>
<!-- END CONTENT -->