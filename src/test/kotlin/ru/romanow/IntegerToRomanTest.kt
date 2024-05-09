package ru.romanow

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class IntegerToRomanTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – Integer {0} is {1}")
    fun productExceptSelf(num: Int, result: String) {
        val obj = IntegerToRoman()
        assertThat(obj.intToRoman(num)).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of(3, "III"),
                Arguments.of(58, "LVIII"),
                Arguments.of(1994, "MCMXCIV")
            )
    }
}
