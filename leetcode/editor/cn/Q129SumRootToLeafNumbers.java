//给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。 
//
// 例如，从根到叶子节点路径 1->2->3 代表数字 123。 
//
// 计算从根到叶子节点生成的所有数字之和。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//    1
//   / \
//  2   3
//输出: 25
//解释:
//从根到叶子节点路径 1->2 代表数字 12.
//从根到叶子节点路径 1->3 代表数字 13.
//因此，数字总和 = 12 + 13 = 25. 
//
// 示例 2: 
//
// 输入: [4,9,0,5,1]
//    4
//   / \
//  9   0
// / \
//5   1
//输出: 1026
//解释:
//从根到叶子节点路径 4->9->5 代表数字 495.
//从根到叶子节点路径 4->9->1 代表数字 491.
//从根到叶子节点路径 4->0 代表数字 40.
//因此，数字总和 = 495 + 491 + 40 = 1026. 
// Related Topics 树 深度优先搜索 
// 👍 244 👎 0

package editor.cn;

import editor.libs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.ToIntBiFunction;

//Java：求根到叶子节点数字之和
public class Q129SumRootToLeafNumbers {
    public static void main(String[] args) {
        Solution solution = new Q129SumRootToLeafNumbers().new Solution();
        // test
        TreeNode t4 = new TreeNode(4);
        TreeNode t9 = new TreeNode(9);
        TreeNode t0 = new TreeNode(0);
        TreeNode t5 = new TreeNode(5);
        TreeNode t1 = new TreeNode(1);
        t4.left = t9;
        t4.right = t0;
        t9.left = t5;
        t9.right = t1;
        System.out.println(solution.sumNumbers(t4));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> sums = new LinkedList<>();
        int sum = 0;
        nodes.add(root);
        sums.add(root.val);
        while (!nodes.isEmpty()) {
            TreeNode top = nodes.poll();
            int topSum = sums.poll();
            if (top.left == null && top.right == null) {
                sum += topSum;
            }
            if (top.left != null) {
                nodes.add(top.left);
                sums.add(top.left.val + topSum * 10);
            }
            if (top.right != null) {
                nodes.add(top.right);
                sums.add(top.right.val + topSum * 10);
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}