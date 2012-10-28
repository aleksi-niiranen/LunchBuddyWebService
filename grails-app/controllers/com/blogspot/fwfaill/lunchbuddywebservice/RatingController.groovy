package com.blogspot.fwfaill.lunchbuddywebservice

class RatingController {

    def scaffold = true

    def rate() {
        def course = params.course
        def comment = params.comment ?: ""

        def rating = new Rating(course: course, comment: comment)

        if (!rating.save(flush: true)) {
            render rating.errors
            return
        }
        
        redirect action: "show", id: rating.id
    }
}
