package ru.romanow.medium

import kotlin.math.max
import kotlin.math.min

/**
 * Дан массив интервалов, где `intervals[i]` = `[start[i], end[i]]`.
 * Объедините все перекрывающиеся интервалы и верните массив непересекающихся интервалов,
 * которые охватывают все интервалы входных данных.
 *
 * [https://leetcode.com/problems/merge-intervals/](https://leetcode.com/problems/merge-intervals/)
 */
class MergeIntervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val result = mutableListOf<IntArray>()

        intervals.sortBy { it[0] }
        var min = intervals[0][0]
        var max = intervals[0][1]
        for (i in 1 until intervals.size) {
            if (intervals[i][0] in min..max || intervals[i][1] in min..max) {
                min = min(min, intervals[i][0])
                max = max(max, intervals[i][1])
            } else {
                result.add(intArrayOf(min, max))
                min = intervals[i][0]
                max = intervals[i][1]
            }
        }
        result.add(intArrayOf(min, max))

        return result.toTypedArray()
    }
}
