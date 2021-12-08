//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须原地修改，只允许使用额外常数空间。 
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。 
//1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics 数组 
// 👍 717 👎 0

package editor.cn;

import java.util.Arrays;

//Java：下一个排列
public class Q31NextPermutation {
    public static void main(String[] args) {
        Solution solution = new Q31NextPermutation().new Solution();
        // test
        int[] input = {5,1,1};
        solution.nextPermutation(input);
        System.out.println(Arrays.toString(input));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            if (nums.length == 2) {
                int temp = nums[0];
                nums[0] = nums[1];
                nums[1] = temp;
            } else if (nums.length > 2) {
                int i = nums.length - 2;
                while (i >= 0 && nums[i] >= nums[i + 1]) {
                    i--;
                }
                if (i < 0) {
                    Arrays.sort(nums);
                    return;
                }
                Arrays.sort(nums, i + 1, nums.length);
                int j = i + 1;
                while (nums[i] >= nums[j]) {
                    j++;
                }
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}