/**
 * Runtime: 176 ms, faster than 100.00% of Kotlin online submissions for Flatten Nested List Iterator.
 * Memory Usage: 37.6 MB, less than 87.50% of Kotlin online submissions for Flatten Nested List Iterator.
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
    
    val queue = LinkedList<Int>()
    init {
        nestedList.forEach {
            flatten(it)
        }
    }
    
    private fun flatten(item: NestedInteger) {
        if (item.isInteger()) {
            queue.offer(item.getInteger()!!)
        } else {
            item.getList()?.forEach {
                flatten(it)
            }
        }
    }
    
    fun next(): Int {
        return queue.pollFirst()
    }
    
    fun hasNext(): Boolean {
        return queue.peek() != null
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * var obj = NestedIterator(nestedList)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */
