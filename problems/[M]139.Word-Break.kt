/**
 * Runtime: 152 ms, faster than 94.12% of Kotlin online submissions for Word Break.
 * Memory Usage: 36.7 MB, less than 45.59% of Kotlin online submissions for Word Break.
 */
class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val dictionary = wordDict.toSet()
        val attempts = mutableSetOf<Int>()
        return canStringBreak(s.toCharArray(), 0, dictionary, attempts)
    }
    
    private fun canStringBreak(
        chars: CharArray, 
        index: Int, 
        wordDict: Set<String>, 
        attempts: MutableSet<Int>
    ): Boolean {
        if (index >= chars.size) return true
        if (index in attempts) return false
        
        for (i in index until chars.size) {
            var stringToTest = String(chars, index, i - index + 1)
            if (wordDict.contains(stringToTest) && canStringBreak(chars, i + 1, wordDict, attempts)) {
                return true
            }
        }
        attempts.add(index)
        return false
    }
    
}
