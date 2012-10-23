package com.blogspot.fwfaill.lunchbuddywebservice



class UnicaScrapeJob {
    static triggers = {
        cron name: 'scrapeTrigger', cronExpression: "0 30 1 ? * MON-FRI"
    }

    def execute() {
        // execute job
        def date = new GregorianCalendar(TimeZone.getTimeZone("Europe/Helsinki"), new Locale("Finnish", "Finland"))
        date.set Calendar.HOUR_OF_DAY, 0
        date.set Calendar.MINUTE, 0
        date.set Calendar.SECOND, 0
        date.set Calendar.MILLISECOND, 0

        def menus = Scraper.scrape date.timeInMillis / 1000
        
        menus.each { k,v ->
            v.each { course ->
                course.save(flush: true)
            }
        }
    }
}
