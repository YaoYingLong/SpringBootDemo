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
}
