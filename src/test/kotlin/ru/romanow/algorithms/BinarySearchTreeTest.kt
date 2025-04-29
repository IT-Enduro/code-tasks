package ru.romanow.algorithms

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import ru.romanow.models.buildTreeFromList
import java.util.stream.Stream

class BinarySearchTreeTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – Search {1} in tree {0}")
    fun flatten(items: List<Int?>, target: Int, result: Int?) {
        val root = buildTreeFromList(items)
        val obj = BinarySearchTree()
        assertThat(obj.find(root, target)?.value).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of(listOf(10, 5, 15, 3, 7, 12, 20), 20, 20),
                Arguments.of(listOf(10, 5, 15, 3, 7, 12, 20), 0, null)
            )
    }
}
