package ru.romanow

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import ru.romanow.models.ListNode
import java.util.stream.Stream

class MiddleOfTheLinkedListTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – Middle element for {0} is {1}")
    fun middleNode(values: IntArray, result: Int) {
        var current: ListNode? = null
        for (i in values.size - 1 downTo 0) {
            current = ListNode(values[i], current)
        }

        val obj = MiddleOfTheLinkedList()
        Assertions.assertThat(obj.middleNode(current))
            .extracting("value")
            .isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of(intArrayOf(1, 2, 3, 4, 5), 3),
                Arguments.of(intArrayOf(1, 2, 3, 4, 5, 6), 4)
            )
    }
}
