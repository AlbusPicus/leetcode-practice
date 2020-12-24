class Solution {
    fun findLengthOfShortestSubarray(arr: IntArray): Int {
        
        // Direct Order
        val stack = LinkedList<Int>() // non-decreasing numbers from beginning
        stack.offerLast(arr[0])
        var index = 1
        while (index < arr.size && arr[index] >= stack.peekLast()) {
            stack.offerLast(arr[index])
            index++
        }
        var directOrderLength: Int = 0
        var lastElement = stack.peekLast()
        var potential = Int.MAX_VALUE
        for (decreasingIndex in index until arr.size) {
            val value = arr[decreasingIndex]
            if (lastElement > value) {
                potential = Int.MAX_VALUE
                var skipSize = 0
                val tempStack = LinkedList<Int>(stack)
                while (tempStack.size > 0 && tempStack.pollLast() > value) {
                    skipSize++
                }
                directOrderLength = skipSize + decreasingIndex - stack.size
            } else if (potential == Int.MAX_VALUE) {
                var skipSize = 0
                val tempStack = LinkedList<Int>(stack)
                while (tempStack.size > 0 && tempStack.pollLast() > value) {
                    skipSize++
                }
                potential = skipSize + decreasingIndex - stack.size
            }
            lastElement = value
        }
        var stackOnlyCase = arr.size - stack.size
        directOrderLength = Math.min(directOrderLength, potential)
        directOrderLength = Math.min(directOrderLength, stackOnlyCase)
        
        // Reverse Order
        arr.reverse()
        stack.clear()
        stack.offerLast(arr[0])
        index = 1
        while (index < arr.size && arr[index] < stack.peekLast()) {
            stack.offerLast(arr[index])
            index++
        }
        var reverseOrderLength = 0
        potential = Int.MAX_VALUE
        lastElement = stack.peekLast()
        for (decreasingIndex in index until arr.size) {
            val value = arr[decreasingIndex]
            if (lastElement <= value) {
                potential = Int.MAX_VALUE
                var skipSize = 0
                val tempStack = LinkedList<Int>(stack)
                while (tempStack.size > 0 && tempStack.pollLast() <= value) {
                    skipSize++
                }
                reverseOrderLength = skipSize + decreasingIndex - stack.size
            } else if (potential == Int.MAX_VALUE) {
                var skipSize = 0
                val tempStack = LinkedList<Int>(stack)
                while (tempStack.size > 0 && tempStack.pollLast() <= value) {
                    skipSize++
                }
                potential = skipSize + decreasingIndex - stack.size
            }
            lastElement = value
        }
        stackOnlyCase = arr.size - stack.size
        reverseOrderLength = Math.min(reverseOrderLength, potential)
        reverseOrderLength = Math.min(reverseOrderLength, stackOnlyCase)
        
        return Math.min(directOrderLength, reverseOrderLength)
        
    }
    
}
