package ru.romanow.algorithms

import ru.romanow.models.TreeNode

class PostOrderDeepFirstSearch {
    fun traverse(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        traverse(root, result)
        return result
    }

    private fun traverse(node: TreeNode?, accumulator: MutableList<Int>) {
        if (node == null) {
            return
        }
        traverse(node.left, accumulator)
        traverse(node.right, accumulator)
        // print("${node.value} ")
        accumulator.add(node.value)
    }
}
