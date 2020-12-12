/* 
 * Runtime: 404 ms, faster than 33.33% of Kotlin online submissions for Falling Squares.
 * Memory Usage: 46.4 MB, less than 33.33% of Kotlin online submissions for Falling Squares.
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
            var currentMaxHeight = 0
            
            val squares = getSquares(leftEdgesSet, rightEdgesSet, leftEdgeToSquare, rightEdgeToSquare, leftIndex, rightIndex)
            squares.forEach { square ->
                currentMaxHeight = Math.max(currentMaxHeight, square.height)
            }
            
            val square = Square(leftIndex, rightIndex, currentMaxHeight + position[1])
            leftEdgesSet.add(leftIndex)
            rightEdgesSet.add(rightIndex)
            
            updateCurrentSquares(squares, leftEdgesSet, rightEdgesSet, leftEdgeToSquare, rightEdgeToSquare, square)
            
            leftEdgeToSquare.put(leftIndex, square)
            rightEdgeToSquare.put(rightIndex, square)
            
            maxHeight = Math.max(maxHeight, square.height)
            results.add(maxHeight)
        }
        
        return results
    }
    
    fun getSquares(
        leftEdgesSet: TreeSet<Int>, 
        rightEdgesSet: TreeSet<Int>, 
        leftEdgeToSquare: Map<Int, Square>,
        rightEdgeToSquare: Map<Int, Square>,
        leftIndex: Int, 
        rightIndex: Int
    ): List<Square> {
        val leftIndexesSubset = leftEdgesSet.subSet(leftIndex, true, rightIndex, true)
        val rightIndexesSubset = rightEdgesSet.subSet(leftIndex, true, rightIndex, true)
        return mutableListOf<Square>().apply {
            leftIndexesSubset.forEach { index ->
                leftEdgeToSquare[index]?.let { add(it) }
            }
            rightIndexesSubset.forEach { index ->
                rightEdgeToSquare[index]?.let { add(it) }
            }
            leftEdgesSet.lower(leftIndex)?.let { edge ->
                leftEdgeToSquare[edge]?.takeIf { it.endIndex > rightIndex }?.let { add(it) }
            }
            rightEdgesSet.higher(rightIndex)?.let { edge ->
                rightEdgeToSquare[edge]?.takeIf { it.startIndex < leftIndex }?.let { add(it) }
            }
        }
            
    }
    
    fun updateCurrentSquares(
        squares: List<Square>,
        leftEdgesSet: TreeSet<Int>, 
        rightEdgesSet: TreeSet<Int>, 
        leftEdgeToSquare: MutableMap<Int, Square>,
        rightEdgeToSquare: MutableMap<Int, Square>,
        currentSquare: Square
    ) {
        squares.forEach { square ->
            val rightSplitIndex = currentSquare.endIndex + 1

            if (rightSplitIndex <= square.endIndex) {
                val unchangedPart = square.copy(startIndex = rightSplitIndex)
                leftEdgesSet.add(rightSplitIndex)
                leftEdgeToSquare[rightSplitIndex] = unchangedPart
                rightEdgeToSquare[unchangedPart.endIndex] = unchangedPart
            }

            val leftSplitIndex = currentSquare.startIndex - 1
            if (leftSplitIndex >= square.startIndex) {
                val unchangedPart = square.copy(endIndex = leftSplitIndex)
                rightEdgesSet.add(leftSplitIndex)
                rightEdgeToSquare[leftSplitIndex] = unchangedPart
                leftEdgeToSquare[unchangedPart.startIndex] = unchangedPart
            }

            val separatedSquare = square.copy(
                startIndex = Math.max(square.startIndex, currentSquare.startIndex),
                endIndex = Math.min(square.endIndex, currentSquare.endIndex),
                height = currentSquare.height
            )

            leftEdgeToSquare[separatedSquare.startIndex] = separatedSquare
            rightEdgeToSquare[separatedSquare.endIndex] = separatedSquare
        }
    }
    
    data class Square(val startIndex: Int, val endIndex: Int, var height: Int)
    
}
