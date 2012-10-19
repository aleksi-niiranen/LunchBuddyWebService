class UrlMappings {

	static mappings = {
        "/daily_json/$reftitle/$year/$month/$day"{
            controller = "dailyJson"
            action = "get"
        }

        "/courses/$timestamp" {
            controller = "dailyJson"
            action = "get2"
        }

        "/coursescount"(controller: "home", action: "countCourses")

		"/"(controller: "home", action:"index")
		"500"(view:'/error')
	}
}
