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


package leetcode.editor.cn;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        List<String> strings = solution.letterCombinations("235");
        System.out.println(strings);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<String, String> digitsMap = new HashMap<String, String>() {
            {
                put("2", "abc");
                put("3", "def");
                put("4", "ghi");
                put("5", "jkl");
                put("6", "mno");
                put("7", "pqrs");
                put("8", "tuv");
                put("9", "wxyz");
            }
        };
        StringBuilder tmp = new StringBuilder();
        List<String> res = new ArrayList<String>();

        public List<String> letterCombinations(String digits) {
            if (digits.length() == 0) return Collections.EMPTY_LIST;
            func(digits, 0);
            return res;
        }

        private void func(String digits, int index) {
            if (index >= digits.length()) {
                res.add(tmp.toString());
                return;
            }
            String letter = digitsMap.get(digits.substring(index, index + 1));
            for (int i = 0; i < letter.length(); i++) {
                tmp.append(letter, i, i + 1);
                func(digits, index + 1);
                //去掉添加的字母，开始回溯
                tmp.replace(tmp.length() - 1, tmp.length(), "");
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}