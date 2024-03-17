package ru.romanow

/**
 * Дана строка `s`, изменить порядок слов на обратный.
 *
 * Слово определяется как последовательность символов, не являющихся пробелами.
 * Слова в `s` будут разделены хотя бы одним пробелом.
 *
 * Вернуть строку в обратном порядке, объединенную одним пробелом.
 *
 * **Замечание**
 * Строка `s` может содержать начальные или конечные пробелы, или несколько пробелов между двумя словами.
 * Возвращаемая строка должна содержать только один пробел, разделяющий слова.
 *
 * [https://leetcode.com/problems/reverse-words-in-a-string/](https://leetcode.com/problems/reverse-words-in-a-string/)
 */
class ReverseWordsInAString {
    fun reverseWords(s: String): String {
        var result = ""
        var i = s.length - 1
        while (i >= 0) {
            while (i >= 0 && s[i] == ' ') {
                i--
            }

            val end = i + 1
            while (i >= 0 && s[i] != ' ') {
                i--
            }

            if (i + 1 < end) {
                val whitespace = if (result.isNotBlank()) " " else ""
                result = result + whitespace + s.substring(i + 1, end)
            }
            i--
        }
        return result
    }
}
