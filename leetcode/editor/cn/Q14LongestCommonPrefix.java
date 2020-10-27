//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1325 👎 0

package editor.cn;

//Java：最长公共前缀
public class Q14LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new Q14LongestCommonPrefix().new Solution();
        // test
        String[] input = {"flower","flow","flight"};
        String[] input2 = {"ab","a"};
        System.out.println(solution.longestCommonPrefix(input2));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            } else if (strs.length == 1) {
                return strs[0];
            }
            int shortLen = strs[0].length();
            for (String str : strs) {
                shortLen = Math.min(shortLen, str.length());
            }
            if (shortLen == 0) {
                return "";
            }
            int index = -1;
            for (int i = 0; i < shortLen; i++) {
                boolean same = true;
                char b = strs[0].charAt(i);
                for (String str : strs) {
                    if (b != str.charAt(i)) {
                        same = false;
                        break;
                    }
                }
                if (!same) {
                    break;
                }
                index = i;
            }
            return index == -1 ? "" : strs[0].substring(0, index + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}