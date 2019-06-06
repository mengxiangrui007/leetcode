package com.leetcode.algorithms;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author mengxr
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        // Linked 1
        ListNode l1 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        l1.setNext(l11);
        ListNode l111 = new ListNode(3);
        l11.setNext(l111);

        // Linked 2
        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        l2.setNext(l22);
        ListNode l222 = new ListNode(4);
        l22.setNext(l222);

        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return new ListNode(0);
    }

    /**
     * Definition for singly-linked list.
     **/
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}
