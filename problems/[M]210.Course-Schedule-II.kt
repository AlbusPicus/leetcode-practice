/**
 * Runtime: 220 ms, faster than 72.88% of Kotlin online submissions for Course Schedule II.
 * Memory Usage: 44.6 MB, less than 42.37% of Kotlin online submissions for Course Schedule II.
 */
class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val preMap = mutableMapOf<Int, MutableList<Int>>()
        prerequisites.forEach { preRequisite ->
            val list = preMap[preRequisite[0]] ?: mutableListOf<Int>()
            list.add(preRequisite[1])
            preMap[preRequisite[0]] = list
        }
        
        val visited = mutableSetOf<Int>()
        
        val order: MutableList<Int> = mutableListOf()
        for (i in 0 until numCourses) {
            if (i !in visited) {
                if (preMap.contains(i)) {
                    if (dfs(i, preMap, mutableSetOf(), order, visited) == null) {
                        return IntArray(0)
                    }
                } else {
                    visited.add(i)
                    order.add(i)
                }
            }
        }
        
        return IntArray(order.size) { index -> order[index] }
        
    }
    
    private fun dfs(course: Int, preRequisitesMap: MutableMap<Int, MutableList<Int>>, currentlyVisited: MutableSet<Int>, finalOrder: MutableList<Int>, globallyVisited: MutableSet<Int>): List<Int>? {
        if (course in currentlyVisited) return null
        if (course in globallyVisited) return finalOrder
        
        currentlyVisited.add(course)
        preRequisitesMap[course]?.let { requisites ->
            for (i in 0 until requisites.size) {
                if (dfs(requisites[i], preRequisitesMap, currentlyVisited, finalOrder, globallyVisited) == null) {
                    return null
                }
            }
        }
        currentlyVisited.remove(course)
        
        if (course !in globallyVisited) {
            globallyVisited.add(course)
            finalOrder.add(course)
        }
        
        preRequisitesMap.remove(course)
        return finalOrder
    }
    
}
