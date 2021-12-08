//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 661 👎 0

package editor.cn;

import java.util.*;

//Java：四数之和
public class Q18FourSum {
    public static void main(String[] args) {
        Solution solution = new Q18FourSum().new Solution();
        // test
        System.out.println(solution.fourSum(new int[]{1, 0, -1, 0},0));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        Set<List<Integer>> resultSet = new HashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int l = i + 2; l < nums.length; l++) {
                int j = i+1;
                int k = l-1;
                int ilSum = nums[i] + nums[l];
                while (j < k) {
                    int sum = nums[j] + nums[k] + ilSum;
                    if (sum == target) {
                        resultSet.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[l])));
                        j++;
                        k--;
                    } else if(sum < target){
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>(resultSet);
        result.sort((o1, o2) -> {
            for (int i = 0; i < 3; i++) {
                if (!o1.get(i).equals(o2.get(i))) {
                    return o1.get(i) - o2.get(i);
                }
            }
            return 0;
        });
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}