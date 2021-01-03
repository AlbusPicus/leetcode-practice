/**
 * Runtime: 144 ms, faster than 97.14% of Kotlin online submissions for Length of Last Word.
 * Memory Usage: 35.3 MB, less than 67.14% of Kotlin online submissions for Length of Last Word.
 */
class Solution {
    fun lengthOfLastWord(s: String): Int {
        val chars = s.toCharArray()
        var wordSize = 0
        var index = chars.size - 1
        
        //trim trailing whitespace
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
