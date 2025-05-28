package ru.romanow.algorithms

class KnuthMorrisPrattAlgorithm {
    fun strStr(haystack: String, needle: String): Int {
        val lps = computeLps(needle)
        var i = 0
        var j = 0
        while (i < haystack.length) {
            if (haystack[i] == needle[j]) {
                i++
                j++
            }

            if (j == needle.length) {
                return i - j
            } else if (i < haystack.length && haystack[i] != needle[j]) {
                if (j != 0) {
                    j = lps[j - 1]
                } else {
                    i++
                }
            }
        }
        return -1
    }

    private fun computeLps(pattern: String): IntArray {
        val lps = IntArray(pattern.length)
        var length = 0
        var idx = 1

        while (idx < pattern.length) {
            if (pattern[idx] == pattern[length]) {
                length++
                lps[idx] = length
                idx++
            } else {
                if (length != 0) {
                    length = lps[length - 1]
                } else {
                    lps[idx] = 0
                    idx++
                }
            }
        }

        return lps
    }
}
