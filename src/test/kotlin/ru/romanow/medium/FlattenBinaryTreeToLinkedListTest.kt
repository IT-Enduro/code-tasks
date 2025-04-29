package ru.romanow.medium

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import ru.romanow.models.buildListFromTree
import ru.romanow.models.buildTreeFromList
import java.util.stream.Stream

class FlattenBinaryTreeToLinkedListTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – Binary tree {0} flatten into {1}")
    fun flatten(items: List<Int?>, result: List<Int>) {
        val root = buildTreeFromList(items)

        val obj = FlattenBinaryTreeToLinkedList()
        obj.flatten(root)
        val list = buildListFromTree(root)
        assertThat(list).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    listOf(1, 2, 5, 3, 4, null, 6),
                    listOf(1, null, 2, null, 3, null, 4, null, 5, null, 6)
                ),
                Arguments.of(listOf<Int?>(), listOf<Int?>()),
                Arguments.of(listOf<Int?>(0), listOf<Int?>(0))
            )
    }
}
