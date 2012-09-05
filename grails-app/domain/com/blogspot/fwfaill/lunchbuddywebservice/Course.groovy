package com.blogspot.fwfaill.lunchbuddywebservice

class Course {

    String titleFi
    String titleEn
    String limitations
    String price

    static constraints = {
    }

    static belongsTo = [menu:Menu]
}
