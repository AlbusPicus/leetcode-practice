/**
 * Runtime: 476 ms, faster than 100.00% of Kotlin online submissions for Shortest Subarray to be Removed to Make Array Sorted.
 * Memory Usage: 61.5 MB, less than 100.00% of Kotlin online submissions for Shortest Subarray to be Removed to Make Array Sorted.
 */
class Solution {
    fun findLengthOfShortestSubarray(arr: IntArray): Int {
        
        val directOrderStack = LinkedList<Int>() // non-decreasing numbers from beginning
        directOrderStack.offerLast(arr[0])
        
        val reversedOrderStack = LinkedList<Int>() // decreasing numbers from end
        reversedOrderStack.offerLast(arr[arr.size - 1])
        var index = 1
        var addFromBeginning = true
        var addFromEnd = true
        while ((addFromBeginning || addFromEnd) && index < arr.size) {
            if (addFromBeginning && arr[index] >= directOrderStack.peekLast()) {
                directOrderStack.offerLast(arr[index])
            } else {
                addFromBeginning = false
            }
            
            val reverseIndex = arr.size - index - 1
            if (addFromEnd && arr[reverseIndex] <= reversedOrderStack.peekLast()) {
                reversedOrderStack.offerLast(arr[reverseIndex])
            } else {
                addFromEnd = false
            }
            index++
        }
        
        return if (directOrderStack.size + reversedOrderStack.size > arr.size) {
            0
        } else {
            arr.size - maxNonDecreasingSize(directOrderStack, reversedOrderStack)
        }
    }
    
    fun maxNonDecreasingSize(directOrderStack: LinkedList<Int>, reversedOrderStack: LinkedList<Int>): Int {
        return if (directOrderStack.isEmpty() || reversedOrderStack.isEmpty() || directOrderStack.peekLast() <= reversedOrderStack.peekLast()) {
            directOrderStack.size + reversedOrderStack.size
        } else {
            //TODO add memoization
            val newDirectStack = LinkedList<Int>(directOrderStack)
            newDirectStack.pollLast()
            val removeFromLeft = maxNonDecreasingSize(newDirectStack, reversedOrderStack)
            
            val newReversedStack = LinkedList<Int>(reversedOrderStack)
            newReversedStack.pollLast()
            val removeFromRight = maxNonDecreasingSize(directOrderStack, newReversedStack)
            
            Math.max(removeFromLeft, removeFromRight)
        }
    }
    
}
