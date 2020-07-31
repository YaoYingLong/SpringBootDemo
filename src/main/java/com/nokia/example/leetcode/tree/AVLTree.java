package com.nokia.example.leetcode.tree;

import com.nokia.example.leetcode.entity.TreeNode;

/**
 * 平衡二叉树相关
 *
 * @author by YingLong on 2020/7/31
 */
public class AVLTree {
    /**
     * 判断是否是平衡二叉树
     *
     * @param treeNode
     * @return
     */
    public boolean isBalanced(TreeNode treeNode) {
        return recur(treeNode) != -1;
    }

    public int recur(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int leftDepth = recur(treeNode.left);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = recur(treeNode.right);
        if (rightDepth == -1) {
            return -1;
        }
        return Math.abs(leftDepth - rightDepth) < 2 ? Math.max(leftDepth, rightDepth) + 1 : -1;
    }
}
