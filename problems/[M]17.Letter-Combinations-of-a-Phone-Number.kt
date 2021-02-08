/**
 * Runtime: 152 ms, faster than 91.35% of Kotlin online submissions for Letter Combinations of a Phone Number.
 * Memory Usage: 36.3 MB, less than 46.49% of Kotlin online submissions for Letter Combinations of a Phone Number.
 */
class Solution {
    fun letterCombinations(digits: String): List<String> {
        val result = mutableListOf<String>()
        digits.forEachIndexed { index, digit ->
            val dictionaryChars = phoneDictionary.getValue(digit)
            if (result.isEmpty()) {
                dictionaryChars.forEach { char ->
                    val array = char.toString()
                    // array[index] = char
                    result.add(array)
                }
            } else {
                val charsCount = dictionaryChars.size
                val resultsSize = result.size
                for (i in 0 until resultsSize) {
                    val element = result.removeAt(0)
                    val mappedList = mutableListOf<String>()
                    for (i in 0 until charsCount) {
                        mappedList.add(element + dictionaryChars[i])
                    }
                    result.addAll(mappedList)
                }
            }
            
        }
        return result
    }
    
    companion object {
        private val phoneDictionary = mapOf<Char, List<Char>>(
            '2' to listOf('a','b','c'),
            '3' to listOf('d','e','f'),
            '4' to listOf('g','h','i'),
            '5' to listOf('j','k','l'),
            '6' to listOf('m','n','o'),
            '7' to listOf('p','q','r', 's'),
            '8' to listOf('t','u','v'),
            '9' to listOf('w','x','y', 'z')
        )
    }
}
