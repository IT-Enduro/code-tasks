package ru.romanow

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class LongestCommonPrefixTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – Occurrence {1} in a string {0}")
    fun longestCommonPrefix(strs: Array<String>, result: String) {
        val obj = LongestCommonPrefix()
        Assertions.assertThat(obj.longestCommonPrefix(strs)).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                of(arrayOf("flower", "flow", "flight"), "fl"),
                of(arrayOf("dog", "racecar", "car"), ""),
            )
    }
}
