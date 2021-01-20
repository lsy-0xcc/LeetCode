//给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。 
//
// 示例 1: 
//
// 
//输入: [1,2,3]
//输出: 6
// 
//
// 示例 2: 
//
// 
//输入: [1,2,3,4]
//输出: 24
// 
//
// 注意: 
//
// 
// 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。 
// 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。 
// 
// Related Topics 数组 数学 
// 👍 222 👎 0

package editor.cn;

import java.util.Arrays;

//Java：三个数的最大乘积
public class Q628MaximumProductOfThreeNumbers {
    public static void main(String[] args) {
        Solution solution = new Q628MaximumProductOfThreeNumbers().new Solution();
        // test
        int[] input = {1, 2, 3,-10,-20};
        System.out.println(solution.maximumProduct(input));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumProduct(int[] nums) {
            Arrays.sort(nums);
            int len = nums.length;
//            if (len < 3) {
//                return 0;
//            }
            int product1 = nums[len - 1] * nums[len - 2] * nums[len - 3];
            int product2 = nums[0] * nums[1] * nums[len - 1];
            return Math.max(product1, product2);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}