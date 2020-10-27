//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 405 👎 0

package editor.cn;

import editor.libs.TreeNode;

import java.util.*;

//Java：二叉树的前序遍历
public class Q144BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new Q144BinaryTreePreorderTraversal().new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        root.left = null;
        t2.left = t3;
        root.right = t2;
        System.out.println(solution.preorderTraversal(root));
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            Stack<TreeNode> queue = new Stack<>();
            List<Integer> result = new ArrayList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode out = queue.pop();
                result.add(out.val);
                if (out.right != null) {
                    queue.push(out.right);
                }
                if (out.left != null) {
                    queue.push(out.left);
                }

            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}