/**
 * Runtime: 204 ms, faster than 93.59% of Kotlin online submissions for Palindrome Linked List.
 * Memory Usage: 40.1 MB, less than 92.95% of Kotlin online submissions for Palindrome Linked List.
 */
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        if (head == null) return true
        
        var size = 0
        var node = head
        while (node != null) {
            size++
            node = node.next
        }

        node = head
        for (i in 0 until size / 2) {
            node = node!!.next
        }
        val skipNode = size % 2 == 1
        if (skipNode) {
            node = node!!.next
        }
        
        var reversed = node
        var reversedNext = node?.next
        reversed?.next = null
        
        while (reversed != null && reversedNext != null) {
            val next = reversedNext.next
            reversedNext.next = reversed
            reversed = reversedNext
            reversedNext = next
        }
        
        node = head
        while (reversed != null && node != null) {
            if (reversed.`val` != node.`val`) return false
            reversed = reversed.next
            node = node.next
        }
        
        return true
    }
}
