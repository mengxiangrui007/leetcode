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

package leetcode.editor.cn;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("bb"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            char ch;
            int len = s.length();
            for (int i = 0; i < len; i++) {
                ch = s.charAt(i);
                if ((i + 1) < len && ch == s.charAt(i + 1)) {
                    return s.substring(i, i + 2);
                } else if ((i + 2) < len && ch == s.charAt(i + 2)) {
                    return s.substring(i, i + 3);
                } else if (len == 1 || len == 2) {
                    return new String(new char[]{ch});
                }
            }
            return "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}