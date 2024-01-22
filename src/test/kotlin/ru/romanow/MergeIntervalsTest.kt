package ru.romanow

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class MergeIntervalsTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – Merged intervals of {0} – {1}")
    fun summaryRanges(intervals: Array<IntArray>, result: Array<IntArray>) {
        val obj = MergeIntervals()
        Assertions.assertThat(obj.merge(intervals)).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                of(
                    arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18)),
                    arrayOf(intArrayOf(1, 6), intArrayOf(8, 10), intArrayOf(15, 18))
                ),
                of(arrayOf(intArrayOf(1, 4), intArrayOf(4, 5)), arrayOf(intArrayOf(1, 5))),
                of(arrayOf(intArrayOf(1, 4), intArrayOf(0, 2), intArrayOf(3, 5)), arrayOf(intArrayOf(0, 5)))
            )
    }
}
