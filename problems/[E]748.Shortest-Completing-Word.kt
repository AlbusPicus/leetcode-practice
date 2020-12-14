/*
 * Runtime: 220 ms, faster than 50.00% of Kotlin online submissions for Shortest Completing Word.
 * Memory Usage: 37.9 MB, less than 50.00% of Kotlin online submissions for Shortest Completing Word.
 */

class Solution {
    fun shortestCompletingWord(licensePlate: String, words: Array<String>): String {
        val licenseMap = mutableMapOf<Char, Int>()
        licensePlate.forEach { char ->
            val lowerCaseChar = char.toLowerCase()
            if (lowerCaseChar >= 'a' && lowerCaseChar <= 'z') {
                licenseMap.set(lowerCaseChar, licenseMap.getOrElse(lowerCaseChar) { 0 } + 1)         
            }
        }
        val licenseEntries = licenseMap.entries
        
        words.sortBy { it.length }
        
        words.forEach { word ->
            val characters = mutableMapOf<Char, Int>()
            word.forEach { char ->
                characters.set(char, characters.getOrElse(char) { 0 } + 1)         
            }
            var acceptable = true
            licenseEntries.forEach { entry ->
                if (characters.getOrElse(entry.key) { 0 } < entry.value) {
                    acceptable = false
                }
            }
            if (acceptable) {
                return word
            }
        }
        throw IllegalStateException("No words are valid. Should not be possible by constraints")
    }
}
