/**
 * Runtime: 1164 ms, faster than 36.14% of Kotlin online submissions for Find Median from Data Stream.
 * Memory Usage: 72.1 MB, less than 21.69% of Kotlin online submissions for Find Median from Data Stream.
 */
class MedianFinder() {

    /** initialize your data structure here. */
    val nums = mutableListOf<Int>()

    fun addNum(num: Int) {
        nums.add(num)
    }

    fun findMedian(): Double {
        nums.sort()
        val size = nums.size
        return if (size % 2 == 0) (nums[size / 2] + nums[size / 2 - 1]) / 2.0 else nums[size / 2].toDouble()
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */
