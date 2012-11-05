
<%@ page import="com.blogspot.fwfaill.lunchbuddywebservice.Rating" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'rating.label', default: 'Rating')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-rating" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
			</ul>
		</div>
		<div id="list-rating" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="course" title="${message(code: 'rating.course.label', default: 'Course')}" />
					
						<g:sortableColumn property="restaurant" title="${message(code: 'rating.restaurant.label', default: 'Restaurant')}" />
					
						<g:sortableColumn property="goodRatings" title="${message(code: 'rating.goodRatings.label', default: 'Good Ratings')}" />

						<g:sortableColumn property="badRatings" title="${message(code: 'rating.badRatings.label', default: 'Bad Ratings')}" />
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'rating.dateCreated.label', default: 'Date Created')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${ratingInstanceList}" status="i" var="ratingInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${ratingInstance.id}">${fieldValue(bean: ratingInstance, field: "course")}</g:link></td>
					
						<td>${fieldValue(bean: ratingInstance, field: "restaurant")}</td>

						<td>${fieldValue(bean: ratingInstance, field: "goodRatings")}</td>
					
						<td>${fieldValue(bean: ratingInstance, field: "badRatings")}</td>
					
						<td><g:formatDate date="${ratingInstance.dateCreated}" format="d.M.yyyy" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${ratingInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
