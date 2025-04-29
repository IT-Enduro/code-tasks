package ru.romanow.medium

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class LongestCommonSubsequenceTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – {0} and {1} has common subsequence with {2} chars")
    fun longestCommonSubsequence(text1: String, text2: String, result: Int) {
        val obj = LongestCommonSubsequence()
        assertThat(obj.longestCommonSubsequence(text1, text2)).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of("abcde", "ace", 3),
                Arguments.of("abc", "abc", 3),
                Arguments.of("abc", "def", 0)
            )
    }
}
