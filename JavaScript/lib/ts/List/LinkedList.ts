import BiListNode from "./BiListNode";
export default class LinkedList<T> {
  private head: BiListNode<T>;
  private tail: BiListNode<T>;
  private _length: number;

  constructor(list?: T[]) {
    this._length = 0;
    this.head = new BiListNode<T>(null);
    this.tail = new BiListNode<T>(null);
    this.head.next = this.tail;
    this.tail.next = this.head;
    if (list && list.length !== 0) {
      for (let item of list) {
        this.push(item);
      }
    }
  }

  get length(): number {
    return this._length;
  }

  private insert(val: T, node1: BiListNode<T>, node2: BiListNode<T>): void {
    let newNode:BiListNode<T> = new BiListNode<T>(val, node2, node1);
    node1.next = newNode;
    node2.prev = newNode;
    this._length++;
  }

  private remove(node: BiListNode<T>): T | null {
    let result: T | null = node.val;
    (<BiListNode<T>>node.prev).next = node.next;
    (<BiListNode<T>>node.next).prev = node.prev;
    this._length--;
    return result;
  }

  push(val: T) {
    let node1 = <BiListNode<T>>this.tail.prev;
    let node2 = this.tail;
    this.insert(val, node1, node2);
  }

  pop(): T | null {
    if (this._length >= 0) {
      return this.remove(<BiListNode<T>>this.tail.prev);
    } else {
      return null;
    }
  }

  shift(): T | null {
    if (this._length !== 0) {
      return this.remove(<BiListNode<T>>this.head.next);
    } else {
      return null;
    }
  }

  unshift(val: T): void {
    let node1 = this.head;
    let node2 = <BiListNode<T>>this.head.next;
    this.insert(val, node1, node2);
  }

  toArray(): T[] {
    let result: T[] = [];
    let pointer = <BiListNode<T>>this.head.next;
    while (pointer !== this.tail) {
      result.push(<T>pointer.val);
    }
    return result;
  }

  getFirst(): T | null {
    if (this._length >= 0) {
      return (<BiListNode<T>>this.head.next).val;
    } else {
      return null;
    }
  }

  getLast(): T | null {
    if (this._length >= 0) {
      return (<BiListNode<T>>this.tail.prev).val;
    } else {
      return null;
    }
  }
}
