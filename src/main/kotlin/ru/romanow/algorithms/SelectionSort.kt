package ru.romanow.algorithms

class SelectionSort {
    fun sort(arr: IntArray) {
        val n = arr.size
        for (i in 0 until n - 1) {
            var idx = i
            for (j in i + 1 until n) {
                if (arr[j] < arr[idx]) {
                    idx = j
                }
            }
            if (idx != i) {
                val temp = arr[i]
                arr[i] = arr[idx]
                arr[idx] = temp
            }
        }
    }
}
