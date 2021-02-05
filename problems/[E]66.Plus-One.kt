/**
 * Runtime: 164 ms, faster than 81.74% of Kotlin online submissions for Plus One.
 * Memory Usage: 36.2 MB, less than 53.88% of Kotlin online submissions for Plus One.
 */
class Solution {
    fun plusOne(digits: IntArray): IntArray {
        var increment = true
        var incrementIndex = digits.lastIndex
        while (increment && incrementIndex >= 0) {
            if (digits[incrementIndex] == 9) {
                digits[incrementIndex] = 0
            } else {
                digits[incrementIndex] = digits[incrementIndex] + 1
                increment = false
            }
            incrementIndex--
        }
        val result = if (increment) {
            IntArray(digits.size + 1).also { array ->
                array[0] = 1
            }
        } else digits
        
        return result
    }
}
