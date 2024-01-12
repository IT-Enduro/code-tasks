package ru.romanow

// https://leetcode.com/problems/plus-one/
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
