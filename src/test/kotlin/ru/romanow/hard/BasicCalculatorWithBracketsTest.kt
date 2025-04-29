package ru.romanow.hard

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class BasicCalculatorWithBracketsTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – expression {0} result is {1}")
    fun calculate(s: String, result: Int) {
        val obj = BasicCalculatorWithBrackets()
        assertThat(obj.calculate(s)).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of("1 + 1", 2),
                Arguments.of(" 2-1 + 2 ", 3),
                Arguments.of("(1+(4+5+2)-3)+(6+8)", 23)
            )
    }
}
