package com.blogspot.fwfaill.lunchbuddywebservice

class Course {

    String titleFi
    String titleEn
    String limitations
    String price
    String refTitle
    long timestamp

    static constraints = {
        timestamp blank: false
        refTitle blank: false
        titleFi blank: true
        titleEn blank: true
        limitations blank: true
        price blank: true
    }
}
