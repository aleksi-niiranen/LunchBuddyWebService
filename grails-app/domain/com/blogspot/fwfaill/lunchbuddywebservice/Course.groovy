package com.blogspot.fwfaill.lunchbuddywebservice

class Course {

    String titleFi
    String titleEn
    String limitations
    String price
    String restaurant
    long timestamp

    static constraints = {
        timestamp blank: false
        restaurant blank: false
        titleFi blank: true
        titleEn blank: true
        limitations blank: true
        price blank: true
    }
}
