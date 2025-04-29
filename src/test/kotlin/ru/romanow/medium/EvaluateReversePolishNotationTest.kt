package ru.romanow.medium

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class EvaluateReversePolishNotationTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – result of polish notations {0} is {1}")
    fun evalRPN(tokens: Array<String>, result: Int) {
        val obj = EvaluateReversePolishNotation()
        assertThat(obj.evalRPN(tokens)).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of(arrayOf("2", "1", "+", "3", "*"), 9),
                Arguments.of(arrayOf("4", "13", "5", "/", "+"), 6),
                Arguments.of(arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"), 22)
            )
    }
}
