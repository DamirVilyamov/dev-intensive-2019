package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

fun User.toUserView(): UserView {
    val nickname = Utils.transliteration("$firstName $lastname")
    val initials = Utils.toInitials(firstName, lastname)
    val status =
        if (lastVisit == null) "Ещё ни разу не был" else if (isOnline) "online" else "Послелний раз был ${lastVisit.humanizeDiff()}"
    return UserView(
        id,
        fullName = "$firstName $lastname",
        nickName = nickname,
        initials = initials,
        avatar = avatar,
        status = status
    )
}



