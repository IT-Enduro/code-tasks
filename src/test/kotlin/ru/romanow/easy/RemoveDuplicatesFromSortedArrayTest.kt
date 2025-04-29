package ru.romanow.easy

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class RemoveDuplicatesFromSortedArrayTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – array {0} without duplicates has size {1}")
    fun removeDuplicates(nums: IntArray, resultSize: Int, result: IntArray) {
        val obj = RemoveDuplicatesFromSortedArray()
        val size = obj.removeDuplicates(nums)
        assertThat(size).isEqualTo(resultSize)
        assertThat(nums.copyOfRange(0, size)).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of(intArrayOf(1, 1, 2), 2, intArrayOf(1, 2)),
                Arguments.of(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4), 5, intArrayOf(0, 1, 2, 3, 4))
            )
    }
}
