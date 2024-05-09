package ru.romanow

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class MajorityElementTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – majority element {1} from array {0}")
    fun majorityElement(nums: IntArray, result: Int) {
        val obj = MajorityElement()
        assertThat(obj.majorityElement(nums)).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of(intArrayOf(3, 2, 3), 3),
                Arguments.of(intArrayOf(2, 2, 1, 1, 1, 2, 2), 2)
            )
    }
}
