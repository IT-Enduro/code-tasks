package ru.romanow

// https://leetcode.com/problems/valid-palindrome/
class ValidPalindrome {
    fun isPalindrome(s: String): Boolean {
        var start = 0
        var end = s.length - 1
        var valid = true
        while (start <= end && valid) {
            if (!s[start].isLetterOrDigit()) {
                start++
            } else if (!s[end].isLetterOrDigit()) {
                end--
            } else if (s[start].lowercase() == s[end].lowercase()) {
                start++
                end--
            } else {
                valid = false
            }
        }
        return valid
    }
}
