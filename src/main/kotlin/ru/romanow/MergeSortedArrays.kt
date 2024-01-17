package ru.romanow

/**
 * Вам даны два целочисленных массива `nums1` и `nums2`, отсортированные в порядке неубывания,
 * и два целых числа `m` и `n`, представляющие количество элементов в `nums1` и `nums2` соответственно.
 *
 * Объедините `nums1` и `nums2` в один массив, отсортированный в неубывающем порядке.
 *
 * Окончательно отсортированный массив должен храниться внутри массива `nums1`. Для этого `nums1`
 * имеет длину `m + n`, где первые `m` элементов обозначают элементы, которые следует объединить,
 * а последние `n` элементов имеют значение 0 и их следует игнорировать. Массив `nums2` имеет длину `n`.
 *
 * [https://leetcode.com/problems/merge-sorted-array/](https://leetcode.com/problems/merge-sorted-array/)
 */
class MergeSortedArrays {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var resultIndex = m + n - 1
        var firstIndex = m - 1
        var secondIndex = n - 1
        while (resultIndex >= 0 && secondIndex >= 0) {
            if (firstIndex >= 0 && nums1[firstIndex] >= nums2[secondIndex]) {
                nums1[resultIndex--] = nums1[firstIndex--]
            } else {
                nums1[resultIndex--] = nums2[secondIndex--]
            }
        }
    }
}
