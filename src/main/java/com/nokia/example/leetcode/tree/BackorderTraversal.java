package com.nokia.example.leetcode.tree;

import com.nokia.example.leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author by YingLong on 2020/7/31
 */
public class BackorderTraversal {
    /**
     * 671
     * 二叉树中第二小的节点
     *
     * @param root
     * @return
     */
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return -1;
        }

        int left = root.left.val;
        int right = root.right.val;

        if (left == root.val) {
            left = findSecondMinimumValue(root.left);
        }

        if (right == root.val) {
            right = findSecondMinimumValue(root.right);
        }

        if (left != -1 && right != -1) {
            return Math.min(left, right);
        }
        if (left != -1) {
            return left;
        }
        return right;
    }

    /**
     * 面试题 04.02
     * 最小高度树
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0) {
            return right + 1;
        }
        if (right == 0) {
            return left + 1;
        }
        return Math.min(left, right) + 1;
    }

    /**
     * 面试题 04.02
     * 最小高度树
     *
     * @param root
     * @return
     */
    public int minDepthBfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int minDepth = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return minDepth + 1;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            minDepth++;
        }
        return minDepth;
    }

    /**
     * 687
     * 最长同值路径
     *
     * @param root
     * @return
     */
    int val = -1;
    int longest = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        longestUnivaluePath(root.left);
        if (val != root.val) {
            val = root.val;
            longest = 0;
        } else {
            longest++;
        }
        longestUnivaluePath(root.right);
        return longest;
    }

    /**
     * 剑指 Offer 68 - II
     * 二叉树的最近公共祖先
     * <p>
     * 剑指 Offer 68 - I
     * 二叉搜索树的最近公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
