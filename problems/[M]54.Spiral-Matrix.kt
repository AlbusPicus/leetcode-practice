/**
 * Runtime: 132 ms, faster than 91.07% of Kotlin online submissions for Spiral Matrix.
 * Memory Usage: 33.7 MB, less than 85.71% of Kotlin online submissions for Spiral Matrix.
 */
class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        var topBorder = 1
        var leftBorder = 0
        var rightBorder = matrix[0].size - 1
        var bottomBorder = matrix.size - 1
        var size = matrix.size * matrix[0].size
        var direction = Direction.RIGHT
        var i = 0
        var j = 0
        
        val result = mutableListOf<Int>()
        for (itemNumber in 0 until size) {
            result.add(matrix[i][j])
            when (direction) {
                Direction.LEFT -> {
                    if (j == leftBorder) {
                        leftBorder++
                        direction = Direction.TOP
                        i--
                    } else {
                        j--
                    }
                }
                Direction.RIGHT -> {
                    if (j == rightBorder) {
                        rightBorder--
                        direction = Direction.BOTTOM
                        i++
                    } else {
                        j++
                    }
                }
                Direction.TOP -> {
                    if (i == topBorder) {
                        topBorder++
                        direction = Direction.RIGHT
                        j++
                    } else {
                        i--
                    }
                }
                Direction.BOTTOM -> {
                    if (i == bottomBorder) {
                        bottomBorder--
                        direction = Direction.LEFT
                        j--
                    } else {
                        i++
                    }
                }
            }
        }
        return result
        
    }
    
    enum class Direction {
        LEFT,
        BOTTOM,
        RIGHT,
        TOP
    }
}
