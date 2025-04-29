package ru.romanow.easy

/**
 * Дано два целочисленных массива `nums1` и `nums2`, вернуть массив, являющийся их пересечением.
 * Каждый элемент результата должен появляться столько раз, сколько он отображается в обоих массивах,
 * результат можно возвращать в любом порядке.
 *
 * [https://leetcode.com/problems/intersection-of-two-arrays-ii/](https://leetcode.com/problems/intersection-of-two-arrays-ii/)
 */
class IntersectionOfTwoArrays {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val map = mutableMapOf<Int, Int>()
        val result = mutableListOf<Int>()
        nums1.forEach {
            val count = map[it]
            map[it] = if (count == null) 0 else count + 1
        }

        for (num in nums2) {
            val count = map[num]
            if (count != null) {
                map[num] = count - 1
                if (count >= 0) {
                    result.add(num)
                }
            }
        }

        return result.toIntArray()
    }
}
