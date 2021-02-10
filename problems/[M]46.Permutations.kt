/**
 * Runtime: 192 ms, faster than 93.86% of Kotlin online submissions for Permutations.
 * Memory Usage: 36.3 MB, less than 96.93% of Kotlin online submissions for Permutations.
 */
class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        generatePremutations(nums, 0, result)
        return result
    }
    
    fun generatePremutations(nums: IntArray, startIndex: Int, result: MutableList<List<Int>>) {
        val number = nums[startIndex]
        if (startIndex == nums.size - 1) {
            result.add(listOf(number))
        } else {
            generatePremutations(nums, startIndex + 1, result)
            val updatedResult = result.flatMap { premutation ->
                val size = premutation.size + 1
                val stepResult = mutableListOf<List<Int>>()
                for (i in 0 until size) {
                    val newPremutation = mutableListOf<Int>()
                    if (i == 0) {
                        newPremutation.add(number)
                        newPremutation.addAll(premutation)
                    } else {
                        for (j in 0 until i) {
                            newPremutation.add(premutation[j])
                        }
                        newPremutation.add(number)
                        for (j in i until size - 1) {
                            newPremutation.add(premutation[j])
                        }
                    }
                    stepResult.add(newPremutation)
                }
                stepResult
            }
            result.clear()
            result.addAll(updatedResult)
        }
    }
}
