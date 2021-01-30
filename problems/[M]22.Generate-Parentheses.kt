/**
 * Runtime: 148 ms, faster than 99.27% of Kotlin online submissions for Generate Parentheses.
 * Memory Usage: 37 MB, less than 31.39% of Kotlin online submissions for Generate Parentheses.
 */
class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val answer = mutableListOf<String>()
        
        val sb = StringBuilder()
        populateCombinations(n, 0, 0, sb, answer)
        
        return answer
    }
    
    private fun populateCombinations(n: Int, openCount: Int, closeCount: Int, sb: StringBuilder, answer: MutableList<String>) {
        if (openCount == n && closeCount == n) {
            answer.add(sb.toString())
            return
        }
        val len = openCount + closeCount
        
        if (openCount < n) {
            sb.append('(')
            populateCombinations(n, openCount + 1, closeCount, sb, answer)

            sb.setLength(len)
        }
        
        if (openCount > closeCount) {
            sb.append(')')
            populateCombinations(n, openCount, closeCount + 1, sb, answer)
            
            sb.setLength(len)
        }
    }
}
