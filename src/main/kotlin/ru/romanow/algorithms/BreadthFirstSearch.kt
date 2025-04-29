package ru.romanow.algorithms

import ru.romanow.models.TreeNode
import java.util.LinkedList

class BreadthFirstSearch {
    fun traverse(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        if (root == null) {
            return result
        }

        val queue = LinkedList<TreeNode>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            // print("${node.value} ")
            result.add(node.value)
            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }
        }
        return result
    }
}
