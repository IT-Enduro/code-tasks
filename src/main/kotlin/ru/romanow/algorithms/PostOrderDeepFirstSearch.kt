package ru.romanow.algorithms

import ru.romanow.models.TreeNode

class PostOrderDeepFirstSearch {
    fun traverse(node: TreeNode?): List<Int> {
        if (node == null) {
            return emptyList()
        }
        return traverse(node.right) +
            traverse(node.left) +
            listOf(node.value)
    }
}
