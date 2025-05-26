package ru.romanow.algorithms

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class BinarySearchListTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – Search {1} in tree {0}")
    fun test(list: List<Int>, target: Int, result: Int?) {
        val obj = BinarySearchList()
        assertThat(obj.find(list, target)).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of(listOf(1, 3, 5, 7, 10, 12, 15), 3, 1),
                Arguments.of(listOf(1, 3, 5, 7, 10, 12, 15), 14, -1)
            )
    }
}
