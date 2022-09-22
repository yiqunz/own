package com.iclazz.something.common;

/**
 * a binary tree
 *
 * @author yiqunz
 * @date 2022-08-23 17:20
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
