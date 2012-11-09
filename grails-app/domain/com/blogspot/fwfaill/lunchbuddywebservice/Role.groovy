package com.blogspot.fwfaill.lunchbuddywebservice

class Role {

	String authority

	static mapping = {
		cache true
	}

	static constraints = {
		authority blank: false, unique: true
	}
}
