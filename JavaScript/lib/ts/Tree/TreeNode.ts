export default class TreeNode<T> {
  val: T | 0;
  left: T | null;
  right: T | null;
  constructor(val?: T, left?: T, right?: T) {
    this.val = val ?? 0;
    this.left = left ?? null;
    this.right = right ?? null;
  }
}
