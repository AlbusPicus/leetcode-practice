class Solution {
    
    fun mySqrt(x: Int): Int {
        if (x == 0) {
            return 0
        }
        
        var digitsCount = 0
        var tempNumber = x
        while (tempNumber > 0) {
            digitsCount++
            tempNumber /= 10
        }
        val rootMaxDigits = digitsCount / 2 + if (digitsCount % 2 > 0) 1 else 0
        var minValue = 1
        var maxValue = 9
        for (i in 2 .. rootMaxDigits) {
            minValue *= 10
            maxValue = maxValue * 10 + 9
        }
        
        var middleValue = (minValue + maxValue + 1) / 2
        var dividedNumber = 0
        
        while (minValue < maxValue) {
            dividedNumber = x / middleValue
            if (dividedNumber > middleValue && minValue != middleValue) {
                minValue = middleValue
            } else if (dividedNumber < middleValue && maxValue != middleValue) {
                maxValue = middleValue
            } else {
                minValue = middleValue
                maxValue = middleValue
            }
            middleValue = (minValue + maxValue + 1) / 2
        }
        return if (x / middleValue < middleValue) (middleValue - 1) else middleValue
    }
    
}
