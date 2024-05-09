package ru.romanow

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class SearchIn2dMatrixTest {

    @ArgumentsSource(ValueProvider::class)
    @ParameterizedTest(name = "#{index} – is matrix contains {1} – {2}")
    fun searchMatrix(matrix: Array<IntArray>, target: Int, result: Boolean) {
        val obj = SearchIn2dMatrix()
        assertThat(obj.searchMatrix(matrix, target)).isEqualTo(result)
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                of(arrayOf(intArrayOf(1, 3, 5, 7), intArrayOf(10, 11, 16, 20), intArrayOf(23, 30, 34, 60)), 13, false),
                of(arrayOf(intArrayOf(1, 3, 5, 7), intArrayOf(10, 11, 16, 20), intArrayOf(23, 30, 34, 60)), 34, true),
                of(arrayOf(intArrayOf(1, 1)), 2, false)
            )
    }
}
