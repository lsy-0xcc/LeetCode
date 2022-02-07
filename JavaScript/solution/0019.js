/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
 const removeNthFromEnd = function (head, n) {
  let fast = head;
  let slow = head;
  for (let i = 0; i < n; i++) {
    if (fast.next === null) {
      if (i === n - 1) {
        return head.next;
      } else {
        return head;
      }
    } else {
      fast = fast.next;
    }
  }
  while (fast.next) {
    fast = fast.next;
    slow = slow.next;
  }
  slow.next = slow.next.next;
  return head;
};