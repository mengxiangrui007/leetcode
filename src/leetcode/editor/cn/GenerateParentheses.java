//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
//
// 例如，给出 n = 3，生成结果为： 
//
// [
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// 
// Related Topics 字符串 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        List<String> strings = solution.generateParenthesis(3);
        System.out.println(strings);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //https://leetcode-cn.com/problems/generate-parentheses/solution/gua-hao-sheng-cheng-by-leetcode/
        public List<String> generateParenthesis(int n) {
            //回溯法
            List<String> result = new ArrayList<>();
            generateParenthesis(result, "", 0, 0, n);
            return result;
        }

        private void generateParenthesis(List<String> result, String cur, int open, int close, int n) {
            if (cur.length() == n * 2) {
                result.add(cur);
            }
            if (open < n) {
                generateParenthesis(result, cur + "(", open + 1, close, n);
            }
            if (close < open) {
                generateParenthesis(result, cur + ")", open, close + 1, n);

            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}