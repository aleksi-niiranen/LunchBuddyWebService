import com.blogspot.fwfaill.lunchbuddywebservice.Course
import com.blogspot.fwfaill.lunchbuddywebservice.Restaurant
import grails.converters.JSON

class BootStrap {

    def init = { servletContext ->
        // Restaurants
        def restaurant = Restaurant.findByRefTitle("Aurinkolaiva") ?: new Restaurant(refTitle: "Aurinkolaiva").save(flush: true)
        restaurant = Restaurant.findByRefTitle("ICT - talo") ?: new Restaurant(refTitle: "ICT - talo").save(flush: true)
        restaurant = Restaurant.findByRefTitle("Lemminkäisenkatu") ?: new Restaurant(refTitle: "Lemminkäisenkatu").save(flush: true)
        restaurant = Restaurant.findByRefTitle("Nutritio") ?: new Restaurant(refTitle: "Nutritio").save(flush: true)
        restaurant = Restaurant.findByRefTitle("Assarin ullakko") ?: new Restaurant(refTitle: "Assarin ullakko").save(flush: true)
        restaurant = Restaurant.findByRefTitle("Brygge") ?: new Restaurant(refTitle: "Brygge").save(flush: true)
        restaurant = Restaurant.findByRefTitle("Delica") ?: new Restaurant(refTitle: "Delica").save(flush: true)
        restaurant = Restaurant.findByRefTitle("Deli Pharma") ?: new Restaurant(refTitle: "Deli Pharma").save(flush: true)
        restaurant = Restaurant.findByRefTitle("Dental") ?: new Restaurant(refTitle: "Dental").save(flush: true)
        restaurant = Restaurant.findByRefTitle("Macciavelli") ?: new Restaurant(refTitle: "Macciavelli").save(flush: true)
        restaurant = Restaurant.findByRefTitle("Mikro") ?: new Restaurant(refTitle: "Mikro").save(flush: true)
        restaurant = Restaurant.findByRefTitle("Parkkis") ?: new Restaurant(refTitle: "Parkkis").save(flush: true)
        restaurant = Restaurant.findByRefTitle("Myssy & Silinteri") ?: new Restaurant(refTitle: "Myssy & Silinteri").save(flush: true)

        // JSON marshallers
        JSON.registerObjectMarshaller(Course) {
            def json = [:]
            json.title_fi = it.titleFi
            json.title_en = it.titleEn
            json.properties = it.limitations
            json.price = it.price
            return json
        }
    }
    def destroy = {
    }
}
