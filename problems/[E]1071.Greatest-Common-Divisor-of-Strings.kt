/**
 * Runtime: 176 ms, faster than 100.00% of Kotlin online submissions for Greatest Common Divisor of Strings.
 * Memory Usage: 35.2 MB, less than 100.00% of Kotlin online submissions for Greatest Common Divisor of Strings.
 */
class Solution {
    fun gcdOfStrings(str1: String, str2: String): String {
        val str1Length = str1.length
        val str2Length = str2.length
        
        val smallerCharArray: CharArray 
        val biggerCharArray: CharArray 
        if (str1Length < str2Length) {
            smallerCharArray = str1.toCharArray() 
            biggerCharArray = str2.toCharArray()
        } else {
            smallerCharArray = str2.toCharArray()
            biggerCharArray = str1.toCharArray()
        }
        
        for (i in smallerCharArray.size downTo 1) {
            if (isDivisor(smallerCharArray, smallerCharArray, i) && isDivisor(biggerCharArray, smallerCharArray, i)) {
                return String(smallerCharArray, 0, i)
            }
        }
        return ""
    }
    
    private fun isDivisor(biggerCharArray: CharArray, smallerCharArray: CharArray, divisorCount: Int): Boolean {
        if (biggerCharArray.size % divisorCount != 0) return false
        
        for (i in 0 until biggerCharArray.size) {
            if (biggerCharArray[i] != smallerCharArray[i % divisorCount]) {
                return false
            }
        }
        return true
        
    }
    
}
