package ru.romanow

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class SummaryRangesTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – Summary {0} – {1}")
    fun summaryRanges(nums: IntArray, result: List<String>) {
        val obj = SummaryRanges()
        Assertions.assertThat(obj.summaryRanges(nums)).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of(intArrayOf(0, 1, 2, 4, 5, 7), listOf("0->2", "4->5", "7")),
                Arguments.of(intArrayOf(0, 2, 3, 4, 6, 8, 9), listOf("0", "2->4", "6", "8->9"))
            )
    }
}
