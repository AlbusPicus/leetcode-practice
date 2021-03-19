/**
 * Runtime: 192 ms, faster than 96.88% of Kotlin online submissions for Merge k Sorted Lists.
 * Memory Usage: 36.9 MB, less than 89.06% of Kotlin online submissions for Merge k Sorted Lists.
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
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        var resultHead = ListNode(-1)
        var resultNode = resultHead
        var nodesHeap = PriorityQueue<ListNode>() { node1, node2 -> node1.`val` - node2.`val` }
        lists.forEach { head ->
            head?.let { nodesHeap.offer(it) }
        }
        while (nodesHeap.isNotEmpty()) {
            val node = nodesHeap.poll()
            resultNode.next = node
            node.next?.let { nodesHeap.offer(it) }
            node.next = null
            resultNode = node
        }
        return resultHead.next
    }
}
