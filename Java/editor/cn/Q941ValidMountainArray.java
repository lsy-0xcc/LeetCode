//给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。 
//
// 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组： 
//
// 
// A.length >= 3 
// 在 0 < i < A.length - 1 条件下，存在 i 使得：
// 
// A[0] < A[1] < ... A[i-1] < A[i] 
// A[i] > A[i+1] > ... > A[A.length - 1] 
// 
// 
// 
//
// 
//
// 
//
// 
//
// 示例 1： 
//
// 输入：[2,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：[3,5,5]
//输出：false
// 
//
// 示例 3： 
//
// 输入：[0,3,2,1]
//输出：true 
//
// 
//
// 提示： 
//
// 
// 0 <= A.length <= 10000 
// 0 <= A[i] <= 10000 
// 
//
// 
//
// 
// Related Topics 数组 
// 👍 94 👎 0

package editor.cn;

import java.util.Arrays;

//Java：有效的山脉数组
public class Q941ValidMountainArray {
    public static void main(String[] args) {
        Solution solution = new Q941ValidMountainArray().new Solution();
        // test
        System.out.println(solution.validMountainArray(new int[]{9,8,7,6}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validMountainArray(int[] A) {
            if (A.length == 0 || A.length == 1 || A.length == 2) {
                return false;
            }
            boolean flag = true;
            if (A[0] > A[1]) {
                return false;
            }
            for (int i = 0; i < A.length - 1; i++) {
                if (A[i] == A[i + 1]) {
                    return false;
                }
                if (!flag && A[i] < A[i + 1]) {
                    return false;
                }
                if (flag && A[i] > A[i + 1]) {
                    flag = false;
                }
            }
            return A[A.length - 1] <= A[A.length - 2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}