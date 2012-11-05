<%@ page import="com.blogspot.fwfaill.lunchbuddywebservice.Rating" %>



<div class="fieldcontain ${hasErrors(bean: ratingInstance, field: 'course', 'error')} required">
	<label for="course">
		<g:message code="rating.course.label" default="Course" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="course" required="" value="${ratingInstance?.course}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ratingInstance, field: 'restaurant', 'error')} required">
	<label for="restaurant">
		<g:message code="rating.restaurant.label" default="Restaurant" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="restaurant" required="" value="${ratingInstance?.restaurant}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ratingInstance, field: 'badRatings', 'error')} required">
	<label for="badRatings">
		<g:message code="rating.badRatings.label" default="Bad Ratings" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="badRatings" required="" value="${ratingInstance.badRatings}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ratingInstance, field: 'goodRatings', 'error')} required">
	<label for="goodRatings">
		<g:message code="rating.goodRatings.label" default="Good Ratings" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="goodRatings" required="" value="${ratingInstance.goodRatings}"/>
</div>

