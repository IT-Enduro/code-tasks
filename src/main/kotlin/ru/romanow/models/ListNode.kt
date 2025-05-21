package ru.romanow.models

open class ListNode(var value: Int?, var next: ListNode? = null) {
    override fun toString(): String {
        return "ListNode(value=$value, next=${next?.value})"
    }
}
