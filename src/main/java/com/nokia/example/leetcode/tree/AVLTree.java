package com.nokia.example.leetcode.tree;

import com.nokia.example.leetcode.entity.TreeNode;

import java.util.Random;

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

    /**
     * 108
     * 将有序数组转换为二叉搜索树
     * <p>
     * 面试题 04.02
     * 最小高度树
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToAVL(int[] nums) {
        return toAVLTraversalLeft(nums, 0, nums.length - 1);
    }

    // 总是选择中间位置左边的数字作为根节点
    public TreeNode toAVLTraversalLeft(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toAVLTraversalLeft(nums, left, mid - 1);
        root.right = toAVLTraversalLeft(nums, mid + 1, right);
        return root;
    }

    // 总是选择中间位置右边的数字作为根节点
    public TreeNode toAVLTraversalRight(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toAVLTraversalRight(nums, left, mid - 1);
        root.right = toAVLTraversalRight(nums, mid + 1, right);
        return root;
    }

    // 选择任意一个中间位置数字作为根节点
    public TreeNode toAVLTraversalRandom(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + new Random().nextInt(2)) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toAVLTraversalRandom(nums, left, mid - 1);
        root.right = toAVLTraversalRandom(nums, mid + 1, right);
        return root;
    }
}
