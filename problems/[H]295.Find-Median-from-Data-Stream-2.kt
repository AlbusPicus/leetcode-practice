/**
 * Runtime: 948 ms, faster than 40.96% of Kotlin online submissions for Find Median from Data Stream.
 * Memory Usage: 102.8 MB, less than 7.23% of Kotlin online submissions for Find Median from Data Stream.
 */
class MedianFinder() {

    /** initialize your data structure here. */
    val lowerHeap = PriorityQueue<Int>()
    val upperHeap = PriorityQueue<Int>() { a, b -> b - a }

    fun addNum(num: Int) {
        lowerHeap.offer(num)
        upperHeap.offer(lowerHeap.poll())
        
        if (lowerHeap.size < upperHeap.size) {
            lowerHeap.offer(upperHeap.poll())
        }
    }

    fun findMedian(): Double {
        return if (lowerHeap.size > upperHeap.size) {
            lowerHeap.first().toDouble()
        } else {
            (lowerHeap.first() + upperHeap.first()) / 2.0
        }
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */
