package ru.romanow.algorithms

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class MergeSortTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – sorted array {0} is {1}")
    fun sort(arr: IntArray, result: IntArray) {
        val obj = MergeSort()
        obj.sort(arr)
        assertThat(arr).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of(intArrayOf(), intArrayOf()),
                Arguments.of(intArrayOf(1), intArrayOf(1)),
                Arguments.of(intArrayOf(5, 5, 5, 5), intArrayOf(5, 5, 5, 5)),
                Arguments.of(intArrayOf(1, 2, 3, 4, 5), intArrayOf(1, 2, 3, 4, 5)),
                Arguments.of(intArrayOf(5, 4, 3, 2, 1), intArrayOf(1, 2, 3, 4, 5)),
                Arguments.of(intArrayOf(3, 1, 2, 3, 2, 1), intArrayOf(1, 1, 2, 2, 3, 3))
            )
    }
}
