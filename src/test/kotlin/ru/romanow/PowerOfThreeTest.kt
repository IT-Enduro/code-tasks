package ru.romanow

import jdk.internal.org.jline.utils.Colors.s
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class PowerOfThreeTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – is the {0} a power of three {1}")
    fun isPowerOfThree(n: Int, result: Boolean) {
        val obj = PowerOfThree()
        assertThat(obj.isPowerOfThree(s)).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of(27, true),
                Arguments.of(0, false),
                Arguments.of(-1, false)
            )
    }
}
