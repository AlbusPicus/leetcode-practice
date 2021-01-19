/**
 * Runtime: 636 ms, faster than 100.00% of Kotlin online submissions for Corporate Flight Bookings.
 * Memory Usage: 68.6 MB, less than 100.00% of Kotlin online submissions for Corporate Flight Bookings.
 */
class Solution {
    fun corpFlightBookings(bookings: Array<IntArray>, n: Int): IntArray {
        val result = IntArray(n) { 0 }
        bookings.forEach { booking ->
            val firstFlight = booking[0]
            val lastFlight = booking[1]
            val tickets = booking[2]
            
            result[firstFlight - 1] += tickets
            if (lastFlight < n) {
                result[lastFlight] -= tickets
            }
        }
        
        for (i in 1 until n) {
            result[i] += result[i - 1]
        }
        return result
    }
}
