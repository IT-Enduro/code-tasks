package ru.romanow

import java.util.Stack

/**
 * Дана строка `s`, представляющая собой выражение, требуется вычислить это выражение и вернуть результат.
 * Строка `s` валидная и состоит из целых чисел и операций (`+`, `-`, `*`, `/`), разделенных пробельными символами.
 *
 * **Замечание**
 * * Целочисленное деление сокращается до нуля.
 * * Все результаты в диапазоне `[-2^31..2^31-1]`.
 * * Нельзя использовать функции `eval()` или подобные.
 *
 * [https://leetcode.com/problems/basic-calculator-ii/](https://leetcode.com/problems/basic-calculator-ii/)
 */
class BasicCalculator {
    fun calculate(s: String): Int {
        if (s.isBlank()) {
            return 0
        }

        val length = s.length
        var number = 0
        var operation = '+'
        val stack = Stack<Int>()

        for ((idx, chr) in s.withIndex()) {
            if (chr.isDigit()) {
                number = 10 * number + chr.digitToInt()
            }

            if ((!chr.isWhitespace() && !chr.isDigit()) || idx == length - 1) {
                when (operation) {
                    '+' -> stack.push(number)
                    '-' -> stack.push(-number)
                    '*' -> stack.push(stack.pop() * number)
                    '/' -> stack.push(stack.pop() / number)
                }
                operation = chr
                number = 0
            }
        }

        return stack.sum()
    }
}
