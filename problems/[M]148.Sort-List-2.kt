/**
 * Runtime: 300 ms, faster than 71.88% of Kotlin online submissions for Sort List.
 * Memory Usage: 44.6 MB, less than 93.75% of Kotlin online submissions for Sort List.
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
    fun sortList(head: ListNode?): ListNode? {
        if (head == null) return null
        
        val heap = PriorityQueue<ListNode>() { o1, o2 -> o1.`val` - o2.`val` }
        var node = head
        while (node != null) {
            heap.offer(node)
            node = node.next
        }
        
        var resultHead: ListNode? = heap.poll()
        var resultNode: ListNode? = resultHead
        while (heap.isNotEmpty()) {
            resultNode?.next = heap.poll()
            resultNode = resultNode?.next
        }
        resultNode?.next = null
        
        return resultHead
    }
}
