package ru.romanow.easy

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class HammingWeightTest {

    @ParameterizedTest(name = "#{index} – {0} contains {1} non-zero digits")
    @ArgumentsSource(ValueProvider::class)
    fun hammingWeight(num: Int, result: Int) {
        val obj = HammingWeight()
        assertThat(obj.hammingWeight(num)).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of(11, 3),
                Arguments.of(128, 1),
                Arguments.of(-3, 31)
            )
    }
}
