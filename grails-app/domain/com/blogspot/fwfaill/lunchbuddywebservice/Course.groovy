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
        titleEn blank: true, nullable: true
        limitations blank: true
        price blank: true
    }

    String toString() {
        "titleFi: ${titleFi}, titleEn: ${titleEn}, limitations: ${limitations}, price: ${price}, restaurant: ${restaurant}, timestamp: ${timestamp}"
    }
}
