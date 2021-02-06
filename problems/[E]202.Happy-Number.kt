/**
 * Runtime: 156 ms, faster than 57.01% of Kotlin online submissions for Happy Number.
 * Memory Usage: 33.9 MB, less than 46.73% of Kotlin online submissions for Happy Number.
 */
class Solution {
    fun isHappy(n: Int): Boolean {
        var number = n
        val checkedNumbersSet = mutableSetOf<Int>()
        while (number != 1 && number !in checkedNumbersSet) {
            checkedNumbersSet.add(number)
            var newNumber = 0
            while (number != 0) {
                var digit = number % 10
                newNumber += digit * digit
                number /= 10
            }
            
            number = newNumber
        }
        return number % 10 == 1
    }
}
