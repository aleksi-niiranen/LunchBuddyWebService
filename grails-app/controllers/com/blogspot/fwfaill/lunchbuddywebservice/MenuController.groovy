package com.blogspot.fwfaill.lunchbuddywebservice

import grails.converters.JSON

class MenuController {

    def scaffold = Menu

    def json() {
        def json = [:]
        def menu = Menu.get(params.id)
        if (!menu) {
            json.message = "menu for id: ${params.id} not found"
            render json as JSON
            return
        }
        render menu as JSON
    }
}
