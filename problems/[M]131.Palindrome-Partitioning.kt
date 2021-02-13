/**
 * Runtime: 760 ms, faster than 40.43% of Kotlin online submissions for Palindrome Partitioning.
 * Memory Usage: 60.4 MB, less than 89.36% of Kotlin online submissions for Palindrome Partitioning.
 */
class Solution {
    fun partition(s: String): List<List<String>> {
        val result = mutableListOf<List<String>>()
        val chars = s.toCharArray()
        for(i in 0 until chars.size) {
            getPartitions(chars, 0, i)?.let { result.addAll(it) }
        }
        
        return result
    }
    
    private fun getPartitions(chars: CharArray, startIndex: Int, partitionIndex: Int): List<MutableList<String>>? {
        if (!isPalindrome(chars, startIndex, partitionIndex)) return null
        
        val palindrome = String(chars, startIndex, partitionIndex - startIndex + 1)
        var result: MutableList<MutableList<String>>? = null 
        
        val nextIndex = partitionIndex + 1
        if (nextIndex == chars.size) {
            result = mutableListOf(mutableListOf(palindrome))
        } else {
            for(i in nextIndex until chars.size) {
                getPartitions(chars, nextIndex, i)?.let { partitions ->
                    if (result == null) {
                        result = mutableListOf<MutableList<String>>()
                    }
                    partitions.forEach { 
                        it.add(0, palindrome) 
                    }
                    result?.addAll(partitions) 
                }
            }
        }
        return result
    }
    
    private fun isPalindrome(chars: CharArray, startIndex: Int, endIndex: Int): Boolean {
        var start = startIndex
        var end = endIndex
        while (start < end) {
            if (chars[start] != chars[end]) return false
            start++
            end--
        }
        return true
    }
}
