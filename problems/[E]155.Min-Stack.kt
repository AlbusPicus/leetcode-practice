/**
 * Runtime: 228 ms, faster than 69.28% of Kotlin online submissions for Min Stack.
 * Memory Usage: 39.8 MB, less than 90.85% of Kotlin online submissions for Min Stack.
 */
class MinStack() {

    /** initialize your data structure here. */
    private val internalHeap = PriorityQueue<Int>()
    private val stack = LinkedList<Int>()
    

    fun push(x: Int) {
        internalHeap.offer(x)
        stack.offerLast(x)
    }

    fun pop() {
        val item = stack.pollLast()
        internalHeap.remove(item)
    }

    fun top(): Int {
        return stack.peekLast()
    }

    fun getMin(): Int {
        return internalHeap.peek()
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
