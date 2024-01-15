package ru.romanow

// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string
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
