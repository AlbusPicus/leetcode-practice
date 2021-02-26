/**
 * Runtime: 288 ms, faster than 89.79% of Kotlin online submissions for Product of Array Except Self.
 * Memory Usage: 44.1 MB, less than 88.94% of Kotlin online submissions for Product of Array Except Self.
 */
class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        var currentProduct = 1
        val prefixProduct = IntArray(nums.size) { i ->
            currentProduct *= nums[i]
            currentProduct
        }
        currentProduct = 1
        for (i in nums.size - 1 downTo 1) {
            prefixProduct[i] = prefixProduct[i - 1] * currentProduct
            currentProduct *= nums[i]
        }
        prefixProduct[0] = currentProduct
        
        return prefixProduct
    }
}
