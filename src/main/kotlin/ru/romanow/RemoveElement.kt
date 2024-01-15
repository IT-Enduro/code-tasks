package ru.romanow

// https://leetcode.com/problems/remove-element/
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
