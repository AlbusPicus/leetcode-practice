class Solution(nums: IntArray) {
    
    val originalState = nums
    val random = Random()
    
    var indexes = mutableListOf<Int>()
    
    init {
        for (i in 0 until nums.size) {
            indexes.add(i)
        }
    }

    /** Resets the array to its original configuration and return it. */
    fun reset(): IntArray {
        return originalState;
    }

    /** Returns a random shuffling of the array. */
    fun shuffle(): IntArray {
        val shuffleIndexes = ArrayList<Int>(indexes)
        val shuffledArray = IntArray(originalState.size)
        var insertIndex = 0
        var originalIndex: Int = 0
        for (i in indexes.size downTo 1) { //exclusive upper bound for random int
            originalIndex = shuffleIndexes.get(random.nextInt(i))
            shuffleIndexes.remove(originalIndex)
            shuffledArray[insertIndex] = originalState[originalIndex]
            insertIndex++
        }
        return shuffledArray
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(nums)
 * var param_1 = obj.reset()
 * var param_2 = obj.shuffle()
 */
