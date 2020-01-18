package ru.skillbranch.devintensive.utils

import java.util.*

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")
        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
        return Pair(firstName, lastName)
    }

    fun transliteration(payload: String): String {
        var i = 0
        var result = ""
        val alphabet = mapOf(
            'а' to "a",
            'б' to "b",
            'в' to "v",
            'г' to "g",
            'д' to "d",
            'е' to "e",
            'ё' to "e",
            'ж' to "zh",
            'з' to "z",
            'и' to "i",
            'й' to "i",
            'к' to "k",
            'л' to "l",
            'м' to "m",
            'н' to "n",
            'о' to "o",
            'п' to "p",
            'р' to "r",
            'с' to "s",
            'т' to "t",
            'у' to "u",
            'ф' to "f",
            'х' to "h",
            'ц' to "c",
            'ч' to "ch",
            'ш' to "sh",
            'щ' to "sh'",
            'ъ' to "",
            'ы' to "i",
            'ь' to "",
            'э' to "e",
            'ю' to "yu",
            'я' to "ya",
            ' ' to "_"
        )
        while (i < payload.length) {
            result += if ((i == 0 || payload[i - 1] == ' ')&& payload[i]!=' ')
                alphabet[payload[i].toLowerCase()]?.toUpperCase(Locale.ENGLISH) ?: payload[i]
            else
                alphabet[payload[i].toLowerCase()]?: payload[i]
            i++
        }
        return result
    }

    fun toInitials(firstname: String?, lastname: String?): String? {
        return "${firstname?.get(0)}${lastname?.get(0)}"
    }


}