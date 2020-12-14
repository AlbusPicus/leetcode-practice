/*
 * Runtime: 336 ms, faster than 100.00% of Kotlin online submissions for Can Convert String in K Moves.
 * Memory Usage: 41.4 MB, less than 100.00% of Kotlin online submissions for Can Convert String in K Moves.
 */

class Solution {
    fun canConvertString(s: String, t: String, k: Int): Boolean {
        if (s.length != t.length) {
            return false
        }
        val alphabetLength = 'z' - 'a' + 1
        
        val differenceArray = mutableListOf<Int>()
        val attemptsMap = mutableMapOf<Int, Int>()
        val usedAttempts = mutableSetOf<Int>()
        s.forEachIndexed { index, char ->
            var difference = t.get(index) - char
            if (difference < 0) {
               difference = difference + alphabetLength
            }
            if (difference != 0) {
                val current = attemptsMap.getOrElse(difference) { 0 }
                if (difference + current * alphabetLength > k) {
                    return false
                } else {
                    attemptsMap.set(difference, current + 1)
                }
            }
        }
        return true    
    }
    
}
