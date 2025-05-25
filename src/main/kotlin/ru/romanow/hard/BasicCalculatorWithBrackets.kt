package ru.romanow.hard

import java.util.Stack

/**
 * Дана строка `s`, представляющая собой выражение, требуется вычислить это выражение и вернуть результат.
 * Строка `s` валидная и состоит из целых чисел и операций (`+`, `-`, `(`, `)`), разделенных пробельными символами.
 *
 * **Замечание**
 * * Целочисленное деление сокращается до нуля.
 * * Унарный минус может использоваться вместе с числом.
 * * Все результаты в диапазоне `[-2^31..2^31-1]`.
 * * Нельзя использовать функции `eval()` или подобные.
 *
 * [https://leetcode.com/problems/basic-calculator/](https://leetcode.com/problems/basic-calculator/)
 */
class BasicCalculatorWithBrackets {
    fun calculate(s: String): Int {
        if (s.isBlank()) {
            return 0
        }

        var number = 0
        val stack = Stack<Int>()
        var sign = 1
        var result = 0

        for (chr in s) {
            when {
                chr.isDigit() -> {
                    number = 10 * number + chr.digitToInt()
                }

                chr == '(' -> {
                    stack.push(result)
                    stack.push(sign)
                    result = 0
                    sign = 1
                }

                chr == ')' -> {
                    result += sign * number
                    number = 0
                    result *= stack.pop()
                    result += stack.pop()
                }

                chr == '+' || chr == '-' -> {
                    result += sign * number
                    number = 0
                    sign = if (chr == '+') 1 else -1
                }
            }
        }
        return result + sign * number
    }
}
