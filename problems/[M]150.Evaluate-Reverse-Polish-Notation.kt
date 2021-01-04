/**
 * Runtime: 172 ms, faster than 92.68% of Kotlin online submissions for Evaluate Reverse Polish Notation.
 * Memory Usage: 36 MB, less than 39.02% of Kotlin online submissions for Evaluate Reverse Polish Notation.
 */
class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val numbersStack = LinkedList<Int>()
        tokens.forEach { token -> 
            if (isOperator(token)) {
                val secondNumber = numbersStack.removeLast()
                val firstNumber = numbersStack.removeLast()
                val resultNumber = when (token.get(0)) {
                    '+' -> firstNumber + secondNumber
                    '-' -> firstNumber - secondNumber
                    '*' -> firstNumber * secondNumber
                    '/' -> firstNumber / secondNumber
                    else -> throw UnsupportedOperationException("This operator is not supported")
                }
                numbersStack.offerLast(resultNumber)
            } else {
                numbersStack.offerLast(token.toInt())
            }
        }
        return numbersStack.removeLast()
    }
    
    fun isOperator(token: String): Boolean {
        return token.length == 1 && (token.get(0) < '0' || token.get(0) > '9')
    }
}
