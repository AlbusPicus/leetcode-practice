/**
 * Runtime: 140 ms, faster than 82.43% of Kotlin online submissions for Valid Parentheses.
 * Memory Usage: 34.9 MB, less than 37.09% of Kotlin online submissions for Valid Parentheses.
 */
class Solution {
    fun isValid(s: String): Boolean {
        val openedStack = LinkedList<Char>()
        s.forEach { char ->
            if (isOpenParentheses(char)) {
                openedStack.offerLast(char)
            } else {
                val savedChar = openedStack.pollLast()
                if (parenthesisMap.get(savedChar) != char) return false
            }
        }
        return openedStack.isEmpty()
    }
    
    private fun isOpenParentheses(char: Char): Boolean {
        return char in parenthesisMap.keys
    }
    
    companion object {
        private val parenthesisMap = mapOf(
            '(' to ')',
            '{' to '}',
            '[' to ']'
        )
    }
}
