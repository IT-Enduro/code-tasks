package ru.romanow.easy

/**
 * Даны две строки, `needle` и `haystack`, верните индекс первого
 * вхождения `needle` в `haystack` или -1, если `needle` не является частью `haystack`.
 *
 * [https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string)
 */
class FirstOccurrenceInAString {
    fun strStr(haystack: String, needle: String): Int {
        val length = haystack.length - needle.length
        for (i in 0 until length + 1) {
            var k = 0
            while (k < needle.length && haystack[k + i] == needle[k]) {
                k++
            }

            if (k == needle.length) {
                return i
            }
        }
        return -1
    }
}
