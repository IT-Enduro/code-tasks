package ru.romanow

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
    fun insert(word: String) {
    }

    fun search(word: String): Boolean {
        return false
    }

    fun startsWith(prefix: String): Boolean {
        return false
    }
}
