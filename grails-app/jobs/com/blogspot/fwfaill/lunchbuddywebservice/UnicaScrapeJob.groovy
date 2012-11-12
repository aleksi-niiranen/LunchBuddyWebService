package com.blogspot.fwfaill.lunchbuddywebservice

import groovyx.net.http.*
import static groovyx.net.http.ContentType.*
import static groovyx.net.http.Method.*

class UnicaScrapeJob {
    static triggers = {
        cron name: 'scrapeTrigger', cronExpression: "0 30 2 ? * MON-FRI", timeZone: TimeZone.getTimeZone("Europe/Helsinki")
    }

    def execute() {
        // execute job
        def date = new GregorianCalendar(TimeZone.getTimeZone("Europe/Helsinki"), new Locale("Finnish", "Finland"))
        date.set Calendar.HOUR_OF_DAY, 0
        date.set Calendar.MINUTE, 0
        date.set Calendar.SECOND, 0
        date.set Calendar.MILLISECOND, 0
        def timestamp = date.timeInMillis / 1000

        def menus = Scraper.scrape timestamp
        
        menus.each { k,v ->
            v.each { course ->
                course.save(flush: true)
            }
        }

        def oldCourses = Course.findAllByTimestampLessThan timestamp
        oldCourses.each {
            it.delete()
        }

        // move to own job?
        def http = new HTTPBuilder('http://www.sodexo.fi')
        def year = date.get Calendar.YEAR
        def month = (date.get(Calendar.MONTH)) + 1
        def day = date.get Calendar.DATE

        // salo
        http.request(GET, JSON) {
            uri.path = "/ruokalistat/output/daily_json/459/${year}/${month}/${day}/fi"

            response.success = { resp, json ->
                def req_timestamp = json.meta.requested_timestamp

                json.courses.each {
                    def course = new Course(titleFi: it.title_fi, titleEn: it.title_en, limitations: it.properties, price: it.price, timestamp: req_timestamp, restaurant: "Aurinkolaiva").save()
                }
            }
        }
        // ict - talo
        http.request(GET, JSON) {
            uri.path = "/ruokalistat/output/daily_json/427/${year}/${month}/${day}/fi"

            response.success = { resp, json ->
                def req_timestamp = json.meta.requested_timestamp
                def refTitle = json.meta.ref_title

                json.courses.each {
                    def course = new Course(titleFi: it.title_fi, titleEn: it.title_en, limitations: it.properties, price: it.price, timestamp: req_timestamp, restaurant: refTitle).save()
                }
            }
        }
        // lemminkäisenkatu
        http.request(GET, JSON) {
            uri.path = "/ruokalistat/output/daily_json/442/${year}/${month}/${day}/fi"

            response.success = { resp, json ->
                def req_timestamp = json.meta.requested_timestamp
                def refTitle = json.meta.ref_title

                json.courses.each {
                    def course = new Course(titleFi: it.title_fi, titleEn: it.title_en, limitations: it.properties, price: it.price, timestamp: req_timestamp, restaurant: refTitle).save()
                }
            }
        }
        // eurocity
        http.request(GET, JSON) {
            uri.path = "/ruokalistat/output/daily_json/391/${year}/${month}/${day}/fi"

            response.success = { resp, json ->
                def req_timestamp = json.meta.requested_timestamp
                def refTitle = json.meta.ref_title

                json.courses.each {
                    def course = new Course(titleFi: it.title_fi, titleEn: it.title_en, limitations: it.properties, price: it.price, timestamp: req_timestamp, restaurant: refTitle).save()
                }
            }
        }
        // old mill
        http.request(GET, JSON) {
            uri.path = "/ruokalistat/output/daily_json/451/${year}/${month}/${day}/fi"

            response.success = { resp, json ->
                def req_timestamp = json.meta.requested_timestamp
                def refTitle = json.meta.ref_title

                json.courses.each {
                    def course = new Course(titleFi: it.title_fi, titleEn: it.title_en, limitations: it.properties, price: it.price, timestamp: req_timestamp, restaurant: refTitle).save()
                }
            }
        }
    }
}
