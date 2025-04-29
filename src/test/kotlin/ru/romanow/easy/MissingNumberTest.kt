package ru.romanow.easy

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class MissingNumberTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – Missing number in {0} is {1}")
    fun missingNumber(nums: IntArray, result: Int) {
        val obj = MissingNumber()
        assertThat(obj.missingNumber(nums)).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of(intArrayOf(3, 0, 1), 2),
                Arguments.of(intArrayOf(0, 1), 2),
                Arguments.of(intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1), 8)
            )
    }
}
