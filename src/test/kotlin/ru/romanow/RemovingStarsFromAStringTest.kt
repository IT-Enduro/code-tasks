package ru.romanow

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class RemovingStarsFromAStringTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – String {0} after removing '*' is {1}")
    fun removeStars(s: String, result: String) {
        val obj = RemovingStarsFromAString()
        assertThat(obj.removeStars(s)).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of("leet**cod*e", "lecoe"),
                Arguments.of("erase*****", ""),
                Arguments.of("abb*cdfg*****x*", "a")
            )
    }
}
