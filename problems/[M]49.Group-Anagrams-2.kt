/**
 * Runtime: 276 ms, faster than 98.15% of Kotlin online submissions for Group Anagrams.
 * Memory Usage: 41.7 MB, less than 81.94% of Kotlin online submissions for Group Anagrams.
 */
class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val wordMap = mutableMapOf<Long, MutableList<String>>()
        strs.forEach { word ->
            var product = 1L
            word.forEach { char ->
                product *= primes[char.toInt() - 'a'.toInt()]
            }
            
            val anagrams = wordMap.getOrElse(product, { mutableListOf() })
            anagrams.add(word)
            wordMap.put(product, anagrams)
        }
        return wordMap.values.toList()
    }
    
    companion object {
        private val primes = listOf(
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101
        )
    }
}
