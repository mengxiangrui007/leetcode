//给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
//
// 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法

package leetcode.editor.cn;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        double medianSortedArrays = solution.findMedianSortedArrays(nums1, nums2);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int left = nums1.length;
            int right = nums2.length;
            //保证左面的长度大于右面 交换位置
            if (left > right) {
                int[] tmp;
                tmp = nums1;
                nums1 = nums2;
                nums2 = tmp;

                int temp = left;
                left = right;
                right = temp;
            }
            int start = 0;
            int end = left;
            // i + j = (left + right + 1) / 2
            int mid = (left + right + 1) / 2;
            while (start <= end) {
                int i = (start + end) / 2;
                int j = mid - i;
                if (i < end && nums2[j - 1] > nums1[i]) {
                    //i偏小了，需要右移
                    start = i + 1;
                } else if (i > start && nums1[i - 1] > nums2[j]) {
                    //i偏大了，需要左移
                    end = i - 1;
                } else {
                    int maxLeft = 0;
                    //i = 0 说明左半部分的值都大于右半部分的值
                    if (i == 0) {
                        maxLeft = nums2[j - 1];
                    } else if (j == 0) {
                        //j=0 说明右半部分的值大于左半部分的值
                        maxLeft = nums1[i - 1];
                    } else {
                        maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                    }
                    if ((left + right) % 2 == 1) {
                        //说明为奇数
                        return maxLeft;
                    }

                    int minRight = 0;
                    if (i == left) {
                        minRight = nums2[j];
                    } else if (j == right) {
                        minRight = nums1[i];
                    } else {
                        minRight = Math.min(nums1[i], nums2[j]);
                    }

                    //如果数组为偶数，最大值为左半部分与右半部分的平均值
                    return (maxLeft + minRight) / 2.0;
                }
            }
            return 0.0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}