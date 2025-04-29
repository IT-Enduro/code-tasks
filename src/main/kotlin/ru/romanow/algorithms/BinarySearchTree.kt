package ru.romanow.algorithms

import ru.romanow.models.TreeNode

class BinarySearchTree {
    fun find(root: TreeNode?, target: Int): TreeNode? {
        return when {
            root == null -> null
            target == root.value -> root
            target < root.value -> find(root.left, target)
            else -> find(root.right, target)
        }
    }
}
