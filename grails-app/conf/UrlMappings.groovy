class UrlMappings {

	static mappings = {
        "/daily_json/$restaurant/$year/$month/$day"{
            controller = "dailyJson"
            action = "get"
        }

        "/$controller/$action?/$id?" { }

		"/"(controller: "home", action:"index")
		"500"(view:'/error')
	}
}
