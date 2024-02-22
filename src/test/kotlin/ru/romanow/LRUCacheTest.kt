package ru.romanow

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import ru.romanow.OperationType.GET
import ru.romanow.OperationType.PUT
import java.util.stream.Stream

class LRUCacheTest {

    @ParameterizedTest
    @ArgumentsSource(ValueProvider::class)
    fun test(operations: List<Operation>) {
        val cache = LRUCache(2)
        for (op in operations) {
            when (op.type) {
                GET -> assertThat(cache.get(op.key)).isEqualTo(op.value)
                PUT -> cache.put(op.key, op.value)
            }
        }
    }

    internal class ValueProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    listOf(
                        Operation(PUT, 1, 1),
                        Operation(PUT, 2, 2),
                        Operation(GET, 1, 1),
                        Operation(PUT, 3, 3),
                        Operation(GET, 2, -1),
                        Operation(PUT, 4, 4),
                        Operation(GET, 1, -1),
                        Operation(GET, 3, 3),
                        Operation(GET, 4, 4)
                    )
                ),
                Arguments.of(
                    listOf(
                        Operation(PUT, 2, 1),
                        Operation(PUT, 2, 2),
                        Operation(GET, 2, 2),
                        Operation(PUT, 1, 1),
                        Operation(PUT, 4, 1),
                        Operation(GET, 2, -1)
                    )
                )
            )
    }
}

data class Operation(
    val type: OperationType,
    val key: Int,
    val value: Int,
)

enum class OperationType {
    PUT,
    GET
}
