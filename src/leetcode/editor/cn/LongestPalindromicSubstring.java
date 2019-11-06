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
        System.out.println(solution.longestPalindrome("babad"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s.length() == 0) {
                return "";
            }
            String reverse = new StringBuilder(s).reverse().toString();
            int len = s.length();
            int[][] arr = new int[len][len];
            int maxlen = 0;
            int maxEndIndex = 0;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if ((s.charAt(i) == reverse.charAt(j))) {
                        if (i == 0 || j == 0) {
                            arr[i][j] = 1;
                        } else {
                            arr[i][j] = arr[i - 1][j - 1] + 1;
                        }
                    }
                    if (arr[i][j] > maxlen) {
                        int beforeRev = len - 1 - j;
                        if (beforeRev + arr[i][j] - 1 == i) {
                            maxlen = arr[i][j];
                            maxEndIndex = i;
                        }
                    }
                }
            }
            return s.substring(maxEndIndex - maxlen + 1, maxEndIndex + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}