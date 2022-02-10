export default class TreeNode<T> {
    val: T | 0;
    left: T | null;
    right: T | null;
    constructor(val?: T, left?: T, right?: T);
}
