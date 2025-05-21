package ru.romanow.models

import java.util.*

interface TNode<T : TNode<T>> {
    var key: Int
    var value: Int
    var left: T?
    var right: T?
}

class TreeNode(
    override var key: Int,
    override var value: Int = key,
    override var left: TreeNode? = null,
    override var right: TreeNode? = null
) : TNode<TreeNode> {
    override fun toString(): String {
        return "TreeNode(key=$key, value=$value, left=${left?.key}, right=${right?.key})"
    }
}

fun printTree(node: TNode<*>?, level: Int = 0) {
    if (node == null) return
    print("  ".repeat(level))
    println("├─ $node")
    printTree(node.left, level + 1)
    printTree(node.right, level + 1)
}

fun buildListFromTree(root: TNode<*>?): List<Int?> {
    val list = ArrayList<Int?>()
    if (root != null) {
        val queue = LinkedList<TNode<*>?>()
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
        node = TreeNode(key = values[index]!!)
        node.left = buildTreeFromList(values, 2 * index + 1)
        node.right = buildTreeFromList(values, 2 * index + 2)
    }
    return node
}
