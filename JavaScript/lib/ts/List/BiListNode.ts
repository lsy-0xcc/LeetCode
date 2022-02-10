export default class BiListNode<T> {
  val: T | null;
  prev: BiListNode<T> | null;
  next: BiListNode<T> | null;
  constructor(val: T | null, next?: BiListNode<T>, prev?: BiListNode<T>) {
    this.val = val;
    this.next = next ?? null;
    this.prev = prev ?? null;
  }
}
