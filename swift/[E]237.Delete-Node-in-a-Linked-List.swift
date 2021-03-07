/**
 * Runtime: 20 ms, faster than 88.61% of Swift online submissions for Delete Node in a Linked List.
 * Memory Usage: 14 MB, less than 63.37% of Swift online submissions for Delete Node in a Linked List.
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
    func deleteNode(_ node: ListNode?) {
        guard let node = node, let next = node.next else { return }
        node.val = next.val
        node.next = next.next
    }
}
