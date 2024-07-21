package ru.romanow

/**
 * Дано две строки `word1` и `word2`, вернуть `true`, если строки близкие, `false` иначе.
 *
 * Две строки считаются близкими, если одну из другой можно получить с помощью следующих операций:
 * * Операция 1: поменять местами два символа в строке (например: `abcde` -> `aecdb`).
 * * Операция 2: преобразовать каждое появление одного _существующего_ символа в другой _существующий_ символ.
 * (например, `aacabb` -> `bbcbaa` (все буквы `a` превращаются в буквы `b`, а все буквы `b` превращаются в буквы `a`).
 *
 * Операции преобразования можно использовать в любой последовательности сколько угодно раз.
 *
 * [https://leetcode.com/problems/determine-if-two-strings-are-close/](https://leetcode.com/problems/determine-if-two-strings-are-close/)
 */
class DetermineIfTwoStringsAreClose {
    fun closeStrings(word1: String, word2: String): Boolean {
        return false
    }
}
