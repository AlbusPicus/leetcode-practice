class Solution {
    fun maxNonOverlapping(nums: IntArray, target: Int): Int {
        var cumulativeSum = 0
        var currentMaximum = 0 
        val sumToCurrentMax = mutableMapOf<Int, Int>(0 to 0)
        var savedMaximum: Int? = null
        for (i in 0 until nums.size) {
            cumulativeSum += nums[i]
            savedMaximum = sumToCurrentMax.get(cumulativeSum - target)
            if (savedMaximum != null) { 
                currentMaximum = Math.max(currentMaximum, savedMaximum + 1) 
            }
            sumToCurrentMax.put(cumulativeSum, currentMaximum)
        }
        return currentMaximum
    }
    
}
