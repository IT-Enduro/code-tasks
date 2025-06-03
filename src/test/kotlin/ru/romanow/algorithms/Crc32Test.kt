package ru.romanow.algorithms

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream
import kotlin.text.HexFormat.Companion.UpperCase

class Crc32Test {

    @OptIn(ExperimentalStdlibApi::class)
    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – crc32 {0} is {1}")
    fun sort(data: String, expected: String) {
        val obj = Crc32()
        val result = obj.compute(data.toByteArray())
        assertThat(result.toHexString(UpperCase)).isEqualTo(expected)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of("hello", "1931653D"),
                Arguments.of("test", "338BCFAC"),
                Arguments.of("twentysix", "C07BD465")
            )
    }
}
