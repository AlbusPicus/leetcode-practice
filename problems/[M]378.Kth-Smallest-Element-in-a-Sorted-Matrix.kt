/**
 * Runtime: 276 ms, faster than 76.29% of Kotlin online submissions for Kth Smallest Element in a Sorted Matrix.
 * Memory Usage: 45.8 MB, less than 57.73% of Kotlin online submissions for Kth Smallest Element in a Sorted Matrix.
 */
class Solution {
    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        val size = matrix.size
        
        val heap = PriorityQueue<Int>(k + 1) { o1, o2 -> o2 - o1 }
        for (i in 0 until size) {
            for (j in 0 until size) {
                heap.offer(matrix[i][j])
                if (heap.size > k) heap.poll()
            }
        }
        return heap.poll()
    }
    
}
