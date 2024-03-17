package ru.romanow.models

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
