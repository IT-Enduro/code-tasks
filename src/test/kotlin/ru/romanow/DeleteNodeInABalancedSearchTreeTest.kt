package ru.romanow

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import ru.romanow.models.buildListFromTree
import ru.romanow.models.buildTreeFromList
import java.util.stream.Stream

class DeleteNodeInABalancedSearchTreeTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – Tree {0} after removing key {1} is {2}")
    fun deleteNode(values: List<Int?>, key: Int, expectedResult: List<Int?>) {
        val obj = DeleteNodeInABalancedSearchTree()
        val root = buildTreeFromList(values, 0)
        val result = buildListFromTree(obj.deleteNode(root, key))
        assertThat(result).isEqualTo(expectedResult)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of(listOf(5, 3, 6, 2, 4, null, 7), 3, listOf(5, 4, 6, 2, null, null, 7)),
                Arguments.of(listOf(5, 3, 6, 2, 4, null, 7), 0, listOf(5, 3, 6, 2, 4, null, 7)),
                Arguments.of(listOf<Int?>(), 0, listOf<Int?>())

            )
    }
}
