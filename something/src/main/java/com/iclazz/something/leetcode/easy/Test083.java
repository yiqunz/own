package com.iclazz.something.leetcode.easy;

import com.iclazz.something.common.ListNode;

/**
 * remove duplicates from sorted list
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 *
 * Example 1:
 *
 *
 * Input: head = [1,1,2]
 * Output: [1,2]
 * Example 2:
 *
 *
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 * Related Topics
 * 链表
 *
 * 👍 840
 * 👎 0
 *
 * @author yiqunz
 * @date 2022-08-23 09:50
 **/
public class Test083 {
    /**
     * 指针移动
     * @param head ListNode
     * @return ListNode
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (null != head) {
            while (null != head.next && head.val == head.next.val) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        return temp;
    }

    /**
     * 指针移动
     * 官方题解
     * @param head ListNode
     * @return ListNode
     */
    public ListNode deleteDuplicates3(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }


    /**
     * 指针移动
     * 占用内存空间大
     * @param head ListNode
     * @return ListNode
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (null == head) {
            return head;
        }
        ListNode temp = new ListNode();
        temp.next = head;
        while (null != head.next) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return temp.next;
    }
}
