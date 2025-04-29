package ru.romanow.medium

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class DetermineIfTwoStringsAreCloseTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – {0} and {1} is close – {2}")
    fun closeStrings(word1: String, word2: String, result: Boolean) {
        val obj = DetermineIfTwoStringsAreClose()
        assertThat(obj.closeStrings(word1, word2)).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of("abc", "bca", true),
                Arguments.of("a", "aa", false),
                Arguments.of("cabbba", "abbccc", true)
            )
    }
}
