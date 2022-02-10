export default class TreeNode {
    constructor(val, left, right) {
        this.val = val !== null && val !== void 0 ? val : 0;
        this.left = left !== null && left !== void 0 ? left : null;
        this.right = right !== null && right !== void 0 ? right : null;
    }
}
