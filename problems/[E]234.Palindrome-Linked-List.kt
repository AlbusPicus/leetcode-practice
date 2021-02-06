/**
 * Runtime: 212 ms, faster than 81.41% of Kotlin online submissions for Palindrome Linked List.
 * Memory Usage: 40.3 MB, less than 82.69% of Kotlin online submissions for Palindrome Linked List.
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
        var size = 0
        var node = head
        while (node != null) {
            size++
            node = node.next
        }
        
        val numsStack = LinkedList<Int>()
        node = head
        for (i in 0 until size / 2) {
            numsStack.offerLast(node!!.`val`)
            node = node!!.next
        }
        val skipNode = size % 2 == 1
        if (skipNode) {
            node = node!!.next
        }
        
        while (node != null) {
            val savedValue = numsStack.pollLast()
            if (savedValue != node.`val`) return false
            node = node.next
        }
        
        return true
    }
}
