package ru.romanow


// https://leetcode.com/problems/first-bad-version/
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
        return version >= brokenVersion;
    }

    abstract fun firstBadVersion(n: Int): Int
}
