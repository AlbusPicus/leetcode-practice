/**
 * Runtime: 124 ms, faster than 83.70% of Swift online submissions for Insert Delete GetRandom O(1).
 * Memory Usage: 15.7 MB, less than 65.93% of Swift online submissions for Insert Delete GetRandom O(1).
 */
class RandomizedSet {
    /** Initialize your data structure here. */
    var internalSet = [Int : Entry]()
    var internalList = [Entry]()

    /** Initialize your data structure here. */
    init() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    func insert(_ val: Int) -> Bool {
        if internalSet[val] != nil {
            return false
        } else {
            let entry = Entry(val: val)
            internalSet[val] = entry
            internalList.append(entry)
            return true
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    func remove(_ val: Int) -> Bool {
        let entry = internalSet[val]
        if (entry != nil) {
            internalSet[val] = nil
            entry?.deleted = true
            return true
        } else {
            return false
        }
    }
    
    /** Get a random element from the set. */
    func getRandom() -> Int {
        var listSize = internalList.count
        var index = Int.random(in: 0..<listSize)
        var entry = internalList[index]
        while entry.deleted == true {
            internalList.remove(at: index)
            
            listSize -= 1
            index = Int.random(in: 0..<listSize)
            entry = internalList[index]
        }
        return entry.value
    }
    
    
}

class Entry {
    let value: Int
    var deleted = false
    init(val: Int) {
        value = val
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * let obj = RandomizedSet()
 * let ret_1: Bool = obj.insert(val)
 * let ret_2: Bool = obj.remove(val)
 * let ret_3: Int = obj.getRandom()
 */
