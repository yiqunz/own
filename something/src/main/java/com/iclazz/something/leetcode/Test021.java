package com.iclazz.something.leetcode;

import com.iclazz.something.common.ListNode;

/**
 * merge two sorted lists
 *
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 *  Merge the two lists in a one sorted list. The list should be made by
 * splicing together the nodes of the first two lists.
 *
 *  Return the head of the merged linked list.
 *
 *
 *  Example 1:
 *
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 *
 *  Example 2:
 *
 *
 * Input: list1 = [], list2 = []
 * Output: []
 *
 *
 *  Example 3:
 *
 *
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 *
 *
 *  Constraints:
 *
 *
 *  The number of nodes in both lists is in the range [0, 50].
 *  -100 <= Node.val <= 100
 *  Both list1 and list2 are sorted in non-decreasing order.
 *
 *
 *  Related Topics 递归 链表 👍 2616 👎 0
 * @author yiqunz
 * @date 2022-08-19 09:54
 **/
public class Test021 {

    /**
     * 递归法
     * 时间复杂度O(m+n)
     * 空间复杂度O(m+n)
     * @param list1 ListNode
     * @param list2 ListNode
     * @return ListNode
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode listNode;
        if (null == list2) {
            return list1;
        }
        if (null == list1) {
            return list2;
        }
        if (list1.val <= list2.val) {
            listNode = list1;
            list1 = list1.next;
        } else {
            listNode = list2;
            list2 = list2.next;
        }
        listNode.next = mergeTwoLists(list1, list2);
        return listNode;
    }

    /**
     * 递归法
     * 时间复杂度O(m+n)
     * 空间复杂度O(m+n)
     * @param list1 ListNode
     * @param list2 ListNode
     * @return ListNode
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode res = list1.val < list2.val ? list1 : list2;
        res.next = mergeTwoLists(res.next, list1.val >= list2.val ? list1 : list2);
        return res;
    }

    /**
     * 迭代法
     * leetcode 官方题解
     * 时间复杂度O(m+n)
     * 空间复杂度O(1)
     * @param l1 ListNode
     * @param l2 ListNode
     * @return ListNode
     */
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }



    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        l1.val = 2;
        ListNode l2 = new ListNode();
        l2.val = 1;
        Test021 test021 = new Test021();
        ListNode listNode = test021.mergeTwoLists(l1, l2);
        System.out.println(listNode.val);
        while (null!=listNode.next){
            listNode = listNode.next;
            System.out.println(listNode.val);
        }
    }
}
