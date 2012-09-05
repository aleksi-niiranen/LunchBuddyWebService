package com.blogspot.fwfaill.lunchbuddywebservice

import org.jsoup.nodes.Document
import org.jsoup.Jsoup

class Scraper {

    static Map WEEKDAYS = [0:"Maanantai", 1:"Tiistai", 2:"Keskiviikko", 3:"Torstai", 4:"Perjantai"]

    static Map scrape() {
        Document doc_fi = Jsoup.connect("http://www.unica.fi/fi/ravintolat/nutritio/").get()
        Document doc_en = Jsoup.connect("http://www.unica.fi/en/restaurants/nutritio/").get()

        def menuListEn = [:]
        def resultEn = doc_en.select(".menu-list div")
        resultEn.each {
            def courses = []
            def weekday =  WEEKDAYS[it.child(0).attr("data-dayofweek").toInteger()]
            def tableRows = it.select("table tr")
            tableRows.each { row ->
                courses << row.child(0).html()
            }
            menuListEn[weekday] = courses
        }

        def menuListFi = [:]
        def resultFi = doc_fi.select(".menu-list div")
        resultFi.each {
            def courses = []
            def weekday =  WEEKDAYS[it.child(0).attr("data-dayofweek").toInteger()]
            def tableRows = it.select("table tr")
            tableRows.each { row ->
                def course = [:]
                course.title_fi = row.child(0).html()
                def props = []
                row.child(1).select("span").each { limitation ->
                    props << limitation.html()
                }
                course.properties = props.join(" ")
                course.price = row.child(2).html().substring(7)
                courses << course
            }
            menuListFi[weekday] = courses
        }

        for(int i = 0; i < 5; i++) {
            def weekday = WEEKDAYS[i]
            for(int j = 0; j < menuListFi[weekday].size(); j++) {
                menuListFi[weekday][j].title_en = menuListEn[weekday][j]
            }
        }
        
        return menuListFi
    }
}
