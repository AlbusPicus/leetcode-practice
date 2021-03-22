/**
 * Runtime: 1948 ms, faster than 7.69% of Kotlin online submissions for Wildcard Matching.
 * Memory Usage: 116.9 MB, less than 5.13% of Kotlin online submissions for Wildcard Matching.
 */
class Solution {
    fun isMatch(s: String, p: String): Boolean {
        return isMatch(s, p, mutableMapOf())
    }
    
    fun isMatch(s: String, p: String, memo: MutableMap<MemoKey, Boolean>): Boolean {
        if (p.isEmpty()) {
            return s.isEmpty()
        } else if (s.isEmpty()) {
            return p.count { it == '*' } == p.length
        }
        
        val memoKey = MemoKey(s.length, p.length)
        val savedValue = memo[memoKey]
        if (savedValue != null) {
            return savedValue
        }
        
        val currentPattern = p[0]
        val result = when (currentPattern) {
            s[0], '?' -> isMatch(s.substring(1), p.substring(1), memo)
            '*' -> isMatch(s.substring(1), p, memo) || isMatch(s, p.substring(1), memo)
            else -> false
        }
        memo[memoKey] = result
        return result
    }
    
    data class MemoKey(val textLength: Int, val patternLength: Int)
}
