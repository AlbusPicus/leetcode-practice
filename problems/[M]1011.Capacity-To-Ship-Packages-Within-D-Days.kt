/**
 * Runtime: 248 ms, faster than 100.00% of Kotlin online submissions for Capacity To Ship Packages Within D Days.
 * Memory Usage: 39.2 MB, less than 55.56% of Kotlin online submissions for Capacity To Ship Packages Within D Days.
 */
class Solution {
    fun shipWithinDays(weights: IntArray, D: Int): Int {
        var start = 0
        var end = 0
        weights.forEach { weight ->
            end += weight
        }
        var mid = start + (end - start) / 2
        
        while (start < end) {
            mid = start + (end - start) / 2
            if (checkIfPossibleInAtLeastDdays(weights, D, mid)) {
                end = mid
            } else {
                start = mid + 1
            }
        }
        
        return start
        
    }
    
    fun checkIfPossibleInAtLeastDdays(weights: IntArray, D: Int, shipCapacity: Int): Boolean {
        var numOfDays = 0
        var remaining = shipCapacity
        for (i in 0 until weights.size) {
            if (weights[i] > shipCapacity) {
                return false
            }
            remaining -= weights[i]
            if (remaining < 0) {
                numOfDays++
                remaining = shipCapacity - weights[i]
            }
        }
        numOfDays++
        
        return numOfDays <= D
        
        
    }
}
