/**
 * Runtime: 208 ms, faster than 100.00% of Kotlin online submissions for Kth Smallest Instructions.
 * Memory Usage: 36.1 MB, less than 100.00% of Kotlin online submissions for Kth Smallest Instructions.
 */
class Solution {
    fun kthSmallestPath(destination: IntArray, k: Int): String {
        var target = k.toBigInteger()
        var VCount = destination[0]
        var HCount = destination[1]
        var firstV = 0
        val size = VCount + HCount
        var index = 0
        
        val symbols = CharArray(size) { ' '}
        
        while (HCount > 0 || VCount > 0) {
            firstV = 0
            var premutationsNumber = numberOfPremutations(VCount, HCount - firstV)
            while (firstV < HCount && premutationsNumber > target) {
                firstV++
                premutationsNumber = numberOfPremutations(VCount, HCount - firstV)
            }
            if (premutationsNumber < target) {
                firstV--
            }
            
            target = target.minus(premutationsNumber)
            
            for (i in 0 until firstV) {
                symbols[i + index] = 'H'
                HCount--
            }
            symbols[firstV + index] = 'V'
            VCount--        
            
            index += firstV + 1
            
            when {
                target == BigInteger.ZERO -> {
                    for (i in 0 until VCount) {
                        symbols[index + i] = 'V'
                    }
                    for (i in index + VCount until size) {
                        symbols[i] = 'H'
                    }
                    VCount = 0
                    HCount = 0
                } 
                HCount == 0 -> {
                    for (i in index until size) {
                        symbols[i] = 'V'
                    }
                    VCount = 0
                } 
                VCount == 0 -> {
                    for (i in index until size) {
                        symbols[i] = 'H'
                    }
                    HCount = 0
                }
            }
        }
        
        return String(symbols)
    }
    
    private fun numberOfPremutations(VCount: Int, HCount: Int): BigInteger {
        return factorial(VCount + HCount).divide(factorial(VCount).multiply(factorial(HCount)))
    }
    
    private fun factorial(n: Int): BigInteger {
        var result = 1.toBigInteger()
        for (i in 2..n) result = result.multiply(i.toBigInteger())
        return result
    }
}
