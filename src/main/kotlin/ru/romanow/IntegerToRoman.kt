package ru.romanow

/**
 * Римские цифры представлены семью различными символами: I, V, X, L, C, D и M.
 *
 * | Символ | Значение |
 * |:------:|:--------:|
 * | I      | 1        |
 * | V      | 5        |
 * | X      | 10       |
 * | L      | 50       |
 * | C      | 100      |
 * | D      | 500      |
 * | M      | 1000     |
 *
 * Например, 2 записывается как II римскими цифрами, состоящими из двух единиц. 12 записывается как XII,
 * то есть просто X + II. Число 27 записывается как XXVII, то есть XX + V + II.
 *
 * Римские цифры обычно пишутся от большей к меньшей слева направо. Однако цифа 4 записывается не как IV.
 * Поскольку единица стоит перед пятеркой, мы вычитаем ее, получая четыре. Тот же принцип применим и к числу девять,
 * которое пишется как IX. Есть шесть случаев, когда используется вычитание:
 *
 * * I можно поставить перед V (5) и X (10), чтобы получилось 4 и 9.
 * * X можно поставить перед L (50) и C (100), чтобы получилось 40 и 90.
 * * C можно поставить перед D (500) и M (1000), чтобы получилось 400 и 900.
 *
 * Дано целое число, преобразуйте его в римскую цифру.
 *
 * [https://leetcode.com/problems/integer-to-roman/](https://leetcode.com/problems/integer-to-roman/)
 */
class IntegerToRoman {
    private val map =
        mapOf(
            1000 to "M",
            900 to "CM",
            500 to "D",
            400 to "CD",
            100 to "C",
            90 to "XC",
            50 to "L",
            40 to "XL",
            10 to "X",
            9 to "IX",
            5 to "V",
            4 to "IV",
            1 to "I"
        )

    fun intToRoman(num: Int): String {
        var result = ""
        var number = num
        for ((value, symbol) in map) {
            while (number >= value) {
                result += symbol
                number -= value
            }
        }
        return result
    }
}
