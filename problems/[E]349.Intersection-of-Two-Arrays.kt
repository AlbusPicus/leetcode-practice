/**
 * Runtime: 180 ms, faster than 93.88% of Kotlin online submissions for Intersection of Two Arrays.
 * Memory Usage: 35.8 MB, less than 92.86% of Kotlin online submissions for Intersection of Two Arrays.
 */
class Solution {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val elements = mutableSetOf<Int>()
        nums1.forEach { value -> 
            elements.add(value) 
        }
        val resultList = mutableListOf<Int>()
        nums2.forEach { value -> 
            if (value in elements) {
                resultList.add(value)
                elements.remove(value)
            }
        }
        val result = IntArray(resultList.size) { resultList[it] }
        return result
    }
}
