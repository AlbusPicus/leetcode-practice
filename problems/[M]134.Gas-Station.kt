/**
 * Runtime: 160 ms, faster than 96.43% of Kotlin online submissions for Gas Station.
 * Memory Usage: 35.1 MB, less than 100.00% of Kotlin online submissions for Gas Station.
 */
class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        if (gas.size == 1 && gas[0] == cost[0]) return 0
        
        var currentGas = 0
        var currentStartIndex = -1
        
        for (i in 0 until gas.size) {
            val gasDifference = gas[i] - cost[i] 
            if (gasDifference > 0 && currentGas <= 0) {
                currentStartIndex = i
                currentGas = 0
            } else if (currentGas + gasDifference < 0) {
                currentStartIndex = -1
            }
            currentGas += gasDifference
        }
        for (i in 0 until currentStartIndex) {
            currentGas += gas[i] - cost[i]
            if (currentGas < 0) return -1
        }
        return currentStartIndex
    }
}
