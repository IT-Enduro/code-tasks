package ru.romanow

/**
 * Дан отсортированный целочисленный массив чисел с уникальными значениями.
 * Диапазон `[a, b]` — это набор всех целых чисел от `a` до `b` (включительно).
 *
 * Требуется найти наименьший отсортированный список диапазонов, который охватывает
 * все числа в массиве. То есть каждый элемент `nums` охватывается ровно одним из диапазонов,
 * и не существует целого числа `x` такого, что `x` находится в одном из диапазонов, но не в `nums`.
 *
 * Каждый диапазон `[a, b]` в списке должен выводиться как:
 * * `a` -> `b`, если `a` != `b`;
 * * `а`, если `a` == `b`.
 *
 * [https://leetcode.com/problems/summary-ranges/](https://leetcode.com/problems/summary-ranges)
 */
class SummaryRanges {
    fun summaryRanges(nums: IntArray): List<String> {
        val result = mutableListOf<String>()

        var rangeStart = 0
        for (i in nums.indices) {
            if (i == nums.size - 1 || nums[i] + 1 != nums[i + 1]) {
                if (rangeStart != i) {
                    result += "${nums[rangeStart]}->${nums[i]}"
                    rangeStart = i + 1
                } else {
                    result += "${nums[i]}"
                    rangeStart = i + 1
                }
            }
        }

        return result
    }
}
