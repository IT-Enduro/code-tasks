package ru.romanow.models

class ListNode {
    var value: Int? = null
    var next: ListNode? = null

    constructor(value: Int) {
        this.value = value
    }

    constructor(value: Int, next: ListNode?) {
        this.value = value
        this.next = next
    }

    override fun toString(): String {
        return "ListNode(value=$value, next=${next?.value})"
    }
}
