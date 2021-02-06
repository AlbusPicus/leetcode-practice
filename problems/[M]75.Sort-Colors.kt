/**
 * Runtime: 156 ms, faster than 96.97% of Kotlin online submissions for Sort Colors.
 * Memory Usage: 34.4 MB, less than 65.15% of Kotlin online submissions for Sort Colors.
 */
class Solution {
    fun sortColors(nums: IntArray): Unit {
        val size = nums.size
        var redsCount = 0
        var whitesCount = 0
        var bluesCount = 0
        nums.forEach { number ->
            when (number) {
                RED_COLOR_INT -> redsCount++
                WHITE_COLOR_INT -> whitesCount++
                BLUE_COLOR_INT -> bluesCount++
                else -> throw IllegalArgumentException("Unsupported color int")
            }
        }
        
        for (i in 0 until redsCount) {
            nums[i] = RED_COLOR_INT
        }
        
        for (i in redsCount until redsCount + whitesCount) {
            nums[i] = WHITE_COLOR_INT
        }
        
        for (i in redsCount + whitesCount until nums.size) {
            nums[i] = BLUE_COLOR_INT
        }
        
    }
    
    companion object {
        private const val RED_COLOR_INT = 0
        private const val WHITE_COLOR_INT = 1
        private const val BLUE_COLOR_INT = 2
    }
}
