/**
 * Runtime: 116 ms, faster than 100.00% of Kotlin online submissions for Largest Substring Between Two Equal Characters.
 * Memory Usage: 33.2 MB, less than 89.29% of Kotlin online submissions for Largest Substring Between Two Equal Characters.
 */
class Solution {
    fun maxLengthBetweenEqualCharacters(s: String): Int {
        val firstOccuranceMap = mutableMapOf<Char, Int>()
        var maxDistance = -1
        s.forEachIndexed { index, char ->
            val firstIndex = firstOccuranceMap[char]
            if (firstIndex != null) {
                maxDistance = Math.max(maxDistance, index - firstIndex - 1)
            } else {
                firstOccuranceMap.put(char, index)
            }   
        }
        return maxDistance
    }
}
