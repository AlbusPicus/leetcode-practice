/**
 * Runtime: 396 ms, faster than 21.88% of Kotlin online submissions for Sort List.
 * Memory Usage: 51.9 MB, less than 9.38% of Kotlin online submissions for Sort List.
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
        
        val nodesMap = mutableMapOf<Int, MutableList<ListNode>>()
        var node = head
        while (node != null) {
            val savedNodes = nodesMap.getOrElse(node.`val`, { mutableListOf() })
            savedNodes.add(node)
            nodesMap[node.`val`] = savedNodes
            node = node.next
        }
        
        var resultHead: ListNode? = null
        var resultNode: ListNode? = null
        nodesMap.keys.sorted().forEach { key ->
            nodesMap[key]?.forEach { node ->
                if (resultHead == null) {
                    resultHead = node
                    resultNode = resultHead
                } else {
                    resultNode?.next = node
                    resultNode = node
                }
                node.next = null
            }   
        }
        return resultHead
    }
}
