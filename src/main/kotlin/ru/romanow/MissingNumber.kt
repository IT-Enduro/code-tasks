package ru.romanow

/**
 * Дан массив `nums`, содержащий N различных чисел в диапазоне `[0, N]`, вернуть число, которое отсутствует в массиве.
 *
 * [https://leetcode.com/problems/missing-number/](https://leetcode.com/problems/missing-number/)
 */
class MissingNumber {
    fun missingNumber(nums: IntArray): Int {
        val arr = Array(nums.size + 1) { false }
        for (n in nums) {
            arr[n] = true
        }
        return arr.indexOfFirst { !it }
    }
}
