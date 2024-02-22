package ru.romanow

/**
 * @see [LRUCache](LRUCache)
 */
class LRUCacheLinkedList(private val capacity: Int) {

    private val dict: MutableMap<Int, Int>

    init {
        this.dict =
            object : LinkedHashMap<Int, Int>(capacity, 0.75f, true) {
                override fun removeEldestEntry(eldest: Map.Entry<Int, Int>): Boolean {
                    return size > capacity
                }
            }
    }

    fun get(key: Int): Int {
        return dict.getOrDefault(key, -1)
    }

    fun put(key: Int, value: Int) {
        dict[key] = value
    }
}
