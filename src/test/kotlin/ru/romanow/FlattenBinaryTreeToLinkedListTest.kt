package ru.romanow

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class FlattenBinaryTreeToLinkedListTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – Binary tree {0} flatten into {1}")
    fun flatten(values: List<Int>, result: List<Int>) {
        val obj = FlattenBinaryTreeToLinkedList()
        Assertions.assertThat(obj.flatten(null)).isEqualTo(null)
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
