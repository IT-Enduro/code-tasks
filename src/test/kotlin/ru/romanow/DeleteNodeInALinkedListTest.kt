package ru.romanow

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import ru.romanow.models.ListNode
import java.util.stream.Stream

class DeleteNodeInALinkedListTest {

    @ParameterizedTest
    @ArgumentsSource(ValueProvider::class)
    fun deleteNode(values: IntArray, target: Int, result: List<Int>) {
        val obj = DeleteNodeInALinkedList()

        var targetNode: ListNode? = null
        var current: ListNode? = null
        for (i in values.size - 1 downTo 0) {
            current = ListNode(values[i], current)
            if (values[i] == target) {
                targetNode = current
            }
        }

        obj.deleteNode(targetNode)

        val items = mutableListOf<Int>()
        while (current != null) {
            items.add(current.value!!)
            current = current.next
        }

        assertThat(items).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of(intArrayOf(4, 5, 1, 9), 5, listOf(4, 1, 9)),
                Arguments.of(intArrayOf(4, 5, 1, 9), 1, listOf(4, 5, 9))
            )
    }
}
