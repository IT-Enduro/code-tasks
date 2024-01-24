package ru.romanow

/**
 * Спроектируйте структуру данных, которая реализует кэш ограниченного размера,
 * работающего по принципу [least recently used](https://en.wikipedia.org/wiki/Cache_replacement_policies#LRU).
 *
 * Реализуйте класс `LRUCache`:
 * * `constructor LRUCache(int capacity)` – создать LRU кэш с заданной емкостью (capacity >= 1).
 * * `int get(int key)` – возвращает значение ключа, если ключ существует, в противном случае возвращает -1.
 * * `void put(int key, int value)` – обновить значение ключа, если ключ существует.
 *   В противном случае добавьте пару ключ-значение в кеш. Если количество ключей превышает
 *   емкость этой операции, удалите ключ, который использовался реже всего.
 *
 * Каждая из функций get и put должна выполняться со средней временной сложностью O(1).
 *
 * [https://leetcode.com/problems/lru-cache/](https://leetcode.com/problems/lru-cache/)
 */
class LRUCache(
    private val capacity: Int
) {

    fun get(key: Int): Int {
        return -1
    }

    fun put(key: Int, value: Int) {
    }
}
