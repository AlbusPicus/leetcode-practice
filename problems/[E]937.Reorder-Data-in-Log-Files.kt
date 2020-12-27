/**
 * Runtime: 200 ms, faster than 96.00% of Kotlin online submissions for Reorder Data in Log Files.
 * Memory Usage: 38.1 MB, less than 46.00% of Kotlin online submissions for Reorder Data in Log Files.
 */
class Solution {
    fun reorderLogFiles(logs: Array<String>): Array<String> {
        val result = Array<String>(logs.size) { "" }
        var index = 0
        var backwardIndex = logs.size - 1
        logs.forEach { log ->
            if (isLetterLog(log)) {
                result[index] = log
                index++
            } else {
                result[backwardIndex] = log
                backwardIndex--
            }
        }
        
        backwardIndex++
        sortDigitLogs(result, backwardIndex)
        sortStringLogs(result)
        
        return result
    }
    
    fun sortStringLogs(logs: Array<String>) {
        val digitLogCompareString = String(charArrayOf('z' + 1))
        logs.sortBy { log ->
            if (isLetterLog(log)) {
                val firstSpaceIndex = log.indexOf(' ')
                log.substring(firstSpaceIndex + 1) + log.substring(0, firstSpaceIndex)
            } else digitLogCompareString
        }
    }
    
    fun sortDigitLogs(logs: Array<String>, firstIndex: Int) {
        var leftIndex = firstIndex
        var rightIndex = logs.size - 1
        while (leftIndex < rightIndex) {
            val tmp = logs[leftIndex]
            logs[leftIndex] = logs[rightIndex]
            logs[rightIndex] = tmp
            leftIndex++
            rightIndex--
        }
    }
    
    fun isLetterLog(log: String): Boolean {
        val firstSpaceIndex = log.indexOf(' ')
        val wordSymbol = log.get(firstSpaceIndex + 1)
        return wordSymbol >= 'a' && wordSymbol <= 'z'
    }
}
