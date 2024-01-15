package ru.romanow

// https://leetcode.com/problems/merge-sorted-array/
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
