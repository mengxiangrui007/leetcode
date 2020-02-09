//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
        int[] nums = new int[]{-3, -2, -1, 0, 0, 1, 2, 3};
        List<List<Integer>> lists = solution.fourSum(nums, 0);
        System.out.println(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            if (nums.length < 4) return Collections.emptyList();
            //首先排序
            Arrays.sort(nums);
            List<List<Integer>> resultList = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int start = j + 1;
                    int end = nums.length - 1;
                    int sub = target - nums[i] - nums[j];
                    while (start < end) {
                        if (nums[start] + nums[end] < sub) {
                            start++;
                        } else if (nums[start] + nums[end] > sub) {
                            end--;
                        } else {
                            resultList.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                            if ((nums[start] == nums[start + 1]) && nums[end] == nums[end - 1]) {
                                start += 2;
                                end -= 2;
                            } else {
                                start++;
                                end--;
                            }

                        }
                    }
                }
            }
            return resultList.stream().distinct().collect(Collectors.toList());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}