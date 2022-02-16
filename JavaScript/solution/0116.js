function arrayToList(array) {
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
class BiListNode {
  constructor(val, next, prev) {
    this.val = val;
    this.next = next !== null && next !== void 0 ? next : null;
    this.prev = prev !== null && prev !== void 0 ? prev : null;
  }
}
class LinkedList {
  constructor(list) {
    this._length = 0;
    this.head = new BiListNode(null);
    this.tail = new BiListNode(null);
    this.head.next = this.tail;
    this.tail.prev = this.head;
    if (list && list.length !== 0) {
      for (let item of list) {
        this.push(item);
      }
    }
  }
  get length() {
    return this._length;
  }
  insert(val, node1, node2) {
    let newNode = new BiListNode(val, node2, node1);
    node1.next = newNode;
    node2.prev = newNode;
    this._length++;
  }
  remove(node) {
    let result = node.val;
    node.prev.next = node.next;
    node.next.prev = node.prev;
    this._length--;
    return result;
  }
  push(val) {
    let node1 = this.tail.prev;
    let node2 = this.tail;
    this.insert(val, node1, node2);
  }
  pop() {
    if (this._length >= 0) {
      return this.remove(this.tail.prev);
    } else {
      return null;
    }
  }
  shift() {
    if (this._length !== 0) {
      return this.remove(this.head.next);
    } else {
      return null;
    }
  }
  unshift(val) {
    let node1 = this.head;
    let node2 = this.head.next;
    this.insert(val, node1, node2);
  }
  toArray() {
    let result = [];
    let pointer = this.head.next;
    while (pointer !== this.tail) {
      result.push(pointer.val);
      pointer = pointer.next;
    }
    return result;
  }
  get isEmpty() {
    return this._length === 0;
  }
  get first() {
    if (this._length >= 0) {
      return this.head.next.val;
    } else {
      return null;
    }
  }
  get last() {
    if (this._length >= 0) {
      return this.tail.prev.val;
    } else {
      return null;
    }
  }

  [Symbol.toPrimitive](hint) {
    if (hint === "string") {
      return JSON.stringify({
        head: this.head.next.val,
        tail: this.tail.prev.val,
        length: this._length,
      });
    } else {
      return this._length;
    }
  }
}

/**
 * // Definition for a Node.
 * function Node(val, left, right, next) {
 *    this.val = val === undefined ? null : val;
 *    this.left = left === undefined ? null : left;
 *    this.right = right === undefined ? null : right;
 *    this.next = next === undefined ? null : next;
 * };
 */

/**
 * @param {Node} root
 * @return {Node}
 */
var connect = function (root) {
  if (!root) {
    return root;
  }
  let father = new LinkedList();
  let son = new LinkedList();
  father.push(root);
  while (!father.isEmpty) {
    while (!father.isEmpty) {
      let node = father.shift();
      node.next = father.first;
      if (node.left) {
        son.push(node.left);
      }
      if (node.right) {
        son.push(node.right);
      }
    }
    father = son;
    son = new LinkedList();
  }
  return root;
};
