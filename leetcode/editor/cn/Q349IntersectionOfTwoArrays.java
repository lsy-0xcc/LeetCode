//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 250 👎 0

package editor.cn;

import java.util.*;
import java.util.stream.Collectors;

//Java：两个数组的交集
public class Q349IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new Q349IntersectionOfTwoArrays().new Solution();
        // test
        int[] result = solution.intersection(new int[]{4, 5, 9}, new int[]{9, 4, 9, 8, 4});
        System.out.println(Arrays.toString(result));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int e : nums1) {
            set1.add(e);
        }
        for (int e : nums2) {
            set2.add(e);
        }
        set1.retainAll(set2);
        int[] result = new int[set1.size()];
        int i = 0;
        for (int e : set1) {
            result[i] = e;
            i++;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}