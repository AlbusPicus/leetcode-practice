/**
 * Runtime: 212 ms, faster than 100.00% of Kotlin online submissions for Regions Cut By Slashes.
 * Memory Usage: 37.4 MB, less than 100.00% of Kotlin online submissions for Regions Cut By Slashes.
 */
class Solution {
    fun regionsBySlashes(grid: Array<String>): Int {
        val size = grid.size
        val symbolsGrid = mapGrid(grid)
        
        var regions = 0
        for (i in 0 until size) {
            for (j in 0 until size) {
                val char = symbolsGrid[i][j]
                if (char in meaningfulSymbols) {
                    coverRegion(symbolsGrid, i, j)
                    regions++
                    if (symbolsGrid[i][j] in meaningfulSymbols) {
                        coverRegion(symbolsGrid, i, j)
                        regions++
                    }
                }
            }
        }
        
        return regions
        
    }
    
    fun coverRegion(grid: Array<CharArray>, startI: Int, startJ: Int, startDirection: Direction? = null) {
        val pointToVisit = LinkedList<Pair<Int, Direction?>>()
        val size = grid.size
        val lastIndex = size - 1
        val startIndex = startI * size + startJ
        pointToVisit.offerLast(startIndex to startDirection)
        val allowedDirections = EnumSet.noneOf(Direction::class.java)
        while (pointToVisit.isNotEmpty()) {
            val (point, direction) = pointToVisit.removeFirst()
            val i = point / size
            val j = point % size
            
            when (grid[i][j]) {
                SPACE -> {
                    grid[i][j] = ALL_VISITED
                    allowedDirections.add(Direction.DOWN)
                    allowedDirections.add(Direction.UP)
                    allowedDirections.add(Direction.RIGHT)
                    allowedDirections.add(Direction.LEFT)
                }
                SLASH -> {
                    val comeFromTopLeft = direction == Direction.UP || direction == Direction.LEFT
                    if (comeFromTopLeft) {
                        grid[i][j] = SLASH_LEFT_VISITED
                        allowedDirections.add(Direction.DOWN)
                        allowedDirections.add(Direction.RIGHT)
                    } else {
                        grid[i][j] = SLASH_RIGHT_VISITED
                        allowedDirections.add(Direction.UP)
                        allowedDirections.add(Direction.LEFT)
                    }
                }
                SLASH_LEFT_VISITED -> {
                    val notBlocked = direction != Direction.UP && direction != Direction.LEFT
                    if (notBlocked) {
                        grid[i][j] = ALL_VISITED
                        allowedDirections.add(Direction.UP)
                        allowedDirections.add(Direction.LEFT)
                    }
                }
                SLASH_RIGHT_VISITED -> {
                    val notBlocked = direction != Direction.DOWN && direction != Direction.RIGHT
                    if (notBlocked) {
                        grid[i][j] = ALL_VISITED
                        allowedDirections.add(Direction.DOWN)
                        allowedDirections.add(Direction.RIGHT)
                    }
                }
                BACKSLASH -> {
                    val comeFromTopRight = direction == Direction.UP || direction == Direction.RIGHT
                    if (comeFromTopRight) {
                        grid[i][j] = BACKSLASH_RIGHT_VISITED
                        allowedDirections.add(Direction.DOWN)
                        allowedDirections.add(Direction.LEFT)
                    } else {
                        grid[i][j] = BACKSLASH_LEFT_VISITED
                        allowedDirections.add(Direction.UP)
                        allowedDirections.add(Direction.RIGHT)
                    }
                }
                BACKSLASH_LEFT_VISITED -> {
                    val notBlocked = direction != Direction.DOWN && direction != Direction.LEFT
                    if (notBlocked) {
                        grid[i][j] = ALL_VISITED
                        allowedDirections.add(Direction.DOWN)
                        allowedDirections.add(Direction.LEFT)
                    }

                }
                BACKSLASH_RIGHT_VISITED -> {
                    val notBlocked = direction != Direction.UP && direction != Direction.RIGHT
                    if (notBlocked) {
                        grid[i][j] = ALL_VISITED
                        allowedDirections.add(Direction.UP)
                        allowedDirections.add(Direction.RIGHT)
                    }

                }
            }
            
            schedulePoints(pointToVisit, allowedDirections, point, size)
            allowedDirections.clear()
        }
    }
    
    private fun schedulePoints(pointToVisit: LinkedList<Pair<Int, Direction?>>, directions: EnumSet<Direction>, point: Int, size: Int) {
        val i = point / size
        val j = point % size
        val lastIndex = size - 1
        if (Direction.UP in directions) {
            if (i < lastIndex) {
                val index = point + size
                pointToVisit.offerLast(index to Direction.UP)
            }
        } 
        if (Direction.DOWN in directions) {
            if (i > 0) {
                val index = point - size
                pointToVisit.offerLast(index to Direction.DOWN)
            }
        }
        if (Direction.LEFT in directions) {
            if (j < lastIndex) {
                val index = point + 1
                pointToVisit.offerLast(index to Direction.LEFT)
            }
        }
        if (Direction.RIGHT in directions) {
            if (j > 0) {
                val index = point - 1
                pointToVisit.offerLast(index to Direction.RIGHT)
            }
        }
    }
    
    private fun mapGrid(grid: Array<String>): Array<CharArray> {
        return Array<CharArray>(grid.size) { i -> CharArray(grid.size) { j -> grid[i].get(j) } }
    }
    
    companion object {
        private const val SLASH = '/'
        private const val SLASH_LEFT_VISITED = '*'
        private const val SLASH_RIGHT_VISITED = '&'
        private const val BACKSLASH = '\\'
        private const val BACKSLASH_LEFT_VISITED = '$'
        private const val BACKSLASH_RIGHT_VISITED = '#'
        private const val ALL_VISITED = '1'
        private const val SPACE = ' '
        
        private val meaningfulSymbols = setOf(SPACE, SLASH, BACKSLASH, SLASH_LEFT_VISITED, SLASH_RIGHT_VISITED, BACKSLASH_LEFT_VISITED, BACKSLASH_RIGHT_VISITED)
    }
    
    enum class Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
    
}
