package com.blogspot.fwfaill.lunchbuddywebservice

import org.bson.types.ObjectId

class Rating {

    ObjectId id
    String course
    String comment
    Date dateCreated

    static mapWith = "mongo"

    static constraints = {
        course blank: false
        comment blank: true
    }
}
