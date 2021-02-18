/**
 * Runtime: 204 ms, faster than 69.23% of Kotlin online submissions for Largest Number.
 * Memory Usage: 37.1 MB, less than 76.92% of Kotlin online submissions for Largest Number.
 */
class Solution {
    fun largestNumber(nums: IntArray): String {
        val numbers = mutableListOf<String>()
        nums.forEach { number ->
            numbers.add(number.toString())
        }
        val sorted = numbers.sortedWith(Comparator { first, second -> 
            val directOrder = first + second
            val reversedOrder = second + first
            reversedOrder.compareTo(directOrder)
        })
            
        return if (sorted.first() == "0") "0" else sorted.fold("") { acc, number -> acc + number }
    }
    
}
