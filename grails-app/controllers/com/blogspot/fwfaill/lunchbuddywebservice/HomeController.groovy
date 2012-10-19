package com.blogspot.fwfaill.lunchbuddywebservice

class HomeController {

    def index() { }

    def countCourses() {
        def coursesCount = Course.list().size()

        render "courses list size: ${coursesCount}"
    }
}
