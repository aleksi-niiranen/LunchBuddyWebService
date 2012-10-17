class UrlMappings {

	static mappings = {
        "/daily_json/$reftitle/$year/$month/$day"{
            controller = "dailyJson"
            action = "get"
        }

		"/"(controller: "home", action:"index")
		"500"(view:'/error')
	}
}
