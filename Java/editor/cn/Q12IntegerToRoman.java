//罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。 
//
// 字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + I
//I 。 
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况： 
//
// 
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 
// 
//
// 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。 
//
// 示例 1: 
//
// 输入: 3
//输出: "III" 
//
// 示例 2: 
//
// 输入: 4
//输出: "IV" 
//
// 示例 3: 
//
// 输入: 9
//输出: "IX" 
//
// 示例 4: 
//
// 输入: 58
//输出: "LVIII"
//解释: L = 50, V = 5, III = 3.
// 
//
// 示例 5: 
//
// 输入: 1994
//输出: "MCMXCIV"
//解释: M = 1000, CM = 900, XC = 90, IV = 4. 
// Related Topics 数学 字符串 
// 👍 435 👎 0

package editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：整数转罗马数字
public class Q12IntegerToRoman {
    public static void main(String[] args) {
        Solution solution = new Q12IntegerToRoman().new Solution();
        System.out.println(solution.intToRoman(1));
        System.out.println(solution.intToRoman(3));
        System.out.println(solution.intToRoman(4));
        System.out.println(solution.intToRoman(9));
        System.out.println(solution.intToRoman(58));
        System.out.println(solution.intToRoman(1994));
        System.out.println(solution.intToRoman(1999));
        // test
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String intToRoman(int num) {
//            if (num < 1 || num > 3999) {
//                return "";
//            }
//            StringBuilder result = new StringBuilder();
//            int rest = num;
//            List<Integer> digits = new ArrayList<>();
//            while (rest > 0) {
//                digits.add(rest % 10);
//                rest = rest / 10;
//            }
//            for (int i = 0; i < digits.size(); i++) {
//                result.insert(0, helper(i + 1, digits.get(i)));
//            }
//            return result.toString();
            String[][]  c = {
                    {"","I","II","III","IV","V","VI","VII","VIII","IX"},
                    {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
                    {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
                    {"","M","MM","MMM"}
            };
            StringBuilder roman = new StringBuilder();
            roman.append(c[3][num / 1000]);
            roman.append(c[2][num / 100 % 10]);
            roman.append(c[1][num / 10 % 10]);
            roman.append(c[0][num % 10]);

            return roman.toString();
        }

//        public String helper(int pos, int num) {
//            String[][] map = {{"", ""}, {"I", "V"}, {"X", "L"}, {"C", "D"}, {"M", ""}};
//            String result = "";
//            String[] selected = map[pos];
//            switch (num) {
//                case 0:
//                    result = "";
//                    break;
//                case 1:
//                    result = selected[0];
//                    break;
//                case 2:
//                    result = selected[0] + selected[0];
//                    break;
//                case 3:
//                    result = selected[0] + selected[0] + selected[0];
//                    break;
//                case 4:
//                    result = selected[0] + selected[1];
//                    break;
//                case 5:
//                    result = selected[1];
//                    break;
//                case 6:
//                    result = selected[1] + selected[0];
//                    break;
//                case 7:
//                    result = selected[1] + selected[0] + selected[0];
//                    break;
//                case 8:
//                    result = selected[1] + selected[0] + selected[0] + selected[0];
//                    break;
//                case 9:
//                    result = selected[0] + map[pos+1][0];
//                    break;
//            }
//            return result;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}