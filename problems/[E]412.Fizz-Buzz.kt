/**
 * Runtime: 168 ms, faster than 80.83% of Kotlin online submissions for Fizz Buzz.
 * Memory Usage: 36.5 MB, less than 63.33% of Kotlin online submissions for Fizz Buzz.
 */
class Solution {
    fun fizzBuzz(n: Int): List<String> {
        val result = mutableListOf<String>()
        for (i in 1 .. n) {
            var string: String = ""
            mappingsTable.entries.forEach { entry ->
                if (i % entry.key == 0) string += entry.value
            }
            if (string.isEmpty()) string = i.toString()
            result.add(string)
        }
        return result
    }
    
    companion object {
        private val mappingsTable = mapOf<Int, String>(
            3 to "Fizz",
            5 to "Buzz"
        )
    }
}
