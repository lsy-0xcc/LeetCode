/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
 const middleNode = function(head) {
  let fast = head;
  let slow = head;
  while (fast && fast.next) {
    slow = slow.next;
    fast = fast.next;
    fast = fast.next;
  }
  return slow;
};