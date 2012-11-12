package com.blogspot.fwfaill.lunchbuddywebservice

class Course {

    String titleFi
    String titleEn
    String titleSe
    String limitations
    String price
    String restaurant
    long timestamp
    int goodRatings = 0
    int badRatings = 0

    static constraints = {
        timestamp blank: false
        restaurant blank: false
        titleFi blank: true
        titleEn blank: true, nullable: true
        titleSe blank: true, nullable: true
        limitations blank: true, nullable: true
        price blank: true, nullable: true
    }

    String toString() {
        "titleFi: ${titleFi}, titleEn: ${titleEn}, limitations: ${limitations}, price: ${price}, restaurant: ${restaurant}, timestamp: ${timestamp}"
    }
}
