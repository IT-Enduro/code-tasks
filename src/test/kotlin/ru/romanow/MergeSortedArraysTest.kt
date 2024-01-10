package ru.romanow

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class MergeSortedArraysTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – Merge arrays {0} and {1}")
    fun merge(
        nums1: IntArray,
        m: Int,
        nums2: IntArray,
        n: Int,
        result: IntArray,
    ) {
        val obj = MergeSortedArrays()
        obj.merge(nums1, m, nums2, n)
        assertThat(nums1).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                of(intArrayOf(1, 2, 3, 0, 0, 0), 3, intArrayOf(2, 5, 6), 3, intArrayOf(1, 2, 2, 3, 5, 6)),
                of(intArrayOf(4, 5, 6, 0, 0, 0), 3, intArrayOf(1, 2, 3), 3, intArrayOf(1, 2, 3, 4, 5, 6)),
                of(intArrayOf(1), 1, intArrayOf(), 0, intArrayOf(1)),
                of(intArrayOf(0), 0, intArrayOf(1), 1, intArrayOf(1)),
            )
    }
}
