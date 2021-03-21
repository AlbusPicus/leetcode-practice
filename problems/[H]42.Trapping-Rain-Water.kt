/**
 * Runtime: 176 ms, faster than 86.73% of Kotlin online submissions for Trapping Rain Water.
 * Memory Usage: 36.1 MB, less than 96.94% of Kotlin online submissions for Trapping Rain Water.
 */
class Solution {
    fun trap(height: IntArray): Int {
        val heightsStack = LinkedList<GroundInfo>()
        
        var lastHeight: Int = 0
        var lastIndex = 0
        var result = 0
        
        for (i in 0 until height.size) {
            val current = height[i]
            if (current < lastHeight) {
                heightsStack.offerLast(GroundInfo(lastIndex, lastHeight, lastHeight - current))
            } else if (current > lastHeight) {
                var groundInfo = heightsStack.pollLast()
                while (groundInfo != null && groundInfo.height <= current) {

                    val localResult = (i - groundInfo.position - 1) * groundInfo.freeHeight
                    result += localResult

                    groundInfo = heightsStack.pollLast()
                }
                groundInfo?.let {
                    if (groundInfo.height - groundInfo.freeHeight < current) {
                        val consumableHeight = current - groundInfo.height + groundInfo.freeHeight
                        val localResult = (i - groundInfo.position - 1) * consumableHeight
                        result += localResult
                        heightsStack.offerLast(it.copy(freeHeight = it.freeHeight - consumableHeight))
                    } else {
                        heightsStack.offerLast(it)
                    }
                }
            }

            lastIndex = i
            lastHeight = current
        }
        return result
    }
    
    data class GroundInfo(val position: Int, val height: Int, val freeHeight: Int)
}
