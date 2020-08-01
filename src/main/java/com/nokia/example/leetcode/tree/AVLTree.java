package com.nokia.example.leetcode.tree;

import com.nokia.example.leetcode.entity.TreeNode;

/**
 * 平衡二叉树相关
 *
 * @author by YingLong on 2020/7/31
 */
public class AVLTree {
    /**
     * 110
     * 平衡二叉树
     * <p>
     * 面试题 04.04
     * 检查平衡性
     * <p>
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1
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
        if (rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
