//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下： 
//
// L   C   I   R
//E T O E S I I G
//E   D   H   N
// 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// string convert(string s, int numRows); 
//
// 示例 1: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIRETOESIIGEDHN"
// 
//
// 示例 2: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G 
// Related Topics 字符串 
// 👍 859 👎 0

package editor.cn;

//Java：Z 字形变换
public class Q6ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new Q6ZigzagConversion().new Solution();
        // test
        System.out.println(solution.convert("LEETCODEISHIRING", 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 0 || numRows == 1 || s == null || s.length() == 0) {
                return s;
            }
            int rows = 2 * numRows - 2;
            int[] indexHelper = new int[rows];
            indexHelper[0] = 0;
            for (int i = 1; i < numRows - 1; i++) {
                indexHelper[i] = i;
                indexHelper[2 * numRows - i - 2] = i;
            }
            indexHelper[numRows - 1] = numRows - 1;
            StringBuilder[] results = new StringBuilder[rows];
            for (int i = 0; i < rows; i++) {
                results[i] = new StringBuilder();
            }
            int count = 0;
            for (char c : s.toCharArray()) {
                results[indexHelper[count]].append(c);
                count++;
                if (count >= rows) {
                    count-=rows;
                }
            }
            StringBuilder result = new StringBuilder();
            for (StringBuilder e : results) {
                result.append(e);
            }
            return result.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}