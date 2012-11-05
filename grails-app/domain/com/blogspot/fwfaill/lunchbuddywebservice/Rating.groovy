package com.blogspot.fwfaill.lunchbuddywebservice

import org.bson.types.ObjectId

class Rating {

    ObjectId id
    String course
    String restaurant
    int goodRatings
    int badRatings
    Date dateCreated

    static mapWith = "mongo"

    static constraints = {
        course blank: false
        restaurant blank: false
    }
}
