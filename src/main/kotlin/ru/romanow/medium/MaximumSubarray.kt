package ru.romanow.medium

/**
 * Дан массив целых чисел, найти подмассив с наибольшей суммой
 *
 * [https://leetcode.com/problems/maximum-subarray/](https://leetcode.com/problems/maximum-subarray/)
 */
class MaximumSubarray {
    fun maxSubArray(nums: IntArray): Int {
        var maxSum = nums[0]
        var currentSum = nums[0]
        for (i in 1 until nums.size) {
            currentSum += nums[i]
            if (currentSum < nums[i]) {
                currentSum = nums[i]
            }
            if (currentSum > maxSum) {
                maxSum = currentSum
            }
        }
        return maxSum
    }
}
