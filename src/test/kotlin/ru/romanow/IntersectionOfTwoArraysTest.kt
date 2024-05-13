package ru.romanow

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class IntersectionOfTwoArraysTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – intersection of arrays {0} and {1} is {2}")
    fun intersect(nums1: IntArray, nums2: IntArray, result: IntArray) {
        val obj = IntersectionOfTwoArrays()
        assertThat(obj.intersect(nums1, nums2)).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2), intArrayOf(2, 2)),
                Arguments.of(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4), intArrayOf(9, 4))
            )
    }
}
