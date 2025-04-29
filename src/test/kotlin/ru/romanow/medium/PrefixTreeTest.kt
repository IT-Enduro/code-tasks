package ru.romanow.medium

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import ru.romanow.medium.PrefixTreeTest.OperationType.INSERT
import ru.romanow.medium.PrefixTreeTest.OperationType.SEARCH
import ru.romanow.medium.PrefixTreeTest.OperationType.START_WITH
import java.util.stream.Stream

class PrefixTreeTest {

    @ParameterizedTest
    @ArgumentsSource(ValueProvider::class)
    fun test(operations: List<Operation>) {
        val obj = PrefixTree()
        for (op in operations) {
            when (op.type) {
                INSERT -> obj.insert(op.value)
                SEARCH -> assertThat(obj.search(op.value)).isEqualTo(op.result)
                START_WITH -> assertThat(obj.startsWith(op.value)).isEqualTo(op.result)
            }
        }
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    listOf(
                        Operation(INSERT, "apple"),
                        Operation(SEARCH, "apple", true),
                        Operation(SEARCH, "app", false),
                        Operation(START_WITH, "app", true),
                        Operation(INSERT, "app"),
                        Operation(SEARCH, "app", true)
                    )
                )
            )
    }

    data class Operation(
        val type: OperationType,
        val value: String,
        val result: Boolean? = null,
    )

    enum class OperationType {
        INSERT,
        SEARCH,
        START_WITH
    }
}
