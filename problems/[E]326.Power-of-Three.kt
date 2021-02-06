/**
 * Runtime: 228 ms, faster than 82.93% of Kotlin online submissions for Power of Three.
 * Memory Usage: 35.3 MB, less than 92.68% of Kotlin online submissions for Power of Three.
 */
class Solution {
    fun isPowerOfThree(n: Int): Boolean {
        if (n == 0) return false
        
        var number = n
        while (number % 3 == 0) {
            number /= 3
        }
        return number == 1
    }
}
