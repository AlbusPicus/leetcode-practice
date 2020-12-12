/* 
 * Runtime: 404 ms, faster than 33.33% of Kotlin online submissions for Falling Squares.
 * Memory Usage: 45.3 MB, less than 33.33% of Kotlin online submissions for Falling Squares.
 */

class Solution {
    fun fallingSquares(positions: Array<IntArray>): List<Int> {
        var maxHeight = 0
        val results = mutableListOf<Int>()
        
        val leftEdgesSet = sortedSetOf<Int>()
        val rightEdgesSet = sortedSetOf<Int>()
        val leftEdgeToSquare = mutableMapOf<Int, Square>()
        val rightEdgeToSquare = mutableMapOf<Int, Square>()
        
        positions.forEach { position ->
            val leftIndex = position[0]
            val rightIndex = leftIndex + position[1] - 1
            val leftIndexesSubset = leftEdgesSet.subSet(leftIndex, true, rightIndex, true)
            val rightIndexesSubset = rightEdgesSet.subSet(leftIndex, true, rightIndex, true)
            var currentMaxHeight = 0
            
            val squares = mutableListOf<Square>()
            leftIndexesSubset.forEach {
                val item = leftEdgeToSquare[it]
                if (item != null) {
                    currentMaxHeight = Math.max(currentMaxHeight, item.height)
                    squares.add(item)
                }
            }
            rightIndexesSubset.forEach {
                val item = rightEdgeToSquare[it]
                if (item != null) {
                    currentMaxHeight = Math.max(currentMaxHeight, item.height)
                    squares.add(item)
                }
            }
            
            leftEdgesSet.lower(leftIndex)?.let {
                val item = leftEdgeToSquare[it]
                if (item != null && item.endIndex > rightIndex) {
                    currentMaxHeight = Math.max(currentMaxHeight, item.height)
                    squares.add(item)
                }
            }
            rightEdgesSet.higher(rightIndex)?.let {
                val item = rightEdgeToSquare[it]
                if (item != null && item.startIndex < leftIndex) {
                    currentMaxHeight = Math.max(currentMaxHeight, item.height)
                    squares.add(item)
                }
            }
            
            if (leftIndex == 52) {
                // throw IllegalStateException("Height: $currentMaxHeight Indexes: $leftIndexesSubset $rightIndexesSubset | ${leftEdgesSet.lower(leftIndex)} ${rightEdgesSet.higher(rightIndex)}")
            }
            
            val newSquare = Square(leftIndex, rightIndex, currentMaxHeight + position[1])
            leftEdgesSet.add(leftIndex)
            rightEdgesSet.add(rightIndex)
            
            squares.forEach { square ->
                val rightSplitIndex = newSquare.endIndex + 1
                
                if (rightSplitIndex <= square.endIndex) {
                    val unchangedPart = square.copy(startIndex = rightSplitIndex)
                    leftEdgesSet.add(rightSplitIndex)
                    leftEdgeToSquare[rightSplitIndex] = unchangedPart
                    rightEdgeToSquare[unchangedPart.endIndex] = unchangedPart
                }
                
                val leftSplitIndex = newSquare.startIndex - 1
                if (leftSplitIndex >= square.startIndex) {
                    val unchangedPart = square.copy(endIndex = leftSplitIndex)
                    rightEdgesSet.add(leftSplitIndex)
                    rightEdgeToSquare[leftSplitIndex] = unchangedPart
                    leftEdgeToSquare[unchangedPart.startIndex] = unchangedPart
                }
                
                val separatedSquare = square.copy(
                    startIndex = Math.max(square.startIndex, newSquare.startIndex),
                    endIndex = Math.min(square.endIndex, newSquare.endIndex),
                    height = newSquare.height
                )

                leftEdgeToSquare[separatedSquare.startIndex] = separatedSquare
                rightEdgeToSquare[separatedSquare.endIndex] = separatedSquare
                    
            }
            
            
            leftEdgeToSquare.put(leftIndex, newSquare)
            rightEdgeToSquare.put(rightIndex, newSquare)
            
            maxHeight = Math.max(maxHeight, newSquare.height)
            results.add(maxHeight)
        }
        
        return results
    }
    
    data class Square(val startIndex: Int, val endIndex: Int, var height: Int)
    
}
