package ru.romanow

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import ru.romanow.models.ListNode
import java.util.stream.Stream

class LinkedListCycleTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – Does list {0} has cycles: {1}")
    fun hasCycle(values: List<Int>, result: Boolean) {
        var head: ListNode? = null
        if (values.isNotEmpty()) {
            head = ListNode(values[0])
            var current = head

            val items = HashMap<Int, ListNode>()
            for (i in 1 until values.size) {
                val value = values[i]
                if (values[i] in items) {
                    current?.next = items[value]
                } else {
                    val node = ListNode(value)
                    items[value] = node
                    current?.next = node
                    current = current?.next
                }
            }
        }

        val obj = LinkedListCycle()
        assertThat(obj.hasCycle(head)).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of(listOf(3, 2, 0, -4, 2), true),
                Arguments.of(listOf(1, 2, 1), true),
                Arguments.of(listOf(1), false)
            )
    }
}
