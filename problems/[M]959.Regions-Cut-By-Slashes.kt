/**
 * Runtime: 192 ms, faster than 100.00% of Kotlin online submissions for Regions Cut By Slashes.
 * Memory Usage: 40.4 MB, less than 100.00% of Kotlin online submissions for Regions Cut By Slashes.
 */
class Solution {
    fun regionsBySlashes(grid: Array<String>): Int {
        val size = grid.size
        val symbolsGrid = mapGrid(grid)
        
        val meaningfulSymbols = setOf(SPACE, slash, slashLeftCounted, slashRightCounted, backSlash, backSlashLeftCounted, backSlashRightCounted)
        
        var regions = 0
        for (i in 0 until size) {
            for (j in 0 until size) {
                when (symbolsGrid[i][j]) {
                    ' ' -> {
                        coverRegion(symbolsGrid, i, j)
                        regions++
                    }
                    slash -> {
                        coverRegion(symbolsGrid, i, j)
                        regions++
                        if (symbolsGrid[i][j] == slashLeftCounted || symbolsGrid[i][j] == slashRightCounted) {
                            coverRegion(symbolsGrid, i, j)
                            regions++
                        }
                    }
                    slashLeftCounted -> {
                        coverRegion(symbolsGrid, i, j)
                        regions++
                    }
                    slashRightCounted -> {
                        coverRegion(symbolsGrid, i, j)
                        regions++
                    }
                    backSlash -> {
                        coverRegion(symbolsGrid, i, j)
                        regions++
                        if (symbolsGrid[i][j] == backSlashLeftCounted || symbolsGrid[i][j] == backSlashRightCounted) {
                            coverRegion(symbolsGrid, i, j)
                            regions++
                        }
                    }
                    backSlashLeftCounted -> {
                        coverRegion(symbolsGrid, i, j)
                        regions++
                    }
                    backSlashRightCounted -> {
                        coverRegion(symbolsGrid, i, j)
                        regions++
                    }
                    else -> Unit
                }
                
                
            }
        }
        
        return regions
        
    }
    
