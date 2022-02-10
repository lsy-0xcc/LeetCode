import LinkedList from "./LinkedList.js";
export class TreeNode {
  constructor(val, left, right) {
    this.val = val === undefined ? null : val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
  }

  toArray() {
    let result = [];
    let queue = new LinkedList();
    queue.push(this);
    while (!queue.isEmpty) {
      let node = queue.shift();
      if (node) {
        result.push(node.val);
        queue.push(node.left);
        queue.push(node.right);
      } else {
        result.push(null);
      }
    }
    removeNullInArrayTail(result);
    return result;
  }
}

export function arrayToTree(array) {
  removeNullInArrayTail(array);
  if (array && array.length > 0) {
    let root = new TreeNode(array[0]);
    let queue = new LinkedList();
    queue.push(root);
    let i = 1;
    while (i < array.length) {
      let leftVal = array[i];
      let rightVal = array[i + 1];
      let father = queue.shift();
      if (leftVal !== null && leftVal !== undefined) {
        let left = new TreeNode(leftVal);
        father.left = left;
        queue.push(left);
      }
      if (rightVal !== null && array[i] !== undefined) {
        let right = new TreeNode(rightVal);
        father.right = right;
        queue.push(right);
      }
      i += 2;
    }
    removeEmptyNode(root);
    return root;
  }
}

function removeEmptyNode(root) {
  if (root) {
    if (root.left && root.left.val === null) {
      root.left = null;
    } else {
      removeEmptyNode(root.left);
    }

    if (root.right && root.right.val === null) {
      root.right = null;
    } else {
      removeEmptyNode(root.right);
    }
  }
}

function removeNullInArrayTail(array) {
  let index = array.length - 1;
  for (let i = array.length - 1; i >= 0; i--) {
    if (array[i] === null) {
      index = i;
    } else {
      index = i;
      break;
    }
  }
  array.length = index + 1;
}
