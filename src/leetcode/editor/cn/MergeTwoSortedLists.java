//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表


package leetcode.editor.cn;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(3);
        listNode1.next.next.next = new ListNode(4);
        listNode1.next.next.next.next = new ListNode(5);


        ListNode listNode2 = new ListNode(2);
        listNode2.next = new ListNode(2);
        listNode2.next.next = new ListNode(4);
        listNode2.next.next.next = new ListNode(4);
        listNode2.next.next.next.next = new ListNode(5);

        ListNode listNode = solution.mergeTwoLists(listNode1, listNode2);
        System.out.println(listNode);
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            //边界条件判断
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            ListNode listNode = new ListNode(0);
            ListNode cur = listNode;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    cur.next = l1;
                    cur = cur.next;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    cur = cur.next;
                    l2 = l2.next;
                }
            }
            if (l1 == null) {
                cur.next = l2;
            } else {
                cur.next = l1;
            }
            return listNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}