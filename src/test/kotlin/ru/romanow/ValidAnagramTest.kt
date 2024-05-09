package ru.romanow

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class ValidAnagramTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – {0} is anagram for {1} – {2}")
    fun isAnagram(s: String, t: String, result: Boolean) {
        val obj = ValidAnagram()
        assertThat(obj.isAnagram(s, t)).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of("anagram", "nagaram", true),
                Arguments.of("rat", "car", false)
            )
    }
}
