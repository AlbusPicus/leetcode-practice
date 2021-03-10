/**
 * Runtime: 0 ms, faster than 100.00% of Swift online submissions for Sum of Two Integers.
 * Memory Usage: 13.9 MB, less than 37.84% of Swift online submissions for Sum of Two Integers.
 */
class Solution {
    func getSum(_ a: Int, _ b: Int) -> Int {
        var additionValue = b
        var result = a
        while additionValue != 0 {
            let carry = result & additionValue
            result = result ^ additionValue
            additionValue = carry << 1 
        }
        return result
    }
}
