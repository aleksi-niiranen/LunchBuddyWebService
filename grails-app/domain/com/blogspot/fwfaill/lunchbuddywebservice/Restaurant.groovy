package com.blogspot.fwfaill.lunchbuddywebservice

class Restaurant {

    String refTitle
    int monthlyRequests = 0
    String location

    static constraints = {
        refTitle blank: false
        location blank: false
    }
}
