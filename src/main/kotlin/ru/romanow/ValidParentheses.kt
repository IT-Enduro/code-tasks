package ru.romanow

import java.util.Stack

/**
 * Дана строка `s`, содержащая символы `(`, `)`, `{`, `}`, `[` и `]`, определить,
 * является ли входная строка валидным скобочным выражением.
 *
 * Выражение валидное, если:
 * 1. Открытые скобки должны закрываться скобками того же типа.
 * 2. Открытые скобки должны закрываться в правильном порядке.
 * 3. Каждой закрывающей скобке соответствует открытая скобка того же типа.
 *
 * [https://leetcode.com/problems/valid-parentheses/](https://leetcode.com/problems/valid-parentheses/)
 */
class ValidParentheses {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        for (chr in s) {
            if (chr == '(') {
                stack.push(')')
            } else if (chr == '[') {
                stack.push(']')
            } else if (chr == '{') {
                stack.push('}')
            } else if (stack.isEmpty() || chr != stack.pop()) {
                return false
            }
        }
        return stack.empty()
    }
}
