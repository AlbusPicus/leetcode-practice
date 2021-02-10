/**
 * Runtime: 400 ms, faster than 36.28% of Kotlin online submissions for Group Anagrams.
 * Memory Usage: 44.7 MB, less than 39.54% of Kotlin online submissions for Group Anagrams.
 */
class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val wordMap = mutableMapOf<Map<Char, Int>, MutableList<String>>()
        strs.forEach { word ->
            val wordChars = collectWordChars(word)
            val anagrams = wordMap.getOrElse(wordChars, { mutableListOf() })
            anagrams.add(word)
            wordMap.put(wordChars, anagrams)
        }
        return wordMap.values.toList()
    }
    
    private fun collectWordChars(word: String): Map<Char, Int> {
        val wordChars = mutableMapOf<Char, Int>()
        word.forEach { char ->
            val index = char
            wordChars[index] = wordChars.getOrElse(index, { 0 }) + 1
        }
        return wordChars
    }
}
