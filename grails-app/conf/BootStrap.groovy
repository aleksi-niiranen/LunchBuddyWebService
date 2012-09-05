import com.blogspot.fwfaill.lunchbuddywebservice.Menu
import com.blogspot.fwfaill.lunchbuddywebservice.Course
import grails.converters.JSON

class BootStrap {

    def init = { servletContext ->
        // JSON marshallers
        JSON.registerObjectMarshaller(Menu) {
            def json = [:]
            json.timestamp = it.timestamp
            json.courses = it.courses
            return json
        }

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
