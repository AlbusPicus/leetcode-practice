/**
 * Runtime: 768 ms, faster than 100.00% of Kotlin online submissions for Remove Max Number of Edges to Keep Graph Fully Traversable.
 * Memory Usage: 116.5 MB, less than 100.00% of Kotlin online submissions for Remove Max Number of Edges to Keep Graph Fully Traversable.
 */
class Solution {
    fun maxNumEdgesToRemove(n: Int, edges: Array<IntArray>): Int {
        val aliceEdges = mutableListOf<IntArray>()
        val bobEdges = mutableListOf<IntArray>()
        val commonEdges = mutableListOf<IntArray>()
        
        edges.forEach { edge -> 
            val type = edge[0]
            when (type) {
                1 -> aliceEdges.add(edge)
                2 -> bobEdges.add(edge)
                else -> commonEdges.add(edge)
            }
        }
        
        val parentIndexes = IntArray(n + 1) { it }
        var commonParentUpdates = countParentUpdates(parentIndexes, commonEdges)
        
        var result = commonEdges.size - commonParentUpdates
        
        var parentUpdates = countParentUpdates(parentIndexes.copyOf(), aliceEdges)
        if (parentUpdates + commonParentUpdates != n-1) {
            return -1
        }
        result += aliceEdges.size - parentUpdates
        
        parentUpdates = countParentUpdates(parentIndexes.copyOf(), bobEdges)
        if (parentUpdates + commonParentUpdates != n-1) {
            return -1
        }
        result += bobEdges.size - parentUpdates
        
        return result
    }
    
    fun findParentIndex(parentIndexes: IntArray, index: Int): Int {
        var resultIndex = index
        while (resultIndex != parentIndexes[resultIndex]) {
            parentIndexes[resultIndex] = parentIndexes[parentIndexes[resultIndex]]
            resultIndex = parentIndexes[resultIndex]
        }
        return resultIndex
    }
    
    fun countParentUpdates(parentIndexes: IntArray, edges: List<IntArray>): Int{
        var parentUpdates = 0
        edges.forEach { edge ->
            val first_parent = findParentIndex(parentIndexes, edge[1])
            val second_parent = findParentIndex(parentIndexes, edge[2])
            
            if (first_parent != second_parent){
                parentUpdates++;
                parentIndexes[first_parent] = second_parent
            }    
        }
        return parentUpdates
    }
}
