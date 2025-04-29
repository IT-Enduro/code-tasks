package ru.romanow.easy

/**
 * Дан массив целых чисел длиной `n`, вернуть самый часто встречающийся элемент.
 *
 * Мажоритарным элементом является элемент, который появляется более `[n/2]` раз. Такой элемент всегда есть в массиве.
 *
 * [https://leetcode.com/problems/majority-element/](https://leetcode.com/problems/majority-element/)
 */
class MajorityElement {
    fun majorityElement(nums: IntArray): Int {
        var candidate = 0
        var counter = 0
        for (num in nums) {
            if (counter == 0) {
                candidate = num
                counter++
            } else {
                counter = if (candidate == num) counter + 1 else counter - 1
            }
        }
        return candidate
    }
}
