//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1256 👎 0

package editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：回文数
public class Q9PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new Q9PalindromeNumber().new Solution();
        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(11));
        System.out.println(solution.isPalindrome(1));
        System.out.println(solution.isPalindrome(12342));
        // test
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            } else if (x == 0) {
                return true;
            }
            List<Integer> digits = new ArrayList<>();
            int rest = x;
            while (rest != 0) {
                digits.add(rest % 10);
                rest = rest / 10;
            }
            int len = digits.size();
            for (int i = 0; i < len; i++) {
                if (!digits.get(i).equals(digits.get(len - i - 1))) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}