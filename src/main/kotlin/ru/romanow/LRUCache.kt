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
class LRUCache(private val capacity: Int) {

    private val dict: MutableMap<Int, Node>
    private val head: Node
    private val tail: Node

    init {
        this.dict = HashMap(capacity)
        this.head = Node()
        this.tail = Node(prev = head)
        this.head.next = this.tail
    }

    // если берем ключ, то добавляем эту в голову
    fun get(key: Int): Int {
        if (dict.containsKey(key)) {
            val node = dict[key]!!
            deleteNode(node)
            addToHead(node)
            return node.value!!
        }
        return -1
    }

    fun put(key: Int, value: Int) {
        if (dict.containsKey(key)) {
            // если запись есть, то она всплывает наверх
            val node = dict[key]!!
            node.value = value
            deleteNode(node)
            addToHead(node)
        } else {
            if (dict.size == capacity) {
                // удаляем последнюю запись
                val node = tail.prev!!
                dict.remove(node.key)
                deleteNode(node)
            }
            val node = Node(key = key, value = value)
            addToHead(node)
            dict[key] = node
        }
    }

    private fun addToHead(node: Node) {
        val next = head.next!!
        // head ссылается на новую запись
        head.next = node
        // node.prev ссылается на head
        node.prev = head
        // node.next ссылается на предыдущую запись
        node.next = next
        // предыдущая запись ссылается next.prev на текущую
        next.prev = node
    }

    private fun deleteNode(node: Node) {
        val prev = node.prev
        // указатель next от предыдущей записи ссылается на следующую
        node.prev?.next = node.next
        node.next?.prev = prev
    }
}

data class Node(
    var key: Int? = null,
    var value: Int? = null,
    var prev: Node? = null,
    var next: Node? = null
) {
    override fun toString(): String {
        return "Node(key=$key, value=$value, next.key=${next?.key}, prev.key=${prev?.key}"
    }
}
