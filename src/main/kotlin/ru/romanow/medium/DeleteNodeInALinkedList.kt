package ru.romanow.medium

import ru.romanow.models.ListNode

/**
 * Нужно удалить ноду из односвязного списка. На вход передается нода, которую нужно удалить,
 * обходить весь список не надо. Все значения в списке уникальны, и гарантируется, что нода не является последней.
 *
 * Под удалением ноды не подразумевается удаление ее из памяти, требуется чтобы:
 * * Значение данного узла не должно существовать в связанном списке.
 * * Количество узлов в связанном списке должно уменьшиться на один.
 * * Все значения перед узлом должны быть в одном порядке.
 * * Все значения после узла должны быть в том же порядке.
 *
 * [https://leetcode.com/problems/delete-node-in-a-linked-list/](https://leetcode.com/problems/delete-node-in-a-linked-list/)
 */
class DeleteNodeInALinkedList {
    fun deleteNode(node: ListNode?) {
        val next = node?.next
        node?.value = next?.value
        node?.next = next?.next
    }
}
