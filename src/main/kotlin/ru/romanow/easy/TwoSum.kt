package ru.romanow.easy

/**
 * Дан массив целых чисел `nums` и `target`, верните индексы двух чисел так,
 * чтобы их сумма составляла `target`.
 *
 * Каждый набор входных данных имеет единственное решение и один и тот же элемент
 * нельзя использовать дважды.
 *
 * Вы можете вернуть ответ в любом порядке.
 *
 * [https://leetcode.com/problems/two-sum/](https://leetcode.com/problems/two-sum/)
 */
class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray? {
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[i] + nums[j] == target) {
                    return intArrayOf(i, j)
                }
            }
        }
        return null
    }
}
