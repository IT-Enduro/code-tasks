package ru.romanow

// https://leetcode.com/problems/roman-to-integer
class RomanToInteger {
    private val map = mapOf('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)

    fun romanToInt(s: String): Int {
        var result = 0
        var previous = 0

        for (chr in s.reversed()) {
            val number = map[chr]!!
            result += if (previous <= number) number else -number
            previous = number
        }
        return result
    }
}
