/**
 * Runtime: 248 ms, faster than 98.11% of Kotlin online submissions for Insert Delete GetRandom O(1).
 * Memory Usage: 42 MB, less than 92.45% of Kotlin online submissions for Insert Delete GetRandom O(1).
 */
class RandomizedSet() {

    /** Initialize your data structure here. */
    val internalSet = mutableMapOf<Int, Entry>()
    val internalList = mutableListOf<Entry>()
    val random = Random()

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    fun insert(`val`: Int): Boolean {
        return if (`val` in internalSet) {
            false
        } else {
            val entry = Entry(`val`)
            internalSet[`val`] = entry
            internalList.add(entry)
            true
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    fun remove(`val`: Int): Boolean {
        val entry = internalSet[`val`]
        return if (entry != null) {
            internalSet.remove(`val`)
            entry.deleted = true
            true
        } else {
            false
        }
    }

    /** Get a random element from the set. */
    fun getRandom(): Int {
        var index = random.nextInt(internalList.size)
        var entry = internalList.get(index)
        while (entry.deleted == true) {
            internalList.removeAt(index)
            
            index = random.nextInt(internalList.size)
            entry = internalList.get(index)
        }
        return entry.value
    }
    
    data class Entry(val value: Int) {
        var deleted = false
    }

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = RandomizedSet()
 * var param_1 = obj.insert(`val`)
 * var param_2 = obj.remove(`val`)
 * var param_3 = obj.getRandom()
 */
