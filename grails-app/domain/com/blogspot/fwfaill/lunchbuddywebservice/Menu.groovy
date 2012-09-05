package com.blogspot.fwfaill.lunchbuddywebservice

class Menu {

    long timestamp

    static constraints = {
    }

    static hasMany = [courses:Course]
}
