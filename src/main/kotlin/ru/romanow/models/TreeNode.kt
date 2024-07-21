package ru.romanow.models

import java.util.LinkedList

class TreeNode {
    var value: Int? = null
    var left: TreeNode? = null
    var right: TreeNode? = null

    constructor(value: Int?) {
        this.value = value
    }

    constructor(value: Int?, left: TreeNode?, right: TreeNode?) {
        this.value = value
        this.left = left
        this.right = right
    }

    override fun toString(): String {
        return "TreeNode(value=$value, left=${left?.value}, right=${right?.value})"
    }
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

fun buildTreeFromList(values: List<Int?>, index: Int): TreeNode? {
    var node: TreeNode? = null
    if (index < values.size && values[index] != null) {
        node = TreeNode(value = values[index])
        node.left = buildTreeFromList(values, 2 * index + 1)
        node.right = buildTreeFromList(values, 2 * index + 2)
    }
    return node
}
