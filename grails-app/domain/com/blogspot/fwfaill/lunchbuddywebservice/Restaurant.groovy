package com.blogspot.fwfaill.lunchbuddywebservice

class Restaurant {

    String refTitle
    int totalRequests = 0
    int monthlyRequests = 0
    int weeklyRequests = 0
    int dailyRequests = 0

    static constraints = {
        refTitle blank: false
    }
}
