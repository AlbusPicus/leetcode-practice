/**
 * Runtime: 196 ms, faster than 76.92% of Kotlin online submissions for Course Schedule.
 * Memory Usage: 42 MB, less than 73.08% of Kotlin online submissions for Course Schedule.
 */
class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val prerequisitesMap = mutableMapOf<Int, MutableList<Int>>()
        prerequisites.forEach { requisit ->
            val list = prerequisitesMap.getOrElse(requisit[0], { mutableListOf<Int>() })
            list.add(requisit[1])
            prerequisitesMap.put(requisit[0], list)
        }
        
        val visited = mutableSetOf<Int>()
        
        for (course in 0 until numCourses) {
            if (!dfs(course, visited, prerequisitesMap)) return false
        }
        return true
    }
    
    fun dfs(course: Int, visited: MutableSet<Int>, prerequisitesMap: MutableMap<Int, MutableList<Int>>): Boolean {
        if (course in visited) return false
        if (prerequisitesMap[course].isNullOrEmpty()) return true

        visited.add(course)
        prerequisitesMap[course]?.forEach { pre ->
            if (!dfs(pre, visited, prerequisitesMap)) return false
        }
        visited.remove(course)
        prerequisitesMap.remove(course)
        return true
    }
}
