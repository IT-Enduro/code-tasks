package ru.romanow.easy

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class TwoSumTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – Find two numbers {0} for sum {1}")
    fun twoSum(nums: IntArray, target: Int, result: IntArray) {
        val obj = TwoSum()
        assertThat(obj.twoSum(nums, target)).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of(intArrayOf(2, 7, 11, 15), 9, intArrayOf(0, 1)),
                Arguments.of(intArrayOf(3, 2, 4), 6, intArrayOf(1, 2)),
                Arguments.of(intArrayOf(3, 3), 6, intArrayOf(0, 1)),
            )
    }
}
