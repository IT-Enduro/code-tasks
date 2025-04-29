package ru.romanow.models

import java.util.LinkedList
import kotlin.collections.ArrayList

data class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun printTree(node: TreeNode?, level: Int = 0) {
    if (node == null) return
    print("  ".repeat(level))
    println("├─ ${node.value}")
    printTree(node.left, level + 1)
    printTree(node.right, level + 1)
}

fun buildListFromTree(root: TreeNode?): List<Int?> {
    val list = ArrayList<Int?>()
    if (root != null) {
        val queue = LinkedList<TreeNode?>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val head = queue.pop()
            list.add(head?.value)

            if (head != null && (head.left != null || head.right != null)) {
                queue.add(head.left)
                queue.add(head.right)
            }
        }
    }

    return list
}

fun buildTreeFromList(values: List<Int?>, index: Int = 0): TreeNode? {
    var node: TreeNode? = null
    if (index < values.size && values[index] != null) {
        node = TreeNode(value = values[index]!!)
        node.left = buildTreeFromList(values, 2 * index + 1)
        node.right = buildTreeFromList(values, 2 * index + 2)
    }
    return node
}
