package ru.romanow.medium

import java.util.Stack

/**
 * Дана закодированная строка, вернуть декодированную строку.
 *
 * Правила декодирования: запись `k[encoded_string]` означает, что `encoded_string` внутри квадратных скобок
 * повторяется `k` раз.
 *
 * **Замечание**
 * * Входная строка всегда действительна.
 * * Нет лишних пробелов, квадратные скобки имеют правильную форму и т. д.
 * * Кроме того, исходные данные не содержат никаких цифр и цифры предназначены только для повторяющихся чисел `k`.
 * * Например, не будет ввода типа `3a` или `2[4]`.
 *
 * [https://leetcode.com/problems/decode-string/](https://leetcode.com/problems/decode-string/)
 */
class DecodeString {
    fun decodeString(s: String): String {
        var result = StringBuilder()
        val counts = Stack<Int>()
        val strings = Stack<StringBuilder>()

        var k = 0
        for (chr in s) {
            if (chr.isDigit()) {
                k = (10 * k) + chr.digitToInt()
            } else if (chr == '[') {
                counts.push(k)
                k = 0
                strings.push(result)
                result = StringBuilder()
            } else if (chr == ']') {
                val n = counts.pop()
                val temp = result
                result = strings.pop()
                for (i in 0 until n) {
                    result.append(temp)
                }
            } else {
                result.append(chr)
            }
        }
        return result.toString()
    }
}
