package ru.romanow

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LRUCacheTest {

    @Test
    fun test() {
        val cache = LRUCache(2)
        cache.put(1, 1)
        cache.put(2, 2)
        assertThat(cache.get(1)).isEqualTo(1)
        cache.put(3, 3)
        assertThat(cache.get(2)).isEqualTo(-1)
        cache.put(4, 4)
        assertThat(cache.get(1)).isEqualTo(-1)
        assertThat(cache.get(3)).isEqualTo(3)
        assertThat(cache.get(4)).isEqualTo(4)
    }
}
