//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4390 👎 0

package editor.cn;

import java.util.HashSet;
import java.util.Set;

//Java：无重复字符的最长子串
public class Q3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new Q3LongestSubstringWithoutRepeatingCharacters().new Solution();
        // test

        System.out.println(solution.lengthOfLongestSubstring("abcacbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbbb"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.equals("")) {
                return 0;
            }
            char[] chars = s.toCharArray();
            Set<Character> set = new HashSet<>();
            int begin = 0;
            int end = 1;
            int mLen = 1;
            set.add(chars[0]);
            while (end < chars.length) {
                if (set.contains(chars[end])) {
                    set.remove(chars[begin]);
                    begin++;
                } else {
                    set.add(chars[end]);
                    mLen = Math.max(mLen, end - begin + 1);
                    end++;
                }
            }
            return mLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}