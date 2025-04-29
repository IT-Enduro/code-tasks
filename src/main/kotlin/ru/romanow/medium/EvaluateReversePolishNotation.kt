package ru.romanow.medium

import java.util.Stack

/**
 * Дан набор строк, представляющий арифметическое выражение в обратной польской нотации.
 * Требуется вычислить выражение и вернуть результат в виде целочисленное число.
 *
 * **Замечание**
 * * Допустимые операторы: `+`, `-`, `*` и `/`.
 * * Каждый операнд может быть целым числом или другим выражением.
 * * Деление двух целых чисел округляется до ближайшего целого числа снизу.
 * * Деления на ноль не будет.
 * * Входные данные представляют собой допустимое арифметическое выражение в обратной польской записи.
 * * Ответ и все промежуточные вычисления можно представить в виде целого числа.
 *
 * [https://leetcode.com/problems/evaluate-reverse-polish-notation/](https://leetcode.com/problems/evaluate-reverse-polish-notation/)
 */
class EvaluateReversePolishNotation {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<Int>()
        val operations = arrayOf("+", "-", "*", "/")
        for (token in tokens) {
            if (token in operations) {
                val left = stack.pop()
                val right = stack.pop()
                val result =
                    when (token) {
                        "+" -> right + left
                        "-" -> right - left
                        "*" -> right * left
                        "/" -> right / left
                        else -> throw IllegalArgumentException("Wrong token")
                    }
                stack.push(result)
            } else {
                stack.push(token.toInt())
            }
        }
        return stack.pop()
    }
}
