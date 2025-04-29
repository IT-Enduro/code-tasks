package ru.romanow.algorithms

import ru.romanow.models.TreeNode

class PreOrderDeepFirstSearch {
    fun traverse(node: TreeNode?): List<Int> {
        if (node == null) {
            return emptyList()
        }
        return listOf(node.value) +
            traverse(node.left) +
            traverse(node.right)
    }
}
