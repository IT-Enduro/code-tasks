package ru.romanow.medium

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class LongestConsecutiveSequenceTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – array {0} has {1} consecutive elements sequence")
    fun longestConsecutive(nums: IntArray, result: Int) {
        val obj = LongestConsecutiveSequence()
        assertThat(obj.longestConsecutive(nums)).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of(intArrayOf(100, 4, 200, 1, 3, 2), 4),
                Arguments.of(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1), 9)
            )
    }
}
