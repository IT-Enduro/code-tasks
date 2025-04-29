package ru.romanow.easy

/**
 * Дано число `n`, вернуть `true`, если оно является степенью тройки, иначе `false`.
 * Целое число `n` является степенью тройки, если существует такое целочисленное `x`, что `n = 3^x`.
 *
 * [https://leetcode.com/problems/power-of-three/](https://leetcode.com/problems/power-of-three/)
 */
class PowerOfThree {
    fun isPowerOfThree(n: Int): Boolean {
        var result = n > 0
        var k = n
        while (k > 1 && result) {
            result = k % 3 == 0
            k /= 3
        }
        return result
    }
}
