import com.blogspot.fwfaill.lunchbuddywebservice.User
import com.blogspot.fwfaill.lunchbuddywebservice.Role
import com.blogspot.fwfaill.lunchbuddywebservice.UserRole
import com.blogspot.fwfaill.lunchbuddywebservice.Course
import com.blogspot.fwfaill.lunchbuddywebservice.Restaurant
import grails.converters.JSON

class BootStrap {

    def init = { servletContext ->
        def adminRole = Role.findByAuthority('ROLE_ADMIN') ?: new Role(authority: 'ROLE_ADMIN').save(failOnError: true)
        def admin = User.findByUsername('admin') ?: new User(username: 'admin', enabled: true, password: 'LunchBuddyAdminSecretPassword').save(failOnError: true)
        if (!admin.authorities.contains(adminRole)) {
            UserRole.create admin, adminRole, true
        }
        // Restaurants
        def restaurant = Restaurant.findByRefTitle("Aurinkolaiva") ?: new Restaurant(refTitle: "Aurinkolaiva").save(failOnError: true)
        restaurant = Restaurant.findByRefTitle("ICT - talo") ?: new Restaurant(refTitle: "ICT - talo").save(failOnError: true)
        restaurant = Restaurant.findByRefTitle("Lemminkäisenkatu") ?: new Restaurant(refTitle: "Lemminkäisenkatu").save(failOnError: true)
        restaurant = Restaurant.findByRefTitle("Nutritio") ?: new Restaurant(refTitle: "Nutritio").save(failOnError: true)
        restaurant = Restaurant.findByRefTitle("Assarin ullakko") ?: new Restaurant(refTitle: "Assarin ullakko").save(failOnError: true)
        restaurant = Restaurant.findByRefTitle("Brygge") ?: new Restaurant(refTitle: "Brygge").save(failOnError: true)
        restaurant = Restaurant.findByRefTitle("Delica") ?: new Restaurant(refTitle: "Delica").save(failOnError: true)
        restaurant = Restaurant.findByRefTitle("Deli Pharma") ?: new Restaurant(refTitle: "Deli Pharma").save(failOnError: true)
        restaurant = Restaurant.findByRefTitle("Dental") ?: new Restaurant(refTitle: "Dental").save(failOnError: true)
        restaurant = Restaurant.findByRefTitle("Macciavelli") ?: new Restaurant(refTitle: "Macciavelli").save(failOnError: true)
        restaurant = Restaurant.findByRefTitle("Mikro") ?: new Restaurant(refTitle: "Mikro").save(failOnError: true)
        restaurant = Restaurant.findByRefTitle("Parkkis") ?: new Restaurant(refTitle: "Parkkis").save(failOnError: true)
        restaurant = Restaurant.findByRefTitle("Ruokakello") ?: new Restaurant(refTitle: "Ruokakello").save(failOnError: true)
        restaurant = Restaurant.findByRefTitle("Tottisalmi") ?: new Restaurant(refTitle: "Tottisalmi").save(failOnError: true)
        restaurant = Restaurant.findByRefTitle("Arcanum") ?: new Restaurant(refTitle: "Arcanum").save(failOnError: true)
        restaurant = Restaurant.findByRefTitle("Myssy & Silinteri") ?: new Restaurant(refTitle: "Myssy & Silinteri").save(failOnError: true)
        restaurant = Restaurant.findByRefTitle("EuroCity") ?: new Restaurant(refTitle: "EuroCity").save(failOnError: true)
        restaurant = Restaurant.findByRefTitle("Old Mill") ?: new Restaurant(refTitle: "Old Mill").save(failOnError: true)

        // JSON marshallers
        JSON.registerObjectMarshaller(Course) {
            def json = [:]
            json.id = it.id
            json.title_fi = it.titleFi
            json.title_en = it.titleEn
            json.title_se = it.titleSe
            json.properties = it.limitations
            json.price = it.price
            return json
        }
    }
    def destroy = {
    }
}
