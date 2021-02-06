/**
 * Runtime: 184 ms, faster than 88.89% of Kotlin online submissions for Intersection of Two Arrays II.
 * Memory Usage: 36.4 MB, less than 67.36% of Kotlin online submissions for Intersection of Two Arrays II.
 */
class Solution {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        nums1.sort()
        nums2.sort()
        return if (nums1.size > nums2.size) {
            getIntersection(nums2, nums1)
        } else {
            getIntersection(nums1, nums2)
        }
    }
    
    fun getIntersection(smallerArray: IntArray, biggerArray: IntArray): IntArray {
        var sameItemsCount = 0
        var biggerIndex = 0
        for (i in 0 until smallerArray.size) {
            val number = smallerArray[i]
            while (biggerIndex < biggerArray.size && biggerArray[biggerIndex] < number) { 
                biggerIndex++ 
            }
            
            if (biggerIndex == biggerArray.size) break
            
            if (number == biggerArray[biggerIndex]) {
                sameItemsCount++
                biggerIndex++
            }
        }
        val result = IntArray(sameItemsCount)
        biggerIndex = 0
        var insertIndex = 0
        for (i in 0 until smallerArray.size) {
            val number = smallerArray[i]
            while (biggerIndex < biggerArray.size && biggerArray[biggerIndex] < number) { 
                biggerIndex++ 
            }
            
            if (biggerIndex == biggerArray.size) break
            
            if (number == biggerArray[biggerIndex]) {
                result[insertIndex] = number
                insertIndex++
                biggerIndex++
            }
        }
        return result
    }
}
