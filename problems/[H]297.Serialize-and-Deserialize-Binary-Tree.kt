/**
 * Runtime: 288 ms, faster than 30.97% of Kotlin online submissions for Serialize and Deserialize Binary Tree.
 * Memory Usage: 39.4 MB, less than 69.91% of Kotlin online submissions for Serialize and Deserialize Binary Tree.
 */
 
/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Codec() {
	// Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        if (root == null) return "null"
        
        val leftVal = serialize(root?.left)
        val rightVal = serialize(root?.right)
        
        return root.`val`.toString() + ",$leftVal,$rightVal"
    }

    // Decodes your encoded data to tree.
    fun deserialize(text: String): TreeNode? {
        val split = text.split(',').toMutableList()
        return createTree(split)
    }
    
    private fun createTree(split: MutableList<String>): TreeNode? {
        val value = split[0]
        split.removeAt(0)
        if (value == "null") return null
        
        val head = TreeNode(value.toInt())
        
        head.left = createTree(split)
        head.right = createTree(split)
        return head
    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * var ser = Codec()
 * var deser = Codec()
 * var data = ser.serialize(longUrl)
 * var ans = deser.deserialize(data)
 */
