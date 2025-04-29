package ru.romanow.easy

/**
 * Фраза является палиндромом, если после преобразования всех заглавных букв в строчные
 * и удаления всех небуквенно-цифровых символов она читается одинаково и вперед, и назад.
 * Буквенно-цифровые символы включают буквы и цифры.
 *
 * Дана строка `s`, верните `true`, если это палиндром, `false` иначе.
 *
 * [https://leetcode.com/problems/valid-palindrome/](https://leetcode.com/problems/valid-palindrome/)
 */
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
