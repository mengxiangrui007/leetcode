//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学

package leetcode.editor.cn;

import java.util.Objects;

/**
 * [2,4,3]
 * [5,4]
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);

        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(4);
        ListNode listNode = solution.addTwoNumbers(listNode1, listNode2);
    }


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode listNode = new ListNode(0);
            ListNode p = l1;
            ListNode q = l2;
            ListNode current = listNode;
            int pVal = 0;
            int qVal = 0;
            int carry = 0;
            while (p != null || q != null) {
                pVal = Objects.nonNull(p) ? p.val : 0;
                qVal = Objects.nonNull(q) ? q.val : 0;
                int sum = pVal + qVal + carry;
                carry = sum / 10;
                //递归编列
                current.next = new ListNode(sum % 10);
                current = current.next;
                if (p != null) {
                    p = p.next;
                }
                if (q != null) {
                    q = q.next;
                }
            }
            //为了解决最后一个进位问题
            if (carry > 0) {
                current.next = new ListNode(carry);
            }
            return listNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}