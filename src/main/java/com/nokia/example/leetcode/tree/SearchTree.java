package com.nokia.example.leetcode.tree;

import com.nokia.example.leetcode.entity.TreeNode;

/**
 * @author by YingLong on 2020/7/30
 */
public class SearchTree {
    /**
     * 面试题 17.12
     * BiNode
     */
    TreeNode cursor;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cursor = ans;
        inorder(root);
        return ans.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        node.left = null;
        cursor.right = node;
        cursor = node;
        inorder(node.right);
    }


    /**
     * 538
     * 把二叉搜索树转换为累加树
     * <p/>
     * 使用反序中序遍历
     */
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }

    /**
     * 687
     * 最长同值路径
     *
     * @param root
     * @return
     */
    public int longest = 0;
    public int longestUnivaluePath(TreeNode root) {
        traversal(root);
        return longest;
    }

    public int traversal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = traversal(root.left);
        int right = traversal(root.right);
        int arrowLeft = 0, arrowRight = 0;
        if (root.left != null && root.left.val == root.val) {
            arrowLeft += left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            arrowRight += right + 1;
        }
        longest = Math.max(longest, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
}
