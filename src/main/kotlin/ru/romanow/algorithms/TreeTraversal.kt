package ru.romanow.algorithms

import ru.romanow.models.TreeNode
import ru.romanow.models.buildTreeFromList
import java.util.*

fun main() {
    val root = buildTreeFromList(listOf(10, 5, 15, 3, 7, 12, 20))
    printTree(root)
    preOrder(root)
    println()
    inOrder(root)
    println()
    postOrder(root)
    println()
    bfs(root)
}

private fun printTree(node: TreeNode?, level: Int = 0) {
    if (node == null) return
    print("  ".repeat(level))
    println("├─ ${node.value}")
    printTree(node.left, level + 1)
    printTree(node.right, level + 1)
}

private fun preOrder(node: TreeNode?) {
    if (node == null) {
        return
    }
    print("${node.value} ")
    preOrder(node.left)
    preOrder(node.right)
}

private fun inOrder(node: TreeNode?) {
    if (node == null) {
        return
    }
    inOrder(node.left)
    print("${node.value} ")
    inOrder(node.right)
}

private fun postOrder(node: TreeNode?) {
    if (node == null) {
        return
    }
    postOrder(node.left)
    postOrder(node.right)
    print("${node.value} ")
}

private fun bfs(root: TreeNode?) {
    if (root == null) {
        return
    }

    val queue = LinkedList<TreeNode>()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val node = queue.poll()
        print("${node.value} ")

        node.left?.let { queue.add(it) }
        node.right?.let { queue.add(it) }
    }
}
