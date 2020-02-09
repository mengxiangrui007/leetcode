//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        ListNode listNode1 = new ListNode(1);
//        listNode1.next = new ListNode(2);
//        listNode1.next.next = new ListNode(3);
//        listNode1.next.next.next = new ListNode(4);
//        listNode1.next.next.next.next = new ListNode(5);
        ListNode listNode = solution.removeNthFromEnd(listNode1, 1);

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
        private List<Integer> list = new ArrayList<>();

        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (n <= 0) return head;
            func(head, 0);
            int len = list.size();
            if (n > len || len == 1) {
                return null;
            }
            list.remove(len - n);
            ListNode listNode = new ListNode(list.get(0));
            fucntion(listNode, list, 1);
            return listNode;
        }


        void fucntion(ListNode listNode, List<Integer> list, int i) {
            if (list.size() == i) {
                return;
            }
            listNode.next = new ListNode(list.get(i));
            fucntion(listNode.next, list, ++i);
        }


        void func(ListNode listNode, int i) {
            if (i == 0) {
                list.add(listNode.val);
            }
            ListNode node = listNode.next;
            if (node != null) {
                list.add(node.val);
                func(node, ++i);
            } else {
                return;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
