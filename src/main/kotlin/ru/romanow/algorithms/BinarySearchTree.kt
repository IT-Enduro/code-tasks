package ru.romanow.algorithms

import ru.romanow.models.TreeNode

class BinarySearchTree {
    internal var root: TreeNode? = null

    fun get(key: Int): Int? {
        var current = root
        while (current != null) {
            current = when {
                key < current.key -> current.left
                key > current.key -> current.right
                else -> return current.value
            }
        }
        return null
    }

    fun put(key: Int, value: Int = key) {
        root = insert(root, key, value)
    }

    fun remove(key: Int) {
        root = remove(root, key)
    }

    private fun insert(node: TreeNode?, key: Int, value: Int = key): TreeNode {
        if (node == null) {
            return TreeNode(key, value)
        }
        when {
            key < node.key -> node.left = insert(node.left, key, value)
            key > node.key -> node.right = insert(node.right, key, value)
            else -> node.value = value
        }
        return node
    }

    private fun remove(node: TreeNode?, key: Int): TreeNode? {
        if (node == null) {
            return null
        }
        when {
            key < node.key -> node.left = remove(node.left, key)
            key > node.key -> node.right = remove(node.right, key)
            else -> {
                if (node.left == null) {
                    return node.right
                }
                if (node.right == null) {
                    return node.left
                }

                val minNode = findMin(node.right!!)
                node.key = minNode.key
                node.value = minNode.value
                node.right = remove(node.right, minNode.key)
            }
        }
        return node
    }

    private fun findMin(node: TreeNode): TreeNode {
        var current = node
        while (current.left != null) {
            current = current.left!!
        }
        return current
    }
}
