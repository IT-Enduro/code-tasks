package ru.romanow.algorithms

import ru.romanow.models.TreeNode

class InOrderDeepFirstSearch {
    fun traverse(node: TreeNode?): List<Int> {
        if (node == null) {
            return emptyList()
        }
        return traverse(node.left) +
            listOf(node.value) +
            traverse(node.right)
    }
}
