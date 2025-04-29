package ru.romanow.algorithms

class MergeSort {
    fun sort(arr: IntArray, left: Int = 0, right: Int = arr.size - 1) {
        if (left < right) {
            val middle = (left + right) / 2
            sort(arr, left, middle)
            sort(arr, middle + 1, right)
            merge(arr, left, middle, right)
        }
    }

    private fun merge(arr: IntArray, left: Int, middle: Int, right: Int) {
        val leftArray = arr.sliceArray(left..middle)
        val rightArray = arr.sliceArray(middle + 1..right)

        var i = 0
        var j = 0
        var k = left

        while (i < leftArray.size && j < rightArray.size) {
            arr[k++] = if (leftArray[i] <= rightArray[j]) leftArray[i++] else rightArray[j++]
        }

        while (i < leftArray.size) {
            arr[k++] = leftArray[i++]
        }

        while (j < rightArray.size) {
            arr[k++] = rightArray[j++]
        }
    }
}
