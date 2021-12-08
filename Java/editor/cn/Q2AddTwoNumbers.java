//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 4993 👎 0

package editor.cn;

import editor.libs.ListNode;

//Java：两数相加
public class Q2AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new Q2AddTwoNumbers().new Solution();
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode p1 = l1;
            ListNode p2 = l2;
            // 处理l1和l2都有的数位
            while (p1.next != null && p2.next != null) {
                int temp = p1.val + p2.val;
                p1.next.val += temp / 10;
                p1.val = temp % 10;
                p2.val = temp % 10;
                p1 = p1.next;
                p2 = p2.next;
            }

            //l1 l2至少有一个没有数
            ListNode result;
            ListNode p3;
            if (p1.next != null) {
                result = l1;
                p3 = p1;
            } else {
                result = l2;
                p3 = p2;
            }

            p3.val = p1.val + p2.val;

            while (p3.next != null) {
                p3.next.val += p3.val / 10;
                p3.val = p3.val % 10;
                p3 = p3.next;
            }

            // 最后仍然要进位
            if (p3.val >= 10) {
                p3.next = new ListNode(p3.val / 10);
                p3.val = p3.val % 10;
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}