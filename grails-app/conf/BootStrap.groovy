import com.blogspot.fwfaill.lunchbuddywebservice.Menu
import com.blogspot.fwfaill.lunchbuddywebservice.Course
import grails.converters.JSON

class BootStrap {

    def init = { servletContext ->
        // JSON marshallers
        JSON.registerObjectMarshaller(Course) {
            def json = [:]
            json.title_fi = it.titleFi.encodeAsHTML()
            json.title_en = it.titleEn.encodeAsHTML()
            json.properties = it.limitations
            json.price = it.price
            return json
        }
    }
    def destroy = {
    }
}
