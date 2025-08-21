package ru.romanow.algorithms

class QuickSort {
    fun sort(arr: IntArray, low: Int = 0, high: Int = arr.size - 1) {
        if (low < high) {
            val pivotIndex = partition(arr, low, high)
            sort(arr, low, pivotIndex - 1)
            sort(arr, pivotIndex + 1, high)
        }
    }

    private fun partition(arr: IntArray, low: Int, high: Int): Int {
        val pivot = arr[high] // в качестве опрного элемента берем последний
        // Когда начинается цикл перебора элементов массива, изначально никаких элементов ещё не сравнивалось,
        // поэтому i находится вне границ массива (это значит, что пока нет ни одного элемента, подходящего под
        // условие "меньше или равно опорному элементу").
        // Далее внутри цикла мы увеличиваем i, если находим элемент, который подходит под данное условие.
        // Таким образом, если встречается элемент, удовлетворяющий условию (`if (arr[j] <= pivotValue)`), мы сначала
        // увеличиваем i, а потом меняем местами этот элемент с элементом на позиции i. То есть фактически мы постепенно
        // формируем отсортированную часть массива, где все элементы слева от i + 1 гарантированно меньше или равны
        // опорному элементу
        var i = low - 1

        // если arr[j] <= pivot, увеличиваем i и меняем местами arr[i] и arr[j]
        //  таким образом, все элементы <= pivot собираются слева
        for (j in low until high) {
            if (arr[j] <= pivot) {
                i++
                arr.swap(i, j)
            }
        }
        // в конце arr[i + 1] и arr[high] меняются местами, чтобы поставить pivot на правильную позицию
        arr.swap(i + 1, high)
        return i + 1
    }

    private fun IntArray.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
}
