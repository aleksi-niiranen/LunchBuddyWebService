package com.blogspot.fwfaill.lunchbuddywebservice

class CourseController {

    static allowedMethods = [rate: 'PUT']

    def rate() {
        def id = params.id
        def rating = params.rating

        def course = Course.get id
        if (rating == "good")
            course.goodRatings++
        else if (rating == "bad")
            course.badRatings++

        course.save(flush: true)

        render "success"
    }
}
