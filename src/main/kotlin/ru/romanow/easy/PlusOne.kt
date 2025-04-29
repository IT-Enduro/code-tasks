package ru.romanow.easy

/**
 * Вам дано большое целое число, представленное в виде целочисленного массива цифр,
 * где каждая цифра `[i]` — это `i`-я цифра целого числа. Цифры упорядочены от наиболее
 * значимого к наименее значимому, слева направо. Большое целое число не содержит ведущих нулей.
 *
 * Увеличьте целое число на единицу и верните полученный массив цифр.
 *
 * [https://leetcode.com/problems/plus-one/](https://leetcode.com/problems/plus-one/)
 */
class PlusOne {
    fun plusOne(digits: IntArray): IntArray {
        val n: Int = digits.size
        for (i in n - 1 downTo 0) {
            if (digits[i] < 9) {
                digits[i]++
                return digits
            }
            digits[i] = 0
        }

        val newNumber = IntArray(n + 1)
        newNumber[0] = 1

        return newNumber
    }
}
