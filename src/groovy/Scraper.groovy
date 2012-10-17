package com.blogspot.fwfaill.lunchbuddywebservice

import org.jsoup.nodes.Document
import org.jsoup.Jsoup

class Scraper {

    static final def indexes = [Assari:1, Brygge:2, Delica:3, DeliPharma:4, Dental:5, Macciavelli:6, Mikro:7, Nutritio:8, Parkkis:9, Myssy:13]

    static def scrape(timestamp) {
        Document doc_fi = Jsoup.connect("http://www.unica.fi/fi/").get()
        Document doc_en = Jsoup.connect("http://www.unica.fi/en/").get()

        def menuMapEn = parseEn doc_en

        def menuMap = [:]
        indexes.each { k,v ->
            def menu = []
            try {
                def result = doc_fi.select("#menu-wrap ul").get(v)
                def refTitle = result.child(0).html()
                def courses = result.select "li"
                courses.each { e ->
                    try {
                        def title = e.child(0).html()
                        def properties = []
                        def limitations = e.child(1).select(".G, .L, .M, .VL, .VEG").each {
                            properties << it.html()
                        }
                        def price = e.child(3).html().substring 7
                        def course = new Course(timestamp: timestamp, refTitle: refTitle, titleFi: title, 
                                price: price, limitations: properties.join(" "))
                        menu << course
                    } catch (Exception ex) {
                        // Catches exceptions that are thrown if menu contains entries that are not courses.
                    }
                }
                menuMap[k] = menu
            }catch (IndexOutOfBoundsException e) {
                // consume exception. caused by no courses being served this day.
            }

            def length = menu.size - 1
            (0..length).each { i ->
                menuMap[k][i].titleEn = menuMapEn[k][i]
            }
        }
        
                
        return menuMap
    }
    
    static def parseEn(Document doc) {
        def menuMap = [:]
        indexes.each { k,v ->
            try {
                def menu = []
                def result = doc.select("#menu-wrap ul").get(v);
                def courses = result.select "li";
                courses.each { e ->
                    if (!e.child(0).attr("class").equals("alert")) {
                        def title = e.child(0).html()
                        menu << title
                    }
                }
                menuMap[k] = menu
            } catch (IndexOutOfBoundsException e) {
                // consume exception. caused by no courses being served this day.
            }
        }
        return  menuMap
    }
}
