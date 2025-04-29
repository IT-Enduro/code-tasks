package ru.romanow.medium

/**
 *  Дан целочисленный массив `nums`, верните ответ массива, такой, что ответ `[i]`
 *  равен произведению всех элементов nums, кроме `nums[i]`.
 *
 * Произведение любого префикса или суффикса чисел гарантированно вписывается в 32-битное целое число.
 *
 * Вы должны написать алгоритм, который работает за время `O(n)` и не использует операцию деления.
 *
 * [https://leetcode.com/problems/product-of-array-except-self/](https://leetcode.com/problems/product-of-array-except-self/)
 */
class ProductOfArrayExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {
        var zeros = 0
        var product = 0

        // вычисляем произведение всех ненулевых элементов и подсчитываем количество нулей
        for (n in nums) {
            if (n != 0) {
                product = if (product == 0) n else product * n
            } else {
                zeros++
            }
        }

        // если нулей больше 1, то все элементы результирующего массива будут 0
        val result = IntArray(nums.size)
        if (zeros <= 1) {
            for (i in nums.indices) {
                // если ноль один, то все элементы результирующего массива будут 0, кроме него самого, он будет product
                if (nums[i] != 0) {
                    result[i] = if (zeros == 0) (product / nums[i]) else 0
                } else {
                    result[i] = product
                }
            }
        }
        return result
    }
}
