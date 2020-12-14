/*
 * Runtime: 328 ms, faster than 100.00% of Kotlin online submissions for Can Convert String in K Moves.
 * Memory Usage: 40.4 MB, less than 100.00% of Kotlin online submissions for Can Convert String in K Moves.
 */

class Solution {
    fun canConvertString(s: String, t: String, k: Int): Boolean {
        if (s.length != t.length) {
            return false
        }
        
        val alphabetLength = 'z' - 'a' + 1
        
        val attemptsMap = mutableMapOf<Int, Int>()
        s.forEachIndexed { index, char ->
            var difference = t.get(index) - char
            if (difference < 0) {
               difference = difference + alphabetLength
            }
            if (difference != 0) {
                val attemptsCount = attemptsMap.getOrElse(difference) { 0 }
                if (difference + attemptsCount * alphabetLength > k) {
                    return false
                } else {
                    attemptsMap.set(difference, attemptsCount + 1)
                }
            }
        }
        return true    
    }
    
}
