package com.iclazz.something.leetcode.easy;

import com.iclazz.something.common.ListNode;

/**
 * remove linked list elements
 * <p>
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 * Example 2:
 * <p>
 * Input: head = [], val = 1
 * Output: []
 * Example 3:
 * <p>
 * Input: head = [7,7,7,7], val = 7
 * Output: []
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [0, 104].
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 * Related Topics
 * 递归
 * 链表
 * <p>
 * 👍 1008
 * 👎 0
 *
 * @author yiqunz
 * @date 2022-08-29 10:44
 **/
public class Test203 {
    /**
     * 循环方法
     * not recommend
     *
     * @param head ListNode
     * @param val  int
     * @return ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        if (null == head) {
            return null;
        }
        ListNode listNode = head;
        while (null != head) {
            while (null != head.next && head.next.val == val) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        return listNode.val == val ? listNode.next : listNode;
    }

    /**
     * 迭代方法
     * recommend
     *
     * @param head ListNode
     * @param val  int
     * @return ListNode
     */
    public ListNode removeElements2(ListNode head, int val) {
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        ListNode temp = listNode;
        while (null != temp.next) {
            if (val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return listNode.next;
    }


    /**
     * 递归方法
     * not recommend
     *
     * @param head ListNode
     * @param val  int
     * @return ListNode
     */
    public ListNode removeElements3(ListNode head, int val) {
        if (null == head) {
            return null;
        }
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(8, l1);
        ListNode l3 = new ListNode(8, l2);
        ListNode l4 = new ListNode(7, l3);
        ListNode listNode3 = new Test203().removeElements3(null, 8);
        ListNode listNode2 = new Test203().removeElements2(l4, 8);
        ListNode listNode = new Test203().removeElements(l4, 8);
        listNode = new Test203().removeElements(l4, 1);
        listNode = new Test203().removeElements(l2, 8);
        listNode = new Test203().removeElements(l3, 9);
        listNode = new Test203().removeElements(l4, 8);
        System.out.println();
    }
}
