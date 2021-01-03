/**
 * Runtime: 160 ms, faster than 80.00% of Kotlin online submissions for Length of Last Word.
 * Memory Usage: 34.7 MB, less than 84.29% of Kotlin online submissions for Length of Last Word.
 */
class Solution {
    fun lengthOfLastWord(s: String): Int {
        val chars = s.toCharArray()
        var wordSize = 0
        var index = chars.size - 1
        
        //escape trailing whitespace
        while (index >= 0 && chars[index] == ' ') {
            index--
        }
        
        //count word symbols
        while (index >= 0 && chars[index] != ' ') {
            index--
            wordSize++
        }
        
        return wordSize
    }
}
