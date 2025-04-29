package ru.romanow.algorithms

import java.util.Stack

class QuickSortWithoutRecursion {
    fun sort(arr: IntArray) {
        val stack = Stack<Pair<Int, Int>>()
        stack.push(0 to arr.size - 1)

        while (stack.isNotEmpty()) {
            val (left, right) = stack.pop()

            if (left < right) {
                val pivotIndex = partition(arr, left, right)
                if (pivotIndex - 1 > left) {
                    stack.push(Pair(left, pivotIndex - 1))
                }
                if (pivotIndex + 1 < right) {
                    stack.push(Pair(pivotIndex + 1, right))
                }
            }
        }
    }

    private fun partition(arr: IntArray, low: Int, high: Int): Int {
        val pivot = arr[high]
        var i = low - 1

        for (j in low until high) {
            if (arr[j] <= pivot) {
                i++
                arr.swap(i, j)
            }
        }
        arr.swap(i + 1, high)
        return i + 1
    }

    private fun IntArray.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
}
