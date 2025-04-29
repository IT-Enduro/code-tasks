package ru.romanow.medium

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class ProductOfArrayExceptSelfTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – array {0} product except self {1}")
    fun productExceptSelf(nums: IntArray, result: IntArray) {
        val obj = ProductOfArrayExceptSelf()
        assertThat(obj.productExceptSelf(nums)).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of(intArrayOf(1, 2, 3, 4), intArrayOf(24, 12, 8, 6)),
                Arguments.of(intArrayOf(-1, 1, 0, -3, 3), intArrayOf(0, 0, 9, 0, 0)),
                Arguments.of(intArrayOf(0, 0), intArrayOf(0, 0)),
                Arguments.of(intArrayOf(0, 4, 0), intArrayOf(0, 0, 0))
            )
    }
}
