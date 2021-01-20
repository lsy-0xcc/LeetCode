//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 814 👎 0

package editor.cn;

import java.util.Arrays;

//Java：在排序数组中查找元素的第一个和最后一个位置
public class Q34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new Q34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // test
        int[] input = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(solution.searchRange(input, 4)));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    public int[] search(int[] nums, int begin, int end,int target) {
        int diff = end - begin;
        if (diff < 0) {
            return new int[]{-1, -1};
        } else if (diff == 0) {
            if (nums[begin] == target) {
                return new int[]{begin, begin};
            } else {
                return new int[]{-1, -1};
            }
        } else {
            int middle = (begin + end) / 2;
            int[] a1 = search(nums, begin, middle, target);
            int[] a2 = search(nums, middle + 1, end, target);
            if (a1[0] == -1 && a2[0] == -1) {
                return new int[]{-1, -1};
            } else if (a1[0] != -1 && a2[0] != -1) {
                return new int[]{a1[0], a2[1]};
            } else if (a1[0] != -1) {
                return a1;
            } else{
                return a2;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}