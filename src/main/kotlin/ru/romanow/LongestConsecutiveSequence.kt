package ru.romanow

/**
 * Дан неотсортированный массив целых чисел, вернуть длину самой длинной последовательной последовательности элементов.
 *
 * [https://leetcode.com/problems/longest-consecutive-sequence/](https://leetcode.com/problems/longest-consecutive-sequence/)
 */
class LongestConsecutiveSequence {
    fun longestConsecutive(nums: IntArray): Int {
        var result = 0
        val set = mutableSetOf(*nums.toTypedArray())
        while (set.isNotEmpty()) {
            var left = set.pop()
            var right = left
            while ((left - 1) in set) {
                set.remove(--left)
            }
            while ((right + 1) in set) {
                set.remove(++right)
            }
            result = maxOf(result, right - left + 1)
        }

        return result
    }

    private fun <T> MutableSet<T>.pop(): T = this.first().also { this.remove(it) }
}
