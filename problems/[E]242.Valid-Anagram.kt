/**
 * Runtime: 180 ms, faster than 82.21% of Kotlin online submissions for Valid Anagram.
 * Memory Usage: 35.8 MB, less than 85.10% of Kotlin online submissions for Valid Anagram.
 */
class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val charFrequencyMap = mutableMapOf<Char, Int>()
        s.forEach { char ->
            val newFrequency = charFrequencyMap.getOrElse(char, { 0 }) + 1
            charFrequencyMap.put(char, newFrequency)
        }
        t.forEach { char ->
            val newFrequency = charFrequencyMap.getOrElse(char, { 0 }) - 1
            charFrequencyMap.put(char, newFrequency)
        }
        return charFrequencyMap.values.none { it != 0 }
    }
}
