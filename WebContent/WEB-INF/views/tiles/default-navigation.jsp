<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/tiles/tablib.jsp" %>

<script>
	function setLanguage(language) {
		$.ajax({
			type: "get",
			url: "${pageContext.request.contextPath}/changelanguage",
			data: {
				lang: language
			}
		}).done(function() {
			location.reload();
		}).fail(function() {
			setLanguage("ja");
		})
	}
</script>

<!-- BEGIN NAVBAR -->
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/login"><s:message code="banana.navbar.name"></s:message></a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="" onclick="setLanguage('ja'); return false;"><img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABcAAAARCAYAAAA2cze9AAACoElEQVQ4T6WUS0xTQRSG/8t9wG0x8oxCIgjRBI0bSIW2FCgpWF6lEXe6caFbF7qT6EKNbowbd8aFG91BLChQoaGFtpRXiAuVxAiCIWh4FIXb0s691ExviIq3G3qSyZnM+c83Z2YyhwHAHBhI0xIAkoOCM5a+rTzc3fl1KyJJHBKJZIQGqO3PqafGgAFVUK/G1XnSMwx0er2cpct+XFp6opsq2E8fPkaLiov4ozk5aRYN/NzawurKKjlz7qxI4dxUMEQqzxvSBu8D5qanUW028Un4hN9PqqprUsKVWAxEiiAhy2A4DrxeBzYzM6V+dnIS5jqLCvd7fcRgNGqKKXipz435F68gra1BX1iIiquXUdppT7nBTCgEi7VBhY95RonBbNKEL/a+wdyDJzDm1yJfyMdGfAOhzQAqu2+irKtDM2cmOIF6W6MKHx0eIdXmWk1hv82Jyugp5GyyUKJRsKKIcJ6M9+IXdHhcmjlTwQAam5tU+MjQMKmxaMNfVlThgmRAVJZA9uLgMwSInB7v9LO4Mj+rDfcHYGtpVuHugSFitNRpV25tRclnDgyJI67EIbACEryA5dMyHN5BzZzQ+Djs7S0qfLB/gJjqteE/PF54rt1A8U42eCUBwjJYyd5G0/OnOGazasInxsbR6mhT4W9d/cRU36Ap5DkW3z2j8N+5h/DCV+SWn4Tl/l0ctzWCyEoKuA/tTocK7+t1EbNVrYIuHPz+As9BzMoEy2ZAUfYQ2Y1BJnKK9gAEfF50XnSqcFcPhWtXfphvG/T64Lykwln3gHutpKw8N6+g4DCsf3I219exvLgQtrfZC5Ndsed13/UslnsUlaTcZE/8+17+2+7gxf0R0K4o6nTh2J5yu8vpeLbfywUAR+gp0i4doK+8DSD+G+Z6+kpXDi8NAAAAAElFTkSuQmCC" alt="JA"></a></li>
				<li><a href="" onclick="setLanguage('en'); return false;"><img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABcAAAARCAYAAAA2cze9AAADqUlEQVQ4T6WUDVBUVRTHf49ll1U+tjXKCmrSSEtRKz+iIHExdMrSzTIYFWREC6EYcAmn7GPKsUZRSAYZTEwEKVenULJsAhcwUzGzAjVq0GaMPhjAlWVlZR/wmrdPnvIR04xn5s55971zf/e+c/73CIAwYHCTJgGeIYO94l4tMPv4BhQKgmCUJAlBEJC9YnKI/Cz7wSYIIIfKXrZeSbJf7WxPLM1ddUB+pYlbXdzy4Z8/Gv03ZXJB9ObrbxuxO1wq6e2UWbRNfFad33r2C97bWq3ORxlGMDcihLHabhwZG0kLeti+Ozv+NhnuHZOyQ8y+cAzvZjv65MXo481U1Z6n4rtG3GIPOa/P4+K42erx7vm1kvQPvkSn1TAn/H4iZ4zBXXIAV/4niKONWO4Lx5q3XOuBm1duE/fkJuAs+oyr+aVoHwjBf2MmHQEB7K84R8LCqfwxPko9aXDDYXaVncYcPQE/RzvOzCzEhkb0yUvwS3ie2NSd7N+epMCfWpYnmiIm8+LTkxjl7qT9rWw0Z8+jX7WYEfHPefLf9ODsa7mH4F9sno1cxWV0FXxKz8SxGNZZuKQbyd6v6qk6WsehXa8o8KjYHLF8R7KnbEMWDWiaYFKLGnTOppZ5qJLPT8zHtiddgUcszBKtZypuUESfOq5vd9nlUBVh0BsGKKh/fExoNEc/f02BT5+3XtxZV/6f8h4sz/6hfdKVvWzLpyzg5ME3FPjk6HfFzbWFN6wYqG2JQL/b1Zy3Olv7nXxg9OpHE6mreEeBj5/5plhpzRj2YrZMNSl3CQj8oUpN0VCLomM301CzToGPCVsjRkZO46WYGYy+chlp/Ra8mv6mJ2ERmpgFnvVt0+WCXoN/X42ERK+1HE3RXnqD74K1qTT73sJH1pPU1Jzi9xMbFHjQIxbRZs1AKCjG6+A3dE4ah89aC5fQUrjvFGtWzsQedl3nxhM2Nmw/wopF0zBKbtzvZzOy/jd6n4lGSlqGKSaLv05nK/DA0FTxmG8TXe12utNeRmOKZN+hekrLf8LV1U1lUSKO8CiliQCG41U8mfAxeh9vls5/iBfmhtJbU4MmZxs+BiOPXwmm9UyuB67xC0lqsU3pMeos6dRe7CCv5DhNzQ41DdUlK3A+IV9/5ZXfkcPMilMEIO939x0BpCx9jLB7/XFvyiHqZ43d2Vjg6S1e2jvNS9AFbhEQjGqL6+uKg5ri8F1SQrLT1ZYm/lO2u6+X6wB/+S+Glcz/+9gDdADufwEMD2NZsoIjhwAAAABJRU5ErkJggg==" alt="EN"></a></li>
				<c:if test="${empty sessionScope.user}">
					<li><a href="${pageContext.request.contextPath }/login"><s:message code="banana.login.page.title"></s:message></a></li>
					<li><a href="${pageContext.request.contextPath }/register"><s:message code="banana.register.page.title"></s:message></a></li>
				</c:if>
				<c:if test="${not empty sessionScope.user}">
					<li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${sessionScope.user.email }<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath }/changepassword"><s:message code="banana.navbar.changepassword"></s:message></a></li>
                            <li><a href="${pageContext.request.contextPath }/logout"><s:message code="banana.navbar.logout"></s:message></a></li>
                        </ul>
                    </li>
				</c:if>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>
<!-- END NAVBAR -->