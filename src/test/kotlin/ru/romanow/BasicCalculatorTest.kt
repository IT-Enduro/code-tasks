package ru.romanow

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class BasicCalculatorTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – expression {0} result is {1}")
    fun calculate(s: String, result: Int) {
        val obj = BasicCalculator()
        assertThat(obj.calculate(s)).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of("3+2*2", 7),
                Arguments.of(" 3/2 ", 1),
                Arguments.of(" 3+5 / 2 ", 5)
            )
    }
}
