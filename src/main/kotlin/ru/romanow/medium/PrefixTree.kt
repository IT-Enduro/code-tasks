package ru.romanow.medium

/**
 * [Префиксное дерево](https://en.wikipedia.org/wiki/Trie) – это древовидная структура данных, используемая
 * для эффективного хранения и извлечения ключей в наборе строк. Существуют различные приложения этой структуры данных,
 * такие как автозаполнение и проверка орфографии.
 *
 * Необходимо реализовать префиксное дерево с методами:
 * * `fun insert(word: String)` – вставляет слово в префиксное дерево.
 * * `fun search(word: String): Boolean` – возвращает `true`, если дерево содержит слово, `false` иначе.
 * * `fun startsWith(prefix: String): Boolean` – возвращает `true`, если в дереве есть слово, начинающееся
 *   с этого префикса, `false` иначе.
 *
 * [https://leetcode.com/problems/implement-trie-prefix-tree/](https://leetcode.com/problems/implement-trie-prefix-tree/)
 */
class PrefixTree {
    private val root = TrieNode()

    fun insert(word: String) {
        var node = root
        for (chr in word) {
            node = node.children.getOrPut(chr) { TrieNode() }
        }
        node.isEndOfWord = true
    }

    fun search(word: String): Boolean {
        return find(word)?.isEndOfWord == true
    }

    fun startsWith(prefix: String): Boolean {
        return find(prefix) != null
    }

    private fun find(word: String): TrieNode? {
        var node = root
        for (chr in word) {
            node = node.children[chr] ?: return null
        }
        return node
    }

    private data class TrieNode(
        val children: MutableMap<Char, TrieNode> = mutableMapOf(),
        var isEndOfWord: Boolean = false,
    )
}
