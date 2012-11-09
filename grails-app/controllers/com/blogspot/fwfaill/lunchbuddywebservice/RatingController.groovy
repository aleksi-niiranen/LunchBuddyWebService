package com.blogspot.fwfaill.lunchbuddywebservice

import org.springframework.dao.DataIntegrityViolationException
import grails.plugins.springsecurity.Secured

class RatingController {

    static allowedMethods = [delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        def dates
        if (!params.dates) {
            dates = new Date() - 1
        } else if (params.dates == 'lastweek') {
            dates = new Date() - 7
        }
        def ratingList = Rating.withCriteria {
            def now = new Date()
            between('dateCreated', dates, now)
        }
        [ratingInstanceList: ratingList, ratingInstanceTotal: ratingList.size()]
        //params.max = Math.min(params.max ? params.int('max') : 10, 100)
        //[ratingInstanceList: Rating.list(params), ratingInstanceTotal: Rating.count()]
    }

    def show() {
        def ratingInstance = Rating.get(params.id)
        if (!ratingInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'rating.label', default: 'Rating'), params.id])
            redirect(action: "list")
            return
        }

        [ratingInstance: ratingInstance]
    }

    @Secured(['ROLE_ADMIN'])
    def delete() {
        def ratingInstance = Rating.get(params.id)
        if (!ratingInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'rating.label', default: 'Rating'), params.id])
            redirect action: "list"
            return
        }

        try {
            ratingInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'rating.label', default: 'Rating'), params.id])
            redirect action: "list"
        } catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'rating.label', default: 'Rating'), params.id])
            redirect action: "show", id: params.id
        }
    }
}
