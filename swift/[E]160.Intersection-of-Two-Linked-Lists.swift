/**
 * Runtime: 288 ms, faster than 41.85% of Swift online submissions for Intersection of Two Linked Lists.
 * Memory Usage: 17 MB, less than 77.17% of Swift online submissions for Intersection of Two Linked Lists.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public var val: Int
 *     public var next: ListNode?
 *     public init(_ val: Int) {
 *         self.val = val
 *         self.next = nil
 *     }
 * }
 */

class Solution {
    func getIntersectionNode(_ headA: ListNode?, _ headB: ListNode?) -> ListNode? {
        var firstPointer = headA
        var secondPointer = headB
        var firstChanged = false
        var secondChanged = false
        while firstPointer != nil && secondPointer != nil && firstPointer !== secondPointer {
            if firstPointer!.next == nil && !firstChanged {
                firstChanged = true
                firstPointer = headB
            } else {
                firstPointer = firstPointer!.next
            }
            if secondPointer!.next == nil && !secondChanged {
                secondChanged = true
                secondPointer = headA
            } else {
                secondPointer = secondPointer!.next
            }
        }
        if firstPointer === secondPointer {
            return firstPointer
        } else {
            return nil
        }
    }
}
