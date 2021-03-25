/**
 * Runtime: 320 ms, faster than 80.88% of Kotlin online submissions for Word Ladder.
 * Memory Usage: 37.8 MB, less than 92.65% of Kotlin online submissions for Word Ladder.
 */
class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val words = mutableSetOf<String>()
        words.addAll(wordList)
        if (endWord !in wordList) return 0
        
        var count = 1 

        val queue = LinkedList<String>()
        queue.offerLast(beginWord)
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val currentWord = queue.pollFirst()
                val chars = currentWord.toCharArray()
                for (j in 0 until chars.size) {
                    val originalChar = chars[j]
                    for (substituteChar in 'a'..'z') {
                        chars[j] = substituteChar
                        val tempWord = String(chars)
                        if (endWord == tempWord) return count + 1

                        if (tempWord in words) {
                            queue.offerLast(tempWord)
                            words.remove(tempWord)
                        }
                    }
                    chars[j] = originalChar
                }
            }
            count++
        }
        return 0
    }
    
}
