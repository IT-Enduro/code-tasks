package ru.romanow

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class GameOfLifeTest {

    @ParameterizedTest
    @ArgumentsSource(ValueProvider::class)
    fun gameOfLife(board: Array<IntArray>, result: Array<IntArray>) {
        val obj = GameOfLife()
        obj.gameOfLife(board)
        assertThat(board).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    arrayOf(intArrayOf(0, 1, 0), intArrayOf(0, 0, 1), intArrayOf(1, 1, 1), intArrayOf(0, 0, 0)),
                    arrayOf(intArrayOf(0, 0, 0), intArrayOf(1, 0, 1), intArrayOf(0, 1, 1), intArrayOf(0, 1, 0))
                ),
                Arguments.of(
                    arrayOf(intArrayOf(1, 1), intArrayOf(1, 0)),
                    arrayOf(intArrayOf(1, 1), intArrayOf(1, 1))
                )
            )
    }
}
