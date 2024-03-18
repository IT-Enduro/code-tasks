package ru.romanow

import ru.romanow.models.TreeNode

/**
 * Дано двоичное дерево, требуется развернуть его в связный список:
 * * Связанный список должен использовать тот же класс `TreeNode`, где правый дочерний указатель указывает
 *   на следующий узел в списке, а левый дочерний указатель всегда имеет значение `null`.
 * * Обход дерева выполняется в [прямом порядке](https://en.wikipedia.org/wiki/Tree_traversal#Pre-order,_NLR)
 *
 * [https://leetcode.com/problems/flatten-binary-tree-to-linked-list/](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)
 */
class FlattenBinaryTreeToLinkedList {
    fun flatten(root: TreeNode?) {
        flattenSubtree(root)
    }

    private fun flattenSubtree(node: TreeNode?): TreeNode? {
        if (node == null) {
            return null
        }

        val right = node.right
        node.right = node.left
        node.left = null
        val leftSubtree = flattenSubtree(node.right)
        if (leftSubtree == null) {
            node.right = right
        } else {
            leftSubtree.right = right
        }
        return flattenSubtree(right) ?: leftSubtree ?: node
    }
}
