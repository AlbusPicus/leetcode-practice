/**
 * Runtime: 200 ms, faster than 50.00% of Kotlin online submissions for Validate Stack Sequences.
 * Memory Usage: 38.7 MB, less than 16.67% of Kotlin online submissions for Validate Stack Sequences.
 */
class Solution {
    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        val pushedValues = mutableSetOf<Int>()
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
            if (popIndex < valuesCount && popped[popIndex] in pushedValues) {
                return false
            } else {
                pushedValues.add(pushed[i])
            }
        }
        
        return true
    }
}
