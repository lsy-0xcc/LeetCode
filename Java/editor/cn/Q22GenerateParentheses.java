//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1390 👎 0

package editor.cn;

import java.util.*;

//Java：括号生成
public class Q22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new Q22GenerateParentheses().new Solution();
        // test
        System.out.println(solution.generateParenthesis(4));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            // 动态规划
            // fn = (fn) union fn-k+fk
            List<Set<String>> map = new ArrayList<>();
            map.add(new HashSet<>());
            map.get(0).add("");
            for (int t = 1; t <= n; t++) {
                Set<String> newSet = new HashSet<>();
                for (int i = 1; i < t; i++) {
                    int j = t - i;
                    for (String is : map.get(i)) {
                        for (String js : map.get(j)) {
                            newSet.add(is + js);
                        }
                    }
                }
                for (String s : map.get(t - 1)) {
                    newSet.add("(" + s + ")");
                }
                map.add(newSet);
            }
            List<String> result = new ArrayList<>(map.get(n));
            Collections.sort(result);
            return result;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}