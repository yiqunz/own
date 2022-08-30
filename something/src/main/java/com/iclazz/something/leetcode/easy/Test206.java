package com.iclazz.something.leetcode.easy;

import com.iclazz.something.common.ListNode;

/**
 * reverse linked list
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * Example 2:
 *
 *
 * Input: head = [1,2]
 * Output: [2,1]
 * Example 3:
 *
 * Input: head = []
 * Output: []
 * Constraints:
 *
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * Related Topics
 * 递归
 * 链表
 *
 * 👍 2728
 * 👎 0
 *
 * @author yiqunz
 * @date 2022-08-30 15:06
 **/
public class Test206 {

    /**
     * 迭代法
     * @param head reverseList
     * @return reverseList
     */
    public ListNode reverseListIteration(ListNode head) {
        ListNode listNode = null;
        ListNode tem;
        while (null != head) {
            tem = listNode;
            listNode = new ListNode(head.val);
            listNode.next = tem;
            head = head.next;
        }
        return listNode;
    }

    /**
     * 递归法，相对没那么好理解。涉及指针反转
     * @param head reverseList
     * @return reverseList
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        //指针反转
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2, l1);
        ListNode l3 = new ListNode(3, l2);
        ListNode l4 = new ListNode(4, l3);
        ListNode l5 = new ListNode(5, l4);
        ListNode listNode = new Test206().reverseList(l5);
        System.out.println(listNode.val);
    }
}
