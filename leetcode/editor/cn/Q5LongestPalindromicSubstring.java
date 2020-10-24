//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2753 👎 0

package editor.cn;

//Java：最长回文子串
public class Q5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new Q5LongestPalindromicSubstring().new Solution();
        // test
        System.out.println(solution.longestPalindrome("cbbd"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int size = s.length();
            boolean[][] b = new boolean[size][size];
            for (int i = 0; i < s.length(); i++) {
                b[i][i] = true;
            }
            for (int i = 0; i < s.length() - 1; i++) {
                b[i][i + 1] = s.charAt(i) == s.charAt(i+1);
            }
            for (int i = 2; i < s.length(); i++) {
                for (int j = 0; j < s.length() - i; j++) {
                    b[j][j + i] = b[j + 1][j + i - 1] && s.charAt(j) == s.charAt(j + i);
                }
            }
            int maxLen = 0;
            int begin = 0;
            int end = 0;
            for (int i = 0; i < s.length(); i++) {
                for (int j = i; j < s.length(); j++) {
                    if (b[i][j]) {
                        if (j - i + 1 > maxLen) {
                            maxLen = j - i + 1;
                            begin = i;
                            end = j;
                        }
                    }
                }
            }
            return s.substring(begin, end+1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}