//升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。
// 
//
// 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// nums 中的每个值都 独一无二 
// nums 肯定会在某个点上旋转 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 二分查找 
// 👍 1141 👎 0

package editor.cn;

//Java：搜索旋转排序数组
public class Q33SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new Q33SearchInRotatedSortedArray().new Solution();
        int[] input = {3,1};
        System.out.println(solution.search(input, 3));
        // test
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int pos = findPos(nums, 0, nums.length - 1);
            if (pos == -1) {
                return biSearch(nums, 0, nums.length - 1, target);
            }
            if (nums[0] > target) {
                return biSearch(nums, pos + 1, nums.length - 1, target);
            } else {
                return biSearch(nums, 0, pos, target);
            }
        }

        public int biSearch(int[] array, int begin, int end, int target) {
            if (begin < 0 || end < 0 || begin >= array.length || end >= array.length) {
                return -1;
            }
            if (target < array[begin] || array[end] < target) {
                return -1;
            }

            int diff = end - begin;
            if (diff < 0) {
                return -1;
            } else if (diff == 0) {
                if (array[begin] == target) {
                    return begin;
                }
            } else if (diff == 1) {
                if (array[end] == target) {
                    return end;
                } else if (array[begin] == target) {
                    return begin;
                }
            } else {
                int middle = (begin + end) / 2;
                if (target <= array[middle]) {
                    return biSearch(array, begin, middle, target);
                } else {
                    return biSearch(array, middle + 1, end, target);
                }
            }
            return -1;
        }

        // 找到从哪里开始旋转
        public int findPos(int[] array, int begin, int end) {
            int diff = end - begin;
            if (diff <= 0) {
                return -1;
            } else if (diff == 1) {
                if (array[begin] > array[end]) {
                    return begin;
                } else {
                    return -1;
                }
            } else {
                int middle = (begin + end) / 2;
                if (array[begin] > array[middle]) {
                    return findPos(array, begin, middle);
                } else {
                    return findPos(array, middle, end);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}