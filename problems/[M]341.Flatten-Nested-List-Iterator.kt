/**
 * Runtime: 216 ms, faster than 45.83% of Kotlin online submissions for Flatten Nested List Iterator.
 * Memory Usage: 38.9 MB, less than 41.67% of Kotlin online submissions for Flatten Nested List Iterator.
 */
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * class NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     constructor()
 *
 *     // Constructor initializes a single integer.
 *     constructor(value: Int)
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     fun isInteger(): Boolean
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     fun getInteger(): Int?
 *
 *     // Set this NestedInteger to hold a single integer.
 *     fun setInteger(value: Int): Unit
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     fun add(ni: NestedInteger): Unit
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     fun getList(): List<NestedInteger>?
 * }
 */

class NestedIterator(nestedList: List<NestedInteger>) {
    
    val queue = LinkedList<NestedInteger>(nestedList)
    
    fun next(): Int {
        flattenToTheFirstInt()
        return queue.pollFirst().getInteger()!!
    }
    
    private fun flattenToTheFirstInt(): Unit {
        var currentValue = queue.pollFirst()
        while (currentValue != null && !currentValue.isInteger()) {
            val list = currentValue.getList()
            for (i in list.lastIndex downTo 0) {
                queue.offerFirst(list[i])
            }
            currentValue = queue.pollFirst()
        }
        currentValue?.let {
            queue.offerFirst(it)
        }
    }
    
    fun hasNext(): Boolean {
        flattenToTheFirstInt()
        return queue.peek() != null
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * var obj = NestedIterator(nestedList)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */
