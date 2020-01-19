package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class User(
    val id: String,
    var firstName: String?,
    internal var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    val lastVisit: Date? = null,
    val isOnline: Boolean = false

) {

    constructor(id: String, firstname: String?, lastname: String?) : this(
        id = id,
        firstName = firstname,
        lastName = lastname,
        avatar = null
    )

    constructor(id: String) : this(id, "John", "Doe")

    init {
        println(
            "It's alive!!!\n" +
                    "${if (lastName === "Doe") "His name is: $firstName $lastName" else "And his name is $firstName $lastName"}\n"
        )
    }


    companion object Factory {
        private var lastid: Int = -1
        fun makeUser(fullName: String?): User {
            lastid++
            val (firstName, lastName) = Utils.parseFullName(fullName)
            return User(id = "$lastid", firstname = firstName, lastname = lastName)

        }
    }


}


