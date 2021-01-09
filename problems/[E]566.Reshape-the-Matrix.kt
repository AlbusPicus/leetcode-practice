/**
 * Runtime: 244 ms, faster than 100.00% of Kotlin online submissions for Reshape the Matrix.
 * Memory Usage: 37.5 MB, less than 100.00% of Kotlin online submissions for Reshape the Matrix.
 */
class Solution {
    fun matrixReshape(nums: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        val originalHeight = nums.size
        val originalWidth = nums[0].size
        if (r*c != originalHeight * originalWidth) {
            return nums
        }
        
        var pointer = -1
        val result = Array(r) { 
            IntArray(c) {
                pointer++
                nums[pointer / originalWidth][pointer % originalWidth]
            }
        }
        
        return result
    }
}
