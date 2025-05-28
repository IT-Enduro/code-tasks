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

    fun put(key: Int, value: Int = key) {
        root = insert(root, key, value)
        root?.color = false
    }

    fun remove(key: Int) {
    }

    private fun insert(n: TreeNode?, key: Int, value: Int): TreeNode {
        var node = n ?: return TreeNode(key, value)
        when {
            key < node.key -> node.left = insert(node.left, key, value)
            key > node.key -> node.right = insert(node.right, key, value)
            else -> node.value = value
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node)
        }
        if (isRed(node.left) && isRed(node.left?.left)) {
            node = rotateRight(node)
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node)
        }

        return node
    }

    private fun isRed(node: TreeNode?): Boolean {
        return node?.color == true
    }

    private fun rotateLeft(node: TreeNode): TreeNode {
        val right = node.right!!
        node.right = right.left
        right.left = node
        right.color = node.color
        node.color = true
        return right
    }

    private fun rotateRight(node: TreeNode): TreeNode {
        val left = node.left!!
        node.left = left.right
        left.right = node
        left.color = node.color
        node.color = true
        return left
    }

    private fun flipColors(node: TreeNode) {
        node.color = true
        node.left?.color = false
        node.right?.color = false
    }

    internal class TreeNode(
        override var key: Int,
        override var value: Int,
        var color: Boolean = false,
        override var left: TreeNode? = null,
        override var right: TreeNode? = null
    ) : TNode<TreeNode>
}
