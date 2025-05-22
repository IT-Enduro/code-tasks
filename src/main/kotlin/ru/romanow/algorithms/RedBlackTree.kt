package ru.romanow.algorithms

import ru.romanow.models.TNode

class RedBlackTree {
    private var root: TreeNode? = null

    fun get(key: Int): Int? {
        var current = root
        while (current != null) {
            current =
                when {
                    key < current.key -> current.left
                    key > current.key -> current.right
                    else -> return current.value
                }
        }
        return null
    }

    internal class TreeNode(
        override var key: Int,
        override var value: Int,
        var color: Boolean = false,
        override var left: TreeNode?,
        override var right: TreeNode?
    ) : TNode<TreeNode>
}
