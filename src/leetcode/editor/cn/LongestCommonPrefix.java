//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串

package leetcode.editor.cn;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        String[] arrs = new String[]{"f2lower", "3flow", "flight"};
        String s = solution.longestCommonPrefix(arrs);
        System.out.println(s);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            //1.空校验
            if (strs == null || strs.length == 0) return "";
            //2.以第一个为模板进行遍历匹配
            String template = strs[0];
            //3.如果没有匹配对模板进行截取
            int i = 1;
            while (i < strs.length) {
                while (strs[i].indexOf(template) != 0) {
                    template = template.substring(0, template.length() - 1);
                }
                i++;
            }
            return template;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}