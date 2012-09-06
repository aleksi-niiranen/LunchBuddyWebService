package com.blogspot.fwfaill.lunchbuddywebservice

class ScrapeController {

    def scrape = {
        //def menu = Scraper.scrape()

        //for(int i = 0; i < 5; i++) {
        //    def newMenu = new Menu(timestamp:50000).save(flush:true)
        //    menu[Scraper.WEEKDAYS[i]].each {
        //        def course = new Course(titleFi:it.title_fi, titleEn:it.title_en, limitations:it.properties, price:it.price, menu:newMenu).save(flush:true)
        //    }
        //}

        def c = new GregorianCalendar(TimeZone.getTimeZone("Europe/Helsinki"), new Locale("Finnish", "Finland"))
        c.set(Calendar.HOUR_OF_DAY, 0)
        c.set(Calendar.MINUTE, 0)
        c.set(Calendar.SECOND, 0)
        c.set(Calendar.MILLISECOND, 0)

        render "time: ${c.time}\n timeInSeconds: ${c.timeInMillis / 1000}"
    }
}
