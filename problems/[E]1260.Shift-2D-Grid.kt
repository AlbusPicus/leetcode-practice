/**
 * Runtime: 296 ms, faster than 66.67% of Kotlin online submissions for Shift 2D Grid.
 * Memory Usage: 47 MB, less than 33.33% of Kotlin online submissions for Shift 2D Grid.
 */
class Solution {
    fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {
        val columnsCount = grid[0].size
        val elementsCount = grid.size * columnsCount
        
        val result = mutableListOf<MutableList<Int>>()
        var currentRow: MutableList<Int> = mutableListOf<Int>()
        for (newIndex in 0 until elementsCount) {
            var gridIndex = if (newIndex < k) {
                normalizeIndex(elementsCount - k + newIndex, elementsCount)
            } else {
                newIndex - k
            }
            val i = gridIndex / columnsCount
            val j = gridIndex % columnsCount
            val isNewRow = newIndex % columnsCount == 0
            if (isNewRow) {
                currentRow = mutableListOf<Int>()
                result.add(currentRow)
            }
            currentRow.add(grid[i][j])
        }
        return result
    }
    
    private fun normalizeIndex(index: Int, itemsCount: Int): Int {
        var temp = index
        while (temp >= itemsCount) temp -= itemsCount
        while (temp < 0) temp += itemsCount
        return temp
    }
}
