package ru.romanow

// https://leetcode.com/problems/longest-common-prefix/
class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        val size = strs.minOfOrNull { s -> s.length }!!
        if (size == 0) {
            return ""
        }

        var i = 0
        var found = true
        var prefix = ""
        while (i < size && found) {
            val chr = strs[0][i]
            for (str in strs) {
                if (str[i] != chr) {
                    found = false
                    break
                }
            }
            if (found) {
                prefix += strs[0][i++]
            }
        }
        return prefix
    }
}
