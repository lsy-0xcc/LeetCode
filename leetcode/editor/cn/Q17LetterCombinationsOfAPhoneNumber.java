//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法 
// 👍 976 👎 0

package editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：电话号码的字母组合
public class Q17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new Q17LetterCombinationsOfAPhoneNumber().new Solution();
        // test
        System.out.println(solution.letterCombinations("23"));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return new ArrayList<>();
        }
        char[][] chars = {{},{},{'a','b','c'}, {'d','e','f'},
                {'g','h','i'}, {'j','k','l'},{'m','n','o'},
                {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        Map<Character, char[]> characterMap = new HashMap<>();
        for (int i = 2; i <= 9; i++) {
            characterMap.put((char)(i+'0'), chars[i]);
        }
        List<String> oldResult = new ArrayList<>();
        List<String> newResult = new ArrayList<>();
        oldResult.add("");
        for (char c : digits.toCharArray()) {
            for (String s : oldResult) {
                for (char newChar : characterMap.get(c)) {
                    newResult.add(s + newChar);
                }
            }
            oldResult = newResult;
            newResult = new ArrayList<>();
        }
        return oldResult;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}