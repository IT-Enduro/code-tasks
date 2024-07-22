package ru.romanow

/**
 * Дана строка `s`, содержащая символы '*'. За одну операцию можно:
 * * удалить символ '*' из строки `s`;
 * * удалить символ '*' а так же ближайших символ слева (не '*').
 *
 * [https://leetcode.com/problems/removing-stars-from-a-string/](https://leetcode.com/problems/removing-stars-from-a-string/)
 */
class RemovingStarsFromAString {
    fun removeStars(s: String): String {
        val result = StringBuilder()
        for (chr in s) {
            if (chr == '*' && result.isNotEmpty()) {
                result.setLength(result.length - 1)
            } else {
                result.append(chr)
            }
        }
        return result.toString()
    }
}
