package ru.romanow.medium

/**
 * Вам дана целочисленная матрица размера `m`x`n` со следующими свойствами:
 *
 * * Каждая строка сортируется в порядке неубывания.
 * * Первое целое число каждой строки больше последнего целого числа предыдущей строки.
 *
 * Верните true если `target` находится в matrix, иначе false. Вы должны написать
 * решение с временной сложностью `O(log(m * n))`.
 *
 * [https://leetcode.com/problems/search-a-2d-matrix/](https://leetcode.com/problems/search-a-2d-matrix/)
 */
class SearchIn2dMatrix {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val rows = matrix.size
        val cols = matrix[0].size

        var left = 0
        var right = rows * cols - 1

        while (left <= right) {
            val mid = (left + right) / 2

            val i = mid / cols
            val j = mid % cols
            if (matrix[i][j] == target) {
                return true
            } else if (matrix[i][j] > target) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return false
    }
}
