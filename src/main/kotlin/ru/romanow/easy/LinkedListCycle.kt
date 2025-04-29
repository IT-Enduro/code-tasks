package ru.romanow.easy

import ru.romanow.models.ListNode

/**
 * Дан указатель на голову связного списка, определить, есть ли в нем цикл.
 *
 * В связанном списке существует цикл, если в списке есть некоторый узел, к которому можно снова добраться,
 * непрерывно следуя по следующему указателю.
 *
 * Вернуть `true`, если в связном списке есть цикл, `false` иначе.
 *
 * [https://leetcode.com/problems/linked-list-cycle/](https://leetcode.com/problems/linked-list-cycle/)
 */
class LinkedListCycle {
    fun hasCycle(head: ListNode?): Boolean {
        if (head == null) {
            return false
        }
        var slow = head
        var fast = head.next
        while (fast?.next != null && fast != slow) {
            slow = slow?.next
            fast = fast.next?.next
        }
        return fast == slow
    }
}
