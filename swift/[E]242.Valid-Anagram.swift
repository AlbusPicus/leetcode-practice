/**
 * Runtime: 48 ms, faster than 71.68% of Swift online submissions for Valid Anagram.
 * Memory Usage: 14.4 MB, less than 88.05% of Swift online submissions for Valid Anagram.
 */
class Solution {
    func isAnagram(_ s: String, _ t: String) -> Bool {
        if s.length != t.length {
            return false
        }
        
        var symbolsCount: [Character: Int] = [:]
        for char in s {
            symbolsCount[char] = symbolsCount[char, default: 0] + 1
        }
        for char in t {
            let charCount = symbolsCount[char, default: 0]
            if charCount > 0 {
                symbolsCount[char] = charCount - 1
            } else {
                return false
            }
        }
        return true
    }
}
