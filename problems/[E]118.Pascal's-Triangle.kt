/**
 * Runtime: 144 ms, faster than 91.67% of Kotlin online submissions for Pascal's Triangle.
 * Memory Usage: 35.3 MB, less than 72.22% of Kotlin online submissions for Pascal's Triangle.
 */
class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        if (numRows < 1) return emptyList()
        
        val result = mutableListOf<List<Int>>()
        result.add(listOf(1))
        for (i in 1 until numRows) {
            result.add(generateNextRow(result[i - 1]))
        }
        return result
    }
    
    private fun generateNextRow(previousRow: List<Int>): List<Int> {
        val result = mutableListOf<Int>(1)
        var lastValue = 1
        for (i in 1 until previousRow.size) {
            result.add(lastValue + previousRow[i])
            lastValue = previousRow[i]
        }
        result.add(1)
        return result
    }
}
