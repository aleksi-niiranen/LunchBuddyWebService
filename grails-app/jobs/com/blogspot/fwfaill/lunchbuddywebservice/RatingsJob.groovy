package com.blogspot.fwfaill.lunchbuddywebservice



class RatingsJob {
    static triggers = {
        cron name: 'ratingsTrigger', cronExpression: "0 0 21 ? * MON-FRI"
    }

    def execute() {
        // execute job
        def courses = Course.withCriteria {
            or {
                gt 'goodRatings', 0
                gt 'badRatings', 0
            }
        }

        courses.each {
            def rating = new Rating(course: it.titleFi, restaurant: it.restaurant, goodRatings: it.goodRatings, badRatings: it.badRatings).save(flush: true)
        }
    }
}
