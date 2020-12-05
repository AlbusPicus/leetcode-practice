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
        
        maxValue = correctMaxValue(maxValue)
        
        var middleValue = (minValue + maxValue) / 2
        var currentSquare = 0
        
        while (minValue < maxValue) {
            currentSquare = middleValue * middleValue
            if (currentSquare < x && minValue != middleValue) {
                minValue = middleValue
            } else if (currentSquare > x && maxValue != middleValue) {
                maxValue = middleValue
            } else {
                minValue = middleValue
                maxValue = middleValue
            }
            middleValue = (minValue + maxValue + 1) / 2
            
            
        }
        return if (middleValue * middleValue > x) (middleValue - 1) else middleValue
    }
    
    fun correctMaxValue(maxValue: Int): Int {
        return if (maxValue > MAX_INTEGER_SQUARE_ROOT) {
            MAX_INTEGER_SQUARE_ROOT
        } else maxValue
    }
    
    companion object {
        private const val MAX_INTEGER_SQUARE_ROOT = 46340
    }
}
