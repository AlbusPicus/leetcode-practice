class Solution {
    
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        val results = mutableListOf<List<Int>>()
        findNumbersCoubination(results, mutableListOf<Int>(), k, n, 1)
        return results
    }
    
    fun findNumbersCoubination(results: MutableList<List<Int>>, list: MutableList<Int>, k: Int, n: Int, startNumber: Int) {  
        if (list.size == k && n == 0) {
            results.add(ArrayList(list))
        }

        for (i in startNumber .. 9) {
            if (list.size > k || list.contains(i)) {
                continue
            }

            list.add(i)
            findNumbersCoubination(results, list, k, n - i, i + 1)
            list.removeAt(list.size - 1)
        }
    
    }
    
}
