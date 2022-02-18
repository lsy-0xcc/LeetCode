/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {number[]}
 */
 var reversePrint = function (head) {
  let result = [];
  let pointer = head;
  while (pointer) {
    result.push(pointer.val);
    pointer = pointer.next;
  }
  return result.reverse();
};