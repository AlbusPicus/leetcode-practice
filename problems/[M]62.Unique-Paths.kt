/**
 * Runtime: 136 ms, faster than 42.86% of Kotlin online submissions for Unique Paths.
 * Memory Usage: 34.3 MB, less than 14.29% of Kotlin online submissions for Unique Paths.
 */
class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val grid = Array(m) { IntArray(n) }
        grid[0][0] = 1
        val visited = mutableSetOf<Int>()
        val stepsQueue = LinkedList<Int>()
        stepsQueue.offerLast(1)//Step(0, 1, 1))
        stepsQueue.offerLast(n)//Step(1, 0, 1))
        while (stepsQueue.isNotEmpty()) {
            // val path = stepsQueue.pollFirst()
            // val (i, j, paths) = path
            val step = stepsQueue.pollFirst()
            val i = step / n
            val j = step % n
            
            if (i < m && j < n) {
                val pathsFromLeft = if (j > 0) grid[i][j - 1] else 0
                val pathsFromRight = if (i > 0) grid[i - 1][j] else 0
                
                val newPaths = pathsFromLeft + pathsFromRight
                grid[i][j] = newPaths
                
                val toRight = i * n + j + 1
                val toLeft = (i + 1) * n + j
                if (toRight !in visited) {
                    stepsQueue.offerLast(toRight)
                    visited.add(toRight)
                }
                if (toLeft !in visited) {
                    stepsQueue.offerLast(toLeft)
                    visited.add(toLeft)
                }
            }
        }
        return grid[m - 1][n - 1]
    }
    
}
