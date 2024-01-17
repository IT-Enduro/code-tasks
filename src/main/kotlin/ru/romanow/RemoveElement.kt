package ru.romanow

/**
 * Дан целочисленный массив `nums` и целочисленное значение `value`,
 * удалите все вхождения `value` в `nums` на месте. Порядок элементов может быть изменен.
 * Затем верните количество элементов в виде чисел, которые не равны `value`.
 *
 * Для решения задачи, необходимо сделать следующее:
 * * Измените массив `nums` так, чтобы первые `k` элементов `nums` содержали элементы, не равные `value`.
 * * Остальные элементы `nums` не важны, как и размер `nums`.
 *
 * Вернуть `k`.

 * [https://leetcode.com/problems/remove-element/](https://leetcode.com/problems/remove-element/)
 */
class RemoveElement {
    fun removeElement(nums: IntArray, value: Int): Int {
        var pos = 0
        for (i in nums.indices) {
            if (nums[i] != value) {
                nums[pos++] = nums[i]
            }
        }
        return pos
    }
}
