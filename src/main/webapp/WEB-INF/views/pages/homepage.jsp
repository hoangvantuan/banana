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
		setTimeout(() => {
			$('a[data-toggle="tooltip"]').tooltip('hide');
		}, 200);
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
        <div class="col-md-4 col-md-offset-8">
            <form method="GET" action="#" class="form-inline">
                <div class="form-group">
                    <input type="text" class="form-control" id="search-key" placeholder="Search Key">
                </div>
                <button type="submit" class="btn btn-primary">Search</button>
            </form>
        </div>
    </div>
</div>
<!-- END SEARCH BOX-->
<!-- BEGIN CONTENT -->
<div class="container-fluid">
    <!-- TITLE -->
    <div class="row">
        <h3 class="text-center">LIST ACCOUNT</h3>
    </div>
    <!-- END TITLE -->
    <div>
    	<c:forEach var="message" items="${messages}">
			<p class="text-danger"><s:message code="${message}" /></p>
		</c:forEach>
    </div>
    <!-- DATA -->
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <a href="#"><span class="glyphicon glyphicon-plus btn-add"></span>Add account</a>
            <div class="table-responsive">
                <table class="table table-bordered table-striped">
                    <thead>
                        <th class="text-center col-md-1">No</th>
                        <th class="text-center col-md-5">URL</th>
                        <th class="text-center col-md-2">Account</th>
                        <th class="text-center col-md-2">Password</th>
                        <th class="text-center col-md-2">Password Strength</th>
                        <th class="text-center col-md-1">Edit</th>
                        <th class="text-center col-md-1">Delete</th>
                    </thead>
                    <tbody>
                    	<c:forEach var="account" items="${userForm.accounts }" varStatus="loop">
                        <tr>
                            <td class="text-center col-md-1">${loop.index }</td>
                            <td class="col-md-5">${account.url }</td>
                            <td class="col-md-2">${account.accountName }</td>
                            <td class="col-md-2">
                                <form class="form-inline">
 									<div class="form-group">
    									<div class="input-group">
      										<input type="password" class="form-control" id="password${loop.index }" value="${account.password }" readonly />
      										<div class="input-group-addon"><a href="#" onmousedown="showPassword('password${loop.index}')" onmouseup="hidePassword('password${loop.index}')"><span class="glyphicon glyphicon-eye-open btn-show"></span></a></div>
     										<div class="input-group-addon"><a href="#" onmouseleave="hideToogle()" data-toggle="tooltip" data-clipboard-text="${account.password }"><span class="glyphicon glyphicon-share btn-copy"></span></a></div>
    									</div>
  									</div>
								</form>
                            </td>
                            <td>
                             	<div class="col-md-12">
									<script type="text/javascript">
									$(document).ready(function(){
										$('#password${loop.index}').complexify({}, function (valid, complexity) {
											var progressBar = $('#complexity-bar${loop.index}');

											progressBar.toggleClass('progress-bar-success', valid);
											progressBar.toggleClass('progress-bar-danger', !valid);
											progressBar.css({'width': complexity + '%'});

											$('#complexity${loop.index}').text(Math.round(complexity) + '%');
										});
									});
									</script>
									<div class="progress">
										<div id="complexity-bar${loop.index }" class="progress-bar progress-bar-danger" role="progressbar" style="width: 0%;"></div>
										<p id="complexity${loop.index }">0%</p>
									</div>
                                </div>
                            </td>
                            <td class="text-center col-md-1"><a href="#"><span class="glyphicon glyphicon-edit"></span></a></td>
                            <td class="text-center col-md-1"><a href="#"><span class="glyphicon glyphicon-trash"></span></a></td>
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
                <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
                <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
                <li class=""><a href="#">2 <span class="sr-only"></span></a></li>
                <li class=""><a href="#">3 <span class="sr-only">(current)</span></a></li>
                <li class=""><a href="#">4 <span class="sr-only">(current)</span></a></li>
                <li class=""><a href="#">5 <span class="sr-only">(current)</span></a></li>
                <li class=""><a href="#" aria-label="Previous"><span aria-hidden="true">&raquo;</span></a></li>
              </ul>
        </nav>
    </div>
</div>
<!-- END CONTENT -->