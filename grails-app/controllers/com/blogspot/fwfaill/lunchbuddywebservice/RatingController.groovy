package com.blogspot.fwfaill.lunchbuddywebservice

class RatingController {

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [ratingInstanceList: Rating.list(params), ratingInstanceTotal: Rating.count()]
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
}
