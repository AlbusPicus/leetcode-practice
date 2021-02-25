/**
 * Runtime: 244 ms, faster than 44.30% of Kotlin online submissions for Basic Calculator II.
 * Memory Usage: 43.1 MB, less than 11.39% of Kotlin online submissions for Basic Calculator II.
 */
class Solution {
    
    val numberStack = LinkedList<Long>()
    val operationStack = LinkedList<Char>()
    val operations = setOf('+', '-', '*', '/')
    
    fun calculate(s: String): Int {
        var lastNumber = false
        s.forEach { char ->
            when {
                char == ' ' -> {
                    lastNumber = false
                }
                char in operations -> {
                    lastNumber = false
                    operationStack.offerLast(char)
                }
                else -> {
                    val number = char - '1' + 1
                    if (lastNumber) {
                         val last = numberStack.pollLast()
                         numberStack.offerLast(last * 10L + number)
                    } else {
                        numberStack.offerLast(number.toLong())
                    }
                    lastNumber = true
                }
            }
        }
        
        while (operationStack.isNotEmpty()) {
            val operation = operationStack.pollFirst()
            val number = numberStack.pollFirst()
            if (isPriorityOperation(operation)) {
                val rightNumber = numberStack.pollFirst()
                val result = performOperation(operation, number, rightNumber)
                numberStack.offerFirst(result)
            } else {
                val nextOperation = operationStack.peekFirst()
                if (nextOperation != null && isPriorityOperation(nextOperation)) {
                    operationStack.pollFirst()
                    val leftNumber = numberStack.pollFirst()
                    val rightNumber = numberStack.pollFirst()
                    val result = performOperation(nextOperation, leftNumber, rightNumber)
                    numberStack.offerFirst(result)
                    numberStack.offerFirst(number)
                    operationStack.offerFirst(operation)
                } else {
                    val rightNumber = numberStack.pollFirst()
                    val result = performOperation(operation, number, rightNumber)
                    numberStack.offerFirst(result)
                }
            }
        }
        
        return numberStack.pollLast().toInt()
        
    }
    
    private fun performOperation(operation: Char, firstNumber: Long, secondNumber: Long): Long {
        return when (operation) {
            '*' -> firstNumber * secondNumber
            '/' -> firstNumber / secondNumber
            '+' -> firstNumber + secondNumber
            '-' -> firstNumber - secondNumber
            else -> throw IllegalArgumentException()
        }
    }
    
    private fun isPriorityOperation(operation: Char): Boolean {
        return operation == '*' || operation == '/'
    }
}
