export default class BiListNode {
  constructor(val, next, prev) {
    this.val = val;
    this.next = next !== null && next !== void 0 ? next : null;
    this.prev = prev !== null && prev !== void 0 ? prev : null;
  }
}