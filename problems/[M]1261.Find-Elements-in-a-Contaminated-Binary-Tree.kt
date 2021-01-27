/**
 * Runtime: 260 ms, faster than 75.00% of Kotlin online submissions for Find Elements in a Contaminated Binary Tree.
 * Memory Usage: 50.4 MB, less than 75.00% of Kotlin online submissions for Find Elements in a Contaminated Binary Tree.
 */
 
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class FindElements(root: TreeNode?) {
    
    private val recoveredTreeValues = mutableSetOf<Int>()
    
    init {
        val queue = LinkedList<TreeNode>()
        root?.let { 
            it.`val` = 0
            queue.offerLast(it) 
        }
        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            val value = node.`val`
            recoveredTreeValues.add(value)
            
            node.left?.let { leftNode ->
                leftNode.`val` = 2 * value + 1
                queue.offerLast(leftNode) 
            }
            node.right?.let { rightNode ->
                rightNode.`val` = 2 * value + 2
                queue.offerLast(rightNode) 
            }
        }
    }

    fun find(target: Int): Boolean {
        return target in recoveredTreeValues
    }

}

/**
 * Your FindElements object will be instantiated and called as such:
 * var obj = FindElements(root)
 * var param_1 = obj.find(target)
 */
