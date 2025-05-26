package ru.romanow.algorithms

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import ru.romanow.models.buildTreeFromList
import java.util.stream.Stream

class BreadthFirstSearchTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – Bfs {0} is {1}")
    fun test(items: List<Int?>, result: List<Int>) {
        val root = buildTreeFromList(items)
        // printTree(root)

        val obj = BreadthFirstSearch()
        assertThat(obj.traverse(root)).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(Arguments.of(listOf(10, 5, 15, 3, 7, 12, 20), listOf(10, 5, 15, 3, 7, 12, 20)))
    }
}
