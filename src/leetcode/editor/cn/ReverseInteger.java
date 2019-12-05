//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学

package leetcode.editor.cn;

public class ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
        int reverse = solution.reverse(-1234214);
        System.out.println(Integer.MAX_VALUE);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            StringBuilder stringBuilder = new StringBuilder();
            if (x < 0) {
                stringBuilder.append("-");
            }
            char[] chars = String.valueOf(x).toCharArray();
            for (int i = chars.length - 1; i >= 0; i--) {
                char ch = chars[i];
                if (ch != '-') {
                    stringBuilder.append(ch);
                }
            }
            long l = Long.parseLong(stringBuilder.toString());
            if (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE) {
                return 0;
            }
            return (int) l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}