package com.nokia.example.leetcode.tree;

import com.nokia.example.leetcode.entity.TreeNode;

/**
 * @author by YingLong on 2020/7/30
 */
public class SearchTree {
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
}
