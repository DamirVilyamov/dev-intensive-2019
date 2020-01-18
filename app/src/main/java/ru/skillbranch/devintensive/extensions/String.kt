package ru.skillbranch.devintensive.extensions

fun String.truncate(i: Int = 16): String {
    var index = i
    if (this.length > 16) {
        var truncated = this.substring(0, index - 1)
        index--
        while (truncated[index - 1] == ' ') {
            truncated = truncated.substring(0, index - 1)
            index--
        }
        return "$truncated..."
    }
    return this
}