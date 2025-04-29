package ru.romanow.easy

import ru.romanow.models.ListNode

/**
 * Дан указатель на первый элемент в односвязном списке.
 * Верните элемент в середине списка. Если средних элементов два, то вернуть второй.
 *
 * [https://leetcode.com/problems/middle-of-the-linked-list/](https://leetcode.com/problems/middle-of-the-linked-list)
 */
class MiddleOfTheLinkedList {
    fun middleNode(head: ListNode?): ListNode? {
        var current: ListNode? = head
        var middle: ListNode? = head
        while (current?.next != null) {
            current = current.next?.next
            middle = middle?.next
        }

        return middle
    }
}
