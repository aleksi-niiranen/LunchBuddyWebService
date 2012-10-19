package com.blogspot.fwfaill.lunchbuddywebservice

import grails.converters.JSON

class DailyJsonController {

    def get() {
        def restaurant = params.restaurant
        def date = new GregorianCalendar(TimeZone.getTimeZone("Europe/Helsinki"), new Locale("Finnish", "Finland"))
        date.set Calendar.HOUR_OF_DAY, 0
        date.set Calendar.MINUTE, 0
        date.set Calendar.SECOND, 0
        date.set Calendar.MILLISECOND, 0
        date.set Calendar.YEAR, params.year.toInteger()
        date.set Calendar.MONTH, --params.month.toInteger() // month is zero based
        date.set Calendar.DATE, params.day.toInteger()
        def timestamp = date.timeInMillis / 1000

        def courses = Course.findAllByRestaurantAndTimestamp(restaurant, timestamp)

        render(contentType: "text/json") {
            def meta = [requested_timestamp: timestamp, ref_title: restaurant]
            [meta: meta, courses: courses]
        }
    }
}
