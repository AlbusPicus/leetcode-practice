/**
 * Runtime: 220 ms, faster than 88.89% of Kotlin online submissions for Min Stack.
 * Memory Usage: 39.7 MB, less than 96.08% of Kotlin online submissions for Min Stack.
 */
class MinStack() {

    /** initialize your data structure here. */
    private val internalSortedList = mutableListOf<Node>()
    private var lastNode: Node? = null
    

    fun push(x: Int) {
        val node = Node(x)
        lastNode?.nextNode = node
        node.previousNode = lastNode
        lastNode = node
        
        val position = findInsertionPosion(node)
        internalSortedList.add(position, node)
    }

    fun pop() {
        lastNode?.let { node ->
            lastNode = node.previousNode
            lastNode?.nextNode = null
            node.previousNode = null
            
            internalSortedList.remove(node)
        }
    }

    fun top(): Int {
        return lastNode?.value ?: 0
    }

    fun getMin(): Int {
        return internalSortedList.first().value
    }
    
    fun findInsertionPosion(node: Node): Int {
        var start = 0
        var end = internalSortedList.size
        while (start < end) {
            val mid = start + (end - start) / 2
            if (internalSortedList[mid].value > node.value) {
                end = mid
            } else if (internalSortedList[mid].value < node.value) {
                start = mid + 1
            } else {
                return mid
            }
        }
        return start
        
    }
    
    data class Node(val value: Int) {
        var previousNode: Node? = null
        var nextNode: Node? = null
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
