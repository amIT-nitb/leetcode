/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

/*
 * 2. Add Two Numbers  (Medium)
 *
 * Approach: long-addition, digit by digit, in the order the lists already give us.
 *   Both lists store digits least-significant first, exactly the order we'd add by
 *   hand. Walk both at once, sum digits + carry, build the result list, propagate
 *   carry. Loop continues while EITHER list has digits left OR a carry is pending
 *   — that final carry can produce a new top digit (e.g. 5 + 5 -> "10").
 *
 * Time: O(max(n, m))   Space: O(max(n, m))
 */
class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var curr = dummy
        var p1 = l1
        var p2 = l2
        var carry = 0
        // loop while either input has digits OR a final carry needs a new digit
        while (p1 != null || p2 != null || carry != 0) {
            val x = p1?.`val` ?: 0
            val y = p2?.`val` ?: 0
            val sum = x + y + carry
            carry = sum / 10
            curr.next = ListNode(sum % 10)
            curr = curr.next!!
            p1 = p1?.next
            p2 = p2?.next
        }
        return dummy.next
    }
}
