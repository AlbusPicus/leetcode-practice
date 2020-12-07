class Solution {
    
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        val memoMap = HashMap<Attempt, MutableList<List<Int>>?>()
        return findNumbersCoubination(Attempt(k, n, 1), memoMap) ?: emptyList()
    }
    
    fun findNumbersCoubination(attempt: Attempt, memoMap: HashMap<Attempt, MutableList<List<Int>>?>): MutableList<List<Int>>? {    
        if (attempt.isNotValid()) {
            memoMap.set(attempt, null)
            return null
        }
        
        if (memoMap.contains(attempt)) {
            return memoMap[attempt]
        }
        
        val result = if (attempt.currentNumber == attempt.sum && attempt.numbersCount == 1) {
            mutableListOf(listOf(attempt.currentNumber))
        } else {
            val withThisNumberDfs: MutableList<List<Int>>?
            val withoutThisNumberDfs: MutableList<List<Int>>?
            if (attempt.currentNumber < 9) {
                val useThisNumberAttempt = Attempt(attempt.numbersCount - 1, attempt.sum - attempt.currentNumber, attempt.currentNumber + 1)
                withThisNumberDfs = findNumbersCoubination(useThisNumberAttempt, memoMap)
                val withoutThisNumberAttempt = Attempt(attempt.numbersCount, attempt.sum, attempt.currentNumber + 1)
                withoutThisNumberDfs = findNumbersCoubination(withoutThisNumberAttempt, memoMap)
            } else {
                withThisNumberDfs = null
                withoutThisNumberDfs = null
            }


            if (withThisNumberDfs != null && withoutThisNumberDfs != null) {
                appendNumberToHead(withThisNumberDfs, attempt.currentNumber).also {
                    it.addAll(withoutThisNumberDfs)
                }
            } else withThisNumberDfs?.let { appendNumberToHead(it, attempt.currentNumber) } ?: withoutThisNumberDfs
        }
        
        
        return result
    }
    
    fun appendNumberToHead(lists: List<List<Int>>, number: Int): MutableList<List<Int>> {
        val result = mutableListOf<List<Int>>()
        lists.forEach { list ->
            result.add(list.toMutableList().also { it.add(0, number) })
        }
        return result
    }
    
    
    data class Attempt(val numbersCount: Int, val sum: Int, val currentNumber: Int) {
        
        fun isNotValid() = numbersCount <= 0 || sum <= 0 ||  currentNumber > 9 
        
    }
}
