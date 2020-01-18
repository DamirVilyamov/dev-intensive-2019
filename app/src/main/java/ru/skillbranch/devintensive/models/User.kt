package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class User(
    val id: String,
    var firstname: String?,
    var lastname: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    val lastVisit: Date? = null,
    val isOnline: Boolean = false

) {

    constructor(id: String, firstname: String?, lastname: String?) : this(
        id = id,
        firstname = firstname,
        lastname = lastname,
        avatar = null
    )

    constructor(id: String) : this(id, "John", "Doe")

    init {
        println(
            "It's alive!!!\n" +
                    "${if (lastname === "Doe") "His name is: $firstname $lastname" else "And his name is $firstname $lastname"}\n"
        )
    }


    companion object Factory {
        private var lastid: Int = -1
        fun makeUser(fullname: String?): User {
            lastid++
            val (firstName, lastName) = Utils.parseFullName(fullname)
            return User(id = "$lastid", firstname = firstName, lastname = lastName)

        }
    }


}


