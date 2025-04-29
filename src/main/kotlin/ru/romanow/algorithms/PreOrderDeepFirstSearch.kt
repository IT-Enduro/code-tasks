package ru.romanow.algorithms

import ru.romanow.models.TreeNode

class PreOrderDeepFirstSearch {
    fun traverse(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        traverse(root, result)
        return result
    }

    private fun traverse(node: TreeNode?, accumulator: MutableList<Int>) {
        if (node == null) {
            return
        }
        // print("${node.value} ")
        accumulator.add(node.value)
        traverse(node.left, accumulator)
        traverse(node.right, accumulator)
    }
}