    fun coverRegion(grid: Array<CharArray>, startI: Int, startJ: Int, startDirection: Int = DIRECTION_NONE) {
        val pointToVisit = LinkedList<Pair<Int, Int>>()
        val size = grid.size
        val lastIndex = size - 1
        val startIndex = startI * size + startJ
        pointToVisit.offerLast(startIndex to startDirection)
        while (pointToVisit.isNotEmpty()) {
            val (point, direction) = pointToVisit.removeFirst()
            val i = point / size
            val j = point % size
            when (grid[i][j]) {
                SPACE -> {
                    grid[i][j] = ALL_COUNTED
                    if (direction != DIRECTION_UP && i > 0) {
                        val index = point - size
                        pointToVisit.offerLast(index to DIRECTION_DOWN)
                    }
                    if (direction != DIRECTION_DOWN && i < lastIndex) {
                        val index = point + size
                        pointToVisit.offerLast(index to DIRECTION_UP)
                    }
                    if (direction != DIRECTION_LEFT && j > 0) {
                        val index = point - 1
                        pointToVisit.offerLast(index to DIRECTION_RIGHT)
                    }
                    if (direction != DIRECTION_RIGHT && j < lastIndex) {
                        val index = point + 1
                        pointToVisit.offerLast(index to DIRECTION_LEFT)
                    }
                }
                slash -> {
                    val comeFromTopLeft = direction == DIRECTION_UP || direction == DIRECTION_LEFT
                    if (comeFromTopLeft) {
                        grid[i][j] = slashLeftCounted
                        if (direction != DIRECTION_UP && i > 0) {
                            val index = point - size
                            pointToVisit.offerLast(index to DIRECTION_DOWN)
                        }
                        if (direction != DIRECTION_LEFT && j > 0) {
                            val index = point - 1
                            pointToVisit.offerLast(index to DIRECTION_RIGHT)
                        }
                    } else {
                        grid[i][j] = slashRightCounted
                        if (direction != DIRECTION_DOWN && i < lastIndex) {
                            val index = point + size
                            pointToVisit.offerLast(index to DIRECTION_UP)
                        }
                        if (direction != DIRECTION_RIGHT && j < lastIndex) {
                            val index = point + 1
                            pointToVisit.offerLast(index to DIRECTION_LEFT)
                        }
                    }
                }
                slashLeftCounted -> {
                    val comeFromBottomRight = direction == DIRECTION_NONE || direction == DIRECTION_DOWN || direction == DIRECTION_RIGHT
                    if (comeFromBottomRight) {
                        grid[i][j] = ALL_COUNTED
                        if (direction != DIRECTION_DOWN && i < lastIndex) {
                            val index = point + size
                            pointToVisit.offerLast(index to DIRECTION_UP)
                        }
                        if (direction != DIRECTION_RIGHT && j < lastIndex) {
                            val index = point + 1
                            pointToVisit.offerLast(index to DIRECTION_LEFT)
                        }
                    }
                }
                slashRightCounted -> {
                    val comeFromTopLeft = direction == DIRECTION_NONE || direction == DIRECTION_UP || direction == DIRECTION_LEFT
                    if (comeFromTopLeft) {
                        grid[i][j] = ALL_COUNTED
                        if (direction != DIRECTION_UP && i > 0) {
                            val index = point - size
                            pointToVisit.offerLast(index to DIRECTION_DOWN)
                        }
                        if (direction != DIRECTION_LEFT && j > 0) {
                            val index = point - 1
                            pointToVisit.offerLast(index to DIRECTION_RIGHT)
                        }
                    }
                }
                backSlash -> {
                    val comeFromTopRight = direction == DIRECTION_UP || direction == DIRECTION_RIGHT
                    if (comeFromTopRight) {
                        grid[i][j] = backSlashRightCounted
                        if (direction != DIRECTION_UP && i > 0) {
                            val index = point - size
                            pointToVisit.offerLast(index to DIRECTION_DOWN)
                        }
                        if (direction != DIRECTION_RIGHT && j < lastIndex) {
                            val index = point + 1
                            pointToVisit.offerLast(index to DIRECTION_LEFT)
                        }
                    } else {
                        grid[i][j] = backSlashLeftCounted
                        if (direction != DIRECTION_DOWN && i < lastIndex) {
                            val index = point + size
                            pointToVisit.offerLast(index to DIRECTION_UP)
                        }
                        if (direction != DIRECTION_LEFT && j > 0) {
                            val index = point - 1
                            pointToVisit.offerLast(index to DIRECTION_RIGHT)
                        }
                    }
                }
                backSlashLeftCounted -> {
                    val comeFromTopRight = direction == DIRECTION_NONE || direction == DIRECTION_UP || direction == DIRECTION_RIGHT
                    if (comeFromTopRight) {
                        grid[i][j] = ALL_COUNTED
                        if (direction != DIRECTION_UP && i > 0) {
                            val index = point - size
                            pointToVisit.offerLast(index to DIRECTION_DOWN)
                        }
                        if (direction != DIRECTION_RIGHT && j < lastIndex) {
                            val index = point + 1
                            pointToVisit.offerLast(index to DIRECTION_LEFT)
                        }
                    }

                }
                backSlashRightCounted -> {
                    val comeFromBottomLeft = direction == DIRECTION_NONE || direction == DIRECTION_DOWN || direction == DIRECTION_LEFT
                    if (comeFromBottomLeft) {
                        grid[i][j] = ALL_COUNTED
                        if (direction != DIRECTION_DOWN && i < lastIndex) {
                            val index = point + size
                            pointToVisit.offerLast(index to DIRECTION_UP)
                        }
                        if (direction != DIRECTION_LEFT && j > 0) {
                            val index = point - 1
                            pointToVisit.offerLast(index to DIRECTION_RIGHT)
                        }
                    }

                }
            }
        }
    }
    
    fun mapGrid(grid: Array<String>): Array<CharArray> {
        return Array<CharArray>(grid.size) { i -> CharArray(grid.size) { j -> grid[i].get(j) } }
    }
    
    companion object {
        const val slash = '/'
        const val slashLeftCounted = '*'
        const val slashRightCounted = '&'
        const val backSlash = '\\'
        const val backSlashLeftCounted = '$'
        const val backSlashRightCounted = '#'
        const val ALL_COUNTED = '1'
        const val SPACE = ' '
        
        const val DIRECTION_NONE = 0
        const val DIRECTION_UP = 1
        const val DIRECTION_DOWN = 2
        const val DIRECTION_LEFT = 4
        const val DIRECTION_RIGHT = 8
    }
    
}
