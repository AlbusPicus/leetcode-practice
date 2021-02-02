/**
 * Runtime: 788 ms, faster than 100.00% of Kotlin online submissions for Maximum Performance of a Team.
 * Memory Usage: 74.7 MB, less than 100.00% of Kotlin online submissions for Maximum Performance of a Team.
 */
class Solution {
    fun maxPerformance(n: Int, speed: IntArray, efficiency: IntArray, k: Int): Int {
        val engineers = Array(n) { i -> Engineer(speed[i], efficiency[i]) }
        engineers.sortByDescending { it.efficiency }
        val hieringHeap = PriorityQueue<Engineer> { first, second -> first.speed - second.speed }
        var teamSpeed = 0L
        var maxPerformance = Long.MIN_VALUE
        engineers.forEach { candidate ->
            if (hieringHeap.size == k) {
                teamSpeed -= hieringHeap.poll().speed
            }
            hieringHeap.offer(candidate)
            teamSpeed += candidate.speed
            
            val newPerformance = teamSpeed * candidate.efficiency.toLong()
            maxPerformance = Math.max(maxPerformance, newPerformance)
        }
        return (maxPerformance % MOD).toInt()
        
    }
    
    companion object {
        private val MOD = (1e9 + 7).toInt()
    }
    
}

data class Engineer(val speed: Int, val efficiency: Int)
