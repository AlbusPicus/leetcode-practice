/**
 * Runtime: 216 ms, faster than 50.00% of Kotlin online submissions for Minimum Insertions to Balance a Parentheses String.
 * Memory Usage: 36.9 MB, less than 100.00% of Kotlin online submissions for Minimum Insertions to Balance a Parentheses String.
 */
class Solution {
    fun minInsertions(s: String): Int {
        val processData = ProcessData()
        s.forEach { char ->
            if (char == LEFT_PARENTHESIS) {
                foldUnparredRightParenthesis(processData)
                processData.isLastUnparedRight = false
                processData.leftParenthesisCount++
            } else if (processData.isLastUnparedRight) {
                processData.isLastUnparedRight = false
                consumeLeftParenthesus(processData)
            } else {
                processData.isLastUnparedRight = true
            }
        }
        foldUnparredRightParenthesis(processData)
        processData.insertionsNeeded += 2 * processData.leftParenthesisCount
        return processData.insertionsNeeded
    }
    
    private fun consumeLeftParenthesus(processData: ProcessData) {
        if (processData.leftParenthesisCount > 0) {
            processData.leftParenthesisCount--
        } else {
            processData.insertionsNeeded++
        }
    }
    
    private fun foldUnparredRightParenthesis(processData: ProcessData) {
        if (processData.isLastUnparedRight) {
            processData.insertionsNeeded++
            consumeLeftParenthesus(processData)
        }
    }
    
    data class ProcessData(var leftParenthesisCount: Int = 0, var isLastUnparedRight: Boolean = false, var insertionsNeeded: Int = 0)
    
    companion object {
        private const val LEFT_PARENTHESIS = '('
    }
}
