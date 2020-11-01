//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。 
//
// 返回被除数 dividend 除以除数 divisor 得到的商。 
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2 
//
// 
//
// 示例 1: 
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3 
//
// 示例 2: 
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2 
//
// 
//
// 提示： 
//
// 
// 被除数和除数均为 32 位有符号整数。 
// 除数不为 0。 
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。 
// 
// Related Topics 数学 二分查找 
// 👍 450 👎 0

package editor.cn;
//Java：两数相除
public class Q29DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new Q29DivideTwoIntegers().new Solution();
        // test
//        System.out.println(solution.divide(10,3));
//        System.out.println(solution.divide(7,-3));
//        System.out.println(solution.divide(10,2));
//        System.out.println(solution.divide(1,1));
        System.out.println(solution.divide(Integer.MIN_VALUE,-1));
        System.out.println(solution.divide(Integer.MIN_VALUE,1));
        System.out.println(solution.divide(Integer.MIN_VALUE,-2));
        System.out.println(solution.divide(Integer.MIN_VALUE,2));
        System.out.println(solution.divide(Integer.MIN_VALUE, Integer.MIN_VALUE));
        System.out.println(solution.divide(Integer.MAX_VALUE, Integer.MIN_VALUE));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == divisor) {
            return 1;
        }
        if (divisor == Integer.MIN_VALUE) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE ) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            } else if (divisor >= 1) {
                return divide(dividend + divisor, divisor) - 1;
            } else {
                return divide(dividend - divisor, divisor) + 1;
            }
        }
        if (divisor == -1) {
            return -dividend;
        } else if(divisor == 1){
            return dividend;
        }
        boolean isNegative = false;
        if (dividend < 0) {
            isNegative = true;
            dividend = -dividend;
        }
        if (divisor < 0) {
            isNegative = !isNegative;
            divisor = -divisor;
        }
        int result = 0;
        while (dividend >= divisor) {
            dividend -= divisor;
            result++;
        }
        return isNegative ? -result : result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}