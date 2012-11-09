
<%@ page import="com.blogspot.fwfaill.lunchbuddywebservice.Rating" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'rating.label', default: 'Rating')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-rating" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-rating" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list rating">
			
				<g:if test="${ratingInstance?.course}">
				<li class="fieldcontain">
					<span id="course-label" class="property-label"><g:message code="rating.course.label" default="Course" /></span>
					
						<span class="property-value" aria-labelledby="course-label"><g:fieldValue bean="${ratingInstance}" field="course"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ratingInstance?.restaurant}">
				<li class="fieldcontain">
					<span id="restaurant-label" class="property-label"><g:message code="rating.restaurant.label" default="Restaurant" /></span>
					
						<span class="property-value" aria-labelledby="restaurant-label"><g:fieldValue bean="${ratingInstance}" field="restaurant"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ratingInstance?.badRatings}">
				<li class="fieldcontain">
					<span id="badRatings-label" class="property-label"><g:message code="rating.badRatings.label" default="Bad Ratings" /></span>
					
						<span class="property-value" aria-labelledby="badRatings-label"><g:fieldValue bean="${ratingInstance}" field="badRatings"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ratingInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="rating.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${ratingInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${ratingInstance?.goodRatings}">
				<li class="fieldcontain">
					<span id="goodRatings-label" class="property-label"><g:message code="rating.goodRatings.label" default="Good Ratings" /></span>
					
						<span class="property-value" aria-labelledby="goodRatings-label"><g:fieldValue bean="${ratingInstance}" field="goodRatings"/></span>
					
				</li>
				</g:if>
			
			</ol>
            <sec:ifAllGranted roles="ROLE_ADMIN">
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${ratingInstance?.id}" />
                    <g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" />
				</fieldset>
			</g:form>
            </sec:ifAllGranted>
		</div>
	</body>
</html>
