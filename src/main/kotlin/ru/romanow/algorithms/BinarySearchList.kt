package ru.romanow.algorithms

class BinarySearchList {
    fun find(list: List<Int>, target: Int, left: Int = 0, right: Int = list.size - 1): Int {
        if (left > right) {
            return -1
        }
        val middle = left + (right - left) / 2
        return when {
            list[middle] == target -> middle
            list[middle] < target -> find(list, target, middle + 1, right)
            else -> find(list, target, left, middle - 1)
        }
    }
}
