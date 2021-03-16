/**
 * Runtime: 260 ms, faster than 87.81% of Kotlin online submissions for Median of Two Sorted Arrays.
 * Memory Usage: 40.9 MB, less than 93.55% of Kotlin online submissions for Median of Two Sorted Arrays.
 */
class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val combinedSize = nums1.size + nums2.size
        val mergedArray = IntArray(combinedSize)
        var firstPointer = 0
        var secondPointer = 0
        var insertIndex = 0
        while (firstPointer < nums1.size && secondPointer < nums2.size) {
            if (nums1[firstPointer] > nums2[secondPointer]) {
                mergedArray[insertIndex] = nums2[secondPointer]
                secondPointer++
            } else {
                mergedArray[insertIndex] = nums1[firstPointer]
                firstPointer++
            }
            insertIndex++
        }
        val remaining = if (firstPointer < nums1.size) nums1 else nums2
        var index = if (firstPointer < nums1.size) firstPointer else secondPointer
        for (i in insertIndex until combinedSize) {
            mergedArray[i] = remaining[index]
            index++
        }
        
        return if (combinedSize % 2 == 0) {
            (mergedArray[combinedSize / 2] + mergedArray[combinedSize / 2 - 1]) / 2.0
        } else {
            mergedArray[combinedSize / 2].toDouble()
        }
    }
}
