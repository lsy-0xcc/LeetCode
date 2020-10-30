//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1348 👎 0

package editor.cn;

import editor.libs.ListNode;

//Java：合并两个有序链表
public class Q21MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new Q21MergeTwoSortedLists().new Solution();
        ListNode input1 = new ListNode(new int[]{1, 2, 4});
        ListNode input2 = new ListNode(new int[]{1, 3, 4});
        System.out.println(solution.mergeTwoLists(input1, input2));
        // test
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            } else if (l2 == null) {
                return l1;
            } else {
                ListNode root = new ListNode();
                ListNode i = l1;
                ListNode j = l2;
                ListNode k = root;
                ListNode last = null;
                int small;
                while (i != null || j != null) {
                    if (j == null || i != null && i.val < j.val) {
                        small = i.val;
                        i = i.next;
                    } else {
                        small = j.val;
                        j = j.next;
                    }
                    k.val = small;
                    k.next = new ListNode();
                    last = k;
                    k = k.next;
                }
                last.next = null;
                return root;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}