//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
// Related Topics 树 
// 👍 806 👎 0

package editor.cn;

import editor.libs.TreeNode;
import editor.libs.TreeNodeGeneric;

//Java：二叉树的最近公共祖先
public class Q236LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new Q236LowestCommonAncestorOfABinaryTree().new Solution();
        TreeNode input = new TreeNodeGeneric<>(
                new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4})
                .toTreeNode();
        TreeNode p = input.searchOne(5);
        TreeNode q = input.searchOne(4);
        TreeNode s = solution.lowestCommonAncestor(input, p, q);
        System.out.println(s);
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            return search(root, p, q).root;
        }

        class Result {
            int status;
            TreeNode root;

            Result(int status) {
                this.status = status;
            }

            Result(int status, TreeNode root) {
                this.status = status;
                this.root = root;
            }
        }

        public Result search(TreeNode node, TreeNode p, TreeNode q) {
            if (node == null) {
                return new Result(0);
            }
            Result left = search(node.left, p, q);
            Result right = search(node.right, p, q);
            if (left.status == 3) {
                return left;
            } else if (right.status == 3) {
                return right;
            } else if ((left.status == 1 && right.status == 2) || left.status == 2 && right.status == 1) {
                return new Result(3, node);
            } else if (left.status == 1 || right.status == 1) {
                if (node == q) {
                    return new Result(3, node);
                } else {
                    return new Result(1);
                }
            } else if (left.status == 2 || right.status == 2) {
                if (node == p) {
                    return new Result(3, node);
                } else {
                    return new Result(2);
                }
            } else {
                if (node == p) {
                    return new Result(1);
                } else if (node == q) {
                    return new Result(2);
                }
            }
            return new Result(0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}