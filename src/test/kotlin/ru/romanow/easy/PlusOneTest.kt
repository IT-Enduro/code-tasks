package ru.romanow.easy

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class PlusOneTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – Plus 1 to {0}")
    fun plusOne(digits: IntArray, result: IntArray) {
        val obj = PlusOne()
        assertThat(obj.plusOne(digits)).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of(intArrayOf(1, 2, 3), intArrayOf(1, 2, 4)),
                Arguments.of(intArrayOf(4, 3, 2, 1), intArrayOf(4, 3, 2, 2)),
                Arguments.of(intArrayOf(9), intArrayOf(1, 0))
            )
    }
}
