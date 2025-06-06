package ru.romanow.easy

/**
 * Вы являетесь менеджером по продукту, и в настоящее время возглавляете
 * команду по разработке нового продукта. К сожалению, последняя версия вашего
 * продукта не прошла проверку качества. Поскольку каждая версия разрабатывается
 * на основе предыдущей, все версии после плохой версии также являются плохими.
 *
 * Предположим, у вас есть `n` версий `[1, 2, ..., n]` и вы хотите найти первую плохую версию,
 * из-за которой все последующие будут плохими.
 *
 * Вам предоставляется API `bool isBadVersion(version),` который возвращает, является ли версия плохой.
 * Реализуйте функцию для поиска первой плохой версии. Вам следует минимизировать количество вызовов API.
 *
 * [https://leetcode.com/problems/first-bad-version/](https://leetcode.com/problems/first-bad-version/)
 */
class FirstBadVersion(brokenVersion: Int) : VersionControl(brokenVersion) {
    override fun firstBadVersion(n: Int): Int {
        var left = 0
        var right = n
        var result = -1

        while (left <= right) {
            val mid = left + (right - left) / 2
            if (isBadVersion(mid)) {
                result = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return result
    }
}

abstract class VersionControl(private val brokenVersion: Int) {
    protected fun isBadVersion(version: Int): Boolean {
        return version >= brokenVersion
    }

    abstract fun firstBadVersion(n: Int): Int
}
