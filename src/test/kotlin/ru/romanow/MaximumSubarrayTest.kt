package ru.romanow

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class MaximumSubarrayTest {

    @ParameterizedTest(name = "#{index} – Max subarray sum from {0} is {0}")
    @ArgumentsSource(ValueProvider::class)
    fun maxSubArray(nums: IntArray, result: Int) {
        val obj = MaximumSubarray()
        assertThat(obj.maxSubArray(nums)).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4), 6),
                Arguments.of(intArrayOf(5, 4, -1, 7, 8), 23),
                Arguments.of(intArrayOf(1), 1),
            )
    }
}
