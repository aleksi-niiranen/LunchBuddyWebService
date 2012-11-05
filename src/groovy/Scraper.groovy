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
                def refTitle = result.child(0).html().decodeHTML()
                def courses = result.select "li"
                courses.each { e ->
                    try {
                        def title = e.child(0).html().decodeHTML()
                        def properties = [] as Set
                        def limitations = e.child(1).select("span > *").each {
                            properties << it.html()
                        }
                        def priceStr = e.child(3).html()
                        def price = priceStr.substring 7, priceStr.length() - 2
                        def course = new Course(timestamp: timestamp, restaurant: refTitle, titleFi: title, 
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
                    if (v == 3 && v == 4) println "${k} / ${e}"
                    if (!e.child(0).attr("class").equals("alert")) {
                        def title = e.child(0).html().decodeHTML()
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
