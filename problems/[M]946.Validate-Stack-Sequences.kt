/**
 * Runtime: 188 ms, faster than 83.33% of Kotlin online submissions for Validate Stack Sequences.
 * Memory Usage: 37.2 MB, less than 50.00% of Kotlin online submissions for Validate Stack Sequences.
 */
class Solution {
    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        var pushList = LinkedList<Int>()
        val valuesCount = pushed.size
        var popIndex = 0
        for (i in 0 until valuesCount) {
            pushList.offerLast(pushed[i])
            while (popIndex < valuesCount
                   && pushList.isNotEmpty() 
                   && popped[popIndex] == pushList.peekLast()) {
                pushList.removeLast()
                popIndex++
            }
        }
        
        return popIndex == valuesCount
    }
}
