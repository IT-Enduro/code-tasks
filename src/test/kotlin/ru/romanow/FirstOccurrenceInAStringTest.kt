package ru.romanow

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class FirstOccurrenceInAStringTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – Occurrence {1} in a string {0}")
    fun strStr(
        haystack: String,
        needle: String,
        result: Int,
    ) {
        val obj = FirstOccurrenceInAString()
        assertThat(obj.strStr(haystack, needle)).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(of("sadbutsad", "sad", 0), of("leetcode", "leeto", -1), of("a", "a", 0), of("a", "asd", -1))
    }
}
