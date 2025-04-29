package ru.romanow.easy

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class RemoveElementTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – Remove {1} from {0}")
    fun removeElement(nums: IntArray, value: Int, resultSize: Int, result: IntArray) {
        val obj = RemoveElement()
        val size = obj.removeElement(nums, value)
        assertThat(size).isEqualTo(resultSize)
        assertThat(nums.copyOfRange(0, size)).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of(intArrayOf(3, 2, 2, 3), 3, 2, intArrayOf(2, 2)),
                Arguments.of(intArrayOf(0, 1, 2, 2, 3, 0, 4, 2), 2, 5, intArrayOf(0, 1, 3, 0, 4))
            )
    }
}
