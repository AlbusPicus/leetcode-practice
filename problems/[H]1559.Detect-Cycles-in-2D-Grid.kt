/**
 * Runtime: 1900 ms, faster than 25.00% of Kotlin online submissions for Detect Cycles in 2D Grid.
 * Memory Usage: 154 MB, less than 25.00% of Kotlin online submissions for Detect Cycles in 2D Grid.
 */

class Solution {
    fun containsCycle(grid: Array<CharArray>): Boolean {
        val gridHeight = grid.size
        val gridWidth = grid[0].size
        val visitedSet = mutableSetOf<Point>()
        val itemsToVisit = LinkedList<Point>().apply { addLast(Point(0, 0)) }
        val nextIterationItemsToVisit = LinkedList<Point>()
        var currentChar: Char = grid[0][0]
        var item: Point
        var currentlyVisitedItemsSet = mutableSetOf<Point>()
        while (itemsToVisit.isNotEmpty() || nextIterationItemsToVisit.isNotEmpty()) {
            val nextCycle = itemsToVisit.isEmpty()
            item = if (nextCycle) nextIterationItemsToVisit.pollLast() else itemsToVisit.pollLast()
            visitedSet.add(item)
            val itemChar = grid[item.x][item.y]
            if (nextCycle) {
                currentlyVisitedItemsSet.clear()
                currentChar = itemChar
            } else {
                currentlyVisitedItemsSet.add(item)
            }
            item.directions.forEach { direction ->
                val directionsTemplate = EnumSet.allOf(Directions::class.java)
                val newItem = when (direction) {
                    Directions.LEFT -> Point(item.x, item.y - 1, directionsTemplate.apply { remove (Directions.RIGHT) })
                    Directions.TOP -> Point(item.x - 1, item.y, directionsTemplate.apply { remove (Directions.BOTTOM) })
                    Directions.RIGHT -> Point(item.x, item.y + 1, directionsTemplate.apply { remove (Directions.LEFT) })
                    Directions.BOTTOM -> Point(item.x + 1, item.y, directionsTemplate.apply { remove (Directions.TOP) })
                }
                if (newItem.isValid(gridHeight, gridWidth)) {
                    val isSameChar = grid[newItem.x][newItem.y] == currentChar
                    if (newItem !in visitedSet) {
                        if (isSameChar) {
                            itemsToVisit.addLast(newItem)
                        } else {
                            nextIterationItemsToVisit.addLast(newItem)
                        }
                    } else if (isSameChar && newItem in currentlyVisitedItemsSet) {
                        return true
                    }
                }
            }
        }
        
        return false
        
    }
    
    data class Point(val x: Int, val y: Int) {
        
        var directions: EnumSet<Directions> = EnumSet.allOf(Directions::class.java)
        
        constructor(x: Int, y: Int, directions: EnumSet<Directions>) : this(x, y) {
            this.directions = directions
        }
        
        fun isValid(maxHeight: Int, maxWidth: Int): Boolean {
          return x >= 0 && x < maxHeight && y >= 0 && y < maxWidth
        }
        
    }
    
    enum class Directions {
        LEFT, TOP, RIGHT, BOTTOM
    }
}
