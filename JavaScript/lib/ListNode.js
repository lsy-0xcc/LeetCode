export class ListNode {
  constructor(val, next) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
  }

  toArray() {
    let result = [];
    let pointer = this;
    while (pointer) {
      result.push(pointer.val);
      pointer = pointer.next;
    }
    return result;
  }
}

export function arrayToList(array) {
  let len = array.length;
  if (array && len > 0) {
    let result = new ListNode(array[0]);
    let last = result;
    for (let i = 1; i < len; i++) {
      let newNode = new ListNode(array[i]);
      last.next = newNode;
      last = newNode;
    }
    return result;
  }
}
