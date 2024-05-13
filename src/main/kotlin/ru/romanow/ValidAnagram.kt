package ru.romanow

/**
 * Дано две строки `s` и `t`, вернуть `true`, если `t` является анаграммой `s`, `false` иначе.
 *
 * Анаграмма — это слово или фраза, образованная путем перестановки букв другого слова или фразы
 * с использованием всех исходных букв ровно один раз.
 *
 * [https://leetcode.com/problems/valid-anagram/](https://leetcode.com/problems/valid-anagram/)
 */
class ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }

        val letter = IntArray(26)
        val a = 'a'.code
        for (i in s.indices) {
            letter[s[i].code - a]++
            letter[t[i].code - a]--
        }
        return !letter.any { it != 0 }
    }
}
