/**
 * Runtime: 220 ms, faster than 47.96% of Kotlin online submissions for Count Primes.
 * Memory Usage: 41.1 MB, less than 17.35% of Kotlin online submissions for Count Primes.
 */
class Solution {
    fun countPrimes(n: Int): Int {
        val isPrime = Array<Boolean>(n) { true }
        
        var primesCount = 0
        for (i in 2 until n) {
            if (isPrime[i]) {
                primesCount++
                val prime = i
                for (j in 2 * prime until n step prime) {
                    isPrime[j] = false
                }
                
            }
        }
        
        return primesCount
    }

}
