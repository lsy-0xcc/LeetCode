//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1, 2, 1, -4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 
// 👍 612 👎 0

package editor.cn;

import java.util.Arrays;

//Java：最接近的三数之和
public class Q16ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new Q16ThreeSumClosest().new Solution();
        // test
        System.out.println(solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            // 一个指针从0开始遍历
            int minDistance = Integer.MAX_VALUE;
            int best = 0;
            for (int k = 0; k < nums.length - 1; k++) {
                // 两个指针相向而行
                int i = k + 1;
                int j = nums.length - 1;
                while (i < j) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == target) {
                        return sum;
                    }
                    int abs = Math.abs(sum - target);
                    if (abs < minDistance) {
                        minDistance = abs;
                        best = sum;
                    }
                    if (sum > target) {
                        j--;
                    } else {
                        i++;
                    }
                }
            }
            return best;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}