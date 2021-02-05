/**
 * Runtime: 160 ms, faster than 91.43% of Kotlin online submissions for Merge Sorted Array.
 * Memory Usage: 35.3 MB, less than 74.03% of Kotlin online submissions for Merge Sorted Array.
 */
class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var firstIndex = m - 1
        var secondIndex = n - 1
        var position = m + n - 1
        
        while (firstIndex >= 0 && secondIndex >= 0) {
            if (nums1[firstIndex] > nums2[secondIndex]) {
                nums1[position] = nums1[firstIndex]
                firstIndex--
            } else {
                nums1[position] = nums2[secondIndex]
                secondIndex--
            }
            position--
        }
        
        while (secondIndex >= 0) {
            nums1[position] = nums2[secondIndex]
            secondIndex--
            position--
        }
        
    }
}
