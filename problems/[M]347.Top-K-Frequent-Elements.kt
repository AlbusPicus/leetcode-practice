/**
 * Runtime: 232 ms, faster than 98.77% of Kotlin online submissions for Top K Frequent Elements.
 * Memory Usage: 40.6 MB, less than 80.86% of Kotlin online submissions for Top K Frequent Elements.
 */
class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val frequencyMap = mutableMapOf<Int, Int>()
        nums.forEach { number ->
            frequencyMap[number] = frequencyMap.getOrDefault(number, 0) + 1
        }
        
        val result = IntArray(k)
        val heap = PriorityQueue<Pair<Int, Int>>(k) { o1, o2 -> o1.second - o2.second }
        frequencyMap.entries.forEach { entry ->
            heap.offer(entry.key to entry.value)
            if (heap.size > k) heap.poll()
        }
        for (i in 0 until k) {
            result[i] = heap.poll().first
        }
        return result
    }
}
