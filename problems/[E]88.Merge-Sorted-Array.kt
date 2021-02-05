/**
 * Runtime: 172 ms, faster than 60.78% of Kotlin online submissions for Merge Sorted Array.
 * Memory Usage: 35.5 MB, less than 50.39% of Kotlin online submissions for Merge Sorted Array.
 */
class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        val numbersStack = LinkedList<Int>()
        var firstIndex = 0
        var secondIndex = 0
        while (firstIndex < m && secondIndex < n) {
            var stackedValue = numbersStack.peekFirst()
            if (stackedValue != null) {
                numbersStack.offerLast(nums1[firstIndex])
                if (stackedValue < nums2[secondIndex]) {
                    nums1[firstIndex] = numbersStack.pollFirst()
                } else {
                    nums1[firstIndex] = nums2[secondIndex]
                    secondIndex++
                }
            } else {
                if (nums1[firstIndex] > nums2[secondIndex]) {
                    numbersStack.offerLast(nums1[firstIndex])
                    nums1[firstIndex] = nums2[secondIndex]
                    secondIndex++
                }
            }
            firstIndex++
        }
        while (numbersStack.isNotEmpty()) {
            var stackedValue = numbersStack.peekFirst()
            if (firstIndex < m) {
                numbersStack.offerLast(nums1[firstIndex])
                nums1[firstIndex] = numbersStack.pollFirst()
            } else if (secondIndex < n) {
                if (stackedValue < nums2[secondIndex]) {
                    nums1[firstIndex] = numbersStack.pollFirst()
                } else {
                    nums1[firstIndex] = nums2[secondIndex]
                    secondIndex++
                }
            } else {
                nums1[firstIndex] = numbersStack.pollFirst()
            }
            firstIndex++
        }
        
        while (secondIndex < n) {
            nums1[firstIndex] = nums2[secondIndex]
            firstIndex++
            secondIndex++
        }
    }
}
