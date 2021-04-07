/**
 * Runtime: 256 ms, faster than 90.91% of Kotlin online submissions for The Skyline Problem.
 * Memory Usage: 41.3 MB, less than 90.91% of Kotlin online submissions for The Skyline Problem.
 */
class Solution {
    fun getSkyline(buildings: Array<IntArray>): List<List<Int>> {
        Arrays.sort(buildings) { a, b -> 
            if (a[0] != b[0]) { 
                a[0] - b[0]
            } else {
                b[2] - a[2]
            }
        }
        
        val heap = PriorityQueue<IntArray> { a, b -> b[2] - a[2] }
        val result = mutableListOf<List<Int>>()
        
        for (i in 0 until buildings.size) {
            val building = buildings[i]
            if (heap.isEmpty()) {
                heap.add(building)
                result.add(listOf(building[0], building[2]))
                continue
            }

            while (heap.isNotEmpty() && building[0] > heap.element()[1]) {
                var removed = heap.remove()
                while (heap.isNotEmpty() && heap.element()[1] <= removed[1]) {
                    heap.remove()
                }
                result.add(listOf(removed[1], if (heap.isEmpty()) 0 else heap.element()[2]))
            }

            if (heap.isEmpty() || heap.element()[2] < building[2]) {
                result.add(listOf(building[0], building[2]))
            }
            
            while (heap.isNotEmpty() && heap.element()[2] == building[2] && heap.element()[1] >= building[0] && heap.element()[1] < building[1]) {
                heap.remove()
            }
            heap.add(building)
        }

        while (heap.isNotEmpty()) {
            var removed = heap.remove()
            while (heap.isNotEmpty() && heap.element()[1] <= removed[1]) {
                heap.remove()
            }
            result.add(listOf(removed[1], if (heap.isEmpty()) 0 else heap.element()[2]))
        }
        
        return result
    }
}
