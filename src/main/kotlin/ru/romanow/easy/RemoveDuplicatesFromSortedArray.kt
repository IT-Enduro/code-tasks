package ru.romanow.easy

/**
 * Дан целочисленный массив `nums`, отсортированный в неубывающем порядке. Требуется удалить дубликаты таким образом,
 * чтобы каждый уникальный элемент появлялся только один раз. Относительный порядок элементов должен оставаться
 * неизменным.
 *
 * Измените массив `nums` так, чтобы первые `k` элементов `nums` содержали уникальные элементы в том порядке,
 * в котором они присутствовали в `nums` изначально. Остальные элементы `nums` не важны, как и размер `nums`.
 * Вернуть К – количество уникальных элементов.
 *
 * [https://leetcode.com/problems/remove-duplicates-from-sorted-array/](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)
 */
class RemoveDuplicatesFromSortedArray {
    fun removeDuplicates(nums: IntArray): Int {
        var counter = 1
        for (i in 1 until nums.size) {
            if (nums[i - 1] != nums[i]) {
                nums[counter++] = nums[i]
            }
        }
        return counter
    }
}
