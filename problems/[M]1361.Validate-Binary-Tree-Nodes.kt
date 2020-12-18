/**
 * Runtime: 320 ms, faster than 33.33% of Kotlin online submissions for Validate Binary Tree Nodes.
 * Memory Usage: 38.7 MB, less than 33.33% of Kotlin online submissions for Validate Binary Tree Nodes.
 */
class Solution {
    fun validateBinaryTreeNodes(n: Int, leftChild: IntArray, rightChild: IntArray): Boolean {
        val topmostParentIndex = findTopmostParentIndex(n, leftChild, rightChild)
        return topmostParentIndex != null && getNumberOfChilds(topmostParentIndex, leftChild, rightChild) == n
    }
    
    /**
     * Returns -1 in case of circular dependency
     */
    fun getNumberOfChilds(topmostNodeIndex: Int, leftChild: IntArray, rightChild: IntArray): Int {
        val visitedNodes = mutableSetOf<Int>()
        val queuedNodes = LinkedList<Int>()
        queuedNodes.offerLast(topmostNodeIndex)
        while (queuedNodes.isNotEmpty()) {
            val node = queuedNodes.pollFirst()
            if (node in visitedNodes) {
                return -1
            }
            if (leftChild[node] != NO_CHILD_INDEX) {
                queuedNodes.offerLast(leftChild[node])
            }
            if (rightChild[node] != NO_CHILD_INDEX) {
                queuedNodes.offerLast(rightChild[node])
            }
            visitedNodes.add(node)
        }
        return visitedNodes.size
    }
    
    fun findTopmostParentIndex(n: Int, leftChild: IntArray, rightChild: IntArray): Int? {
        val nodesWithParent = mutableSetOf<Int>()
        val nodesWithoutParent = mutableSetOf<Int>()
        for (index in 0 until n) {
            val leftValue = leftChild[index]
            val rightValue = rightChild[index]
            if (leftValue in nodesWithParent || rightValue in nodesWithParent) {
                return null
            } else {
                if (leftValue in nodesWithoutParent) {
                    nodesWithoutParent.remove(leftValue)
                }
                if (rightValue in nodesWithoutParent) {
                    nodesWithoutParent.remove(rightValue)
                }
                if (index !in nodesWithoutParent && index !in nodesWithParent) {
                    nodesWithoutParent.add(index)
                }
                if (leftValue != NO_CHILD_INDEX) {
                    nodesWithParent.add(leftValue)
                }
                if (rightValue != NO_CHILD_INDEX) {
                    nodesWithParent.add(rightValue)
                }
            }
        }
        return nodesWithoutParent.firstOrNull()
    }
    
    companion object {
        const val NO_CHILD_INDEX = -1
    }
}
