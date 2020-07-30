package com.nokia.example.leetcode.tree;

import com.nokia.example.leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author by YingLong on 2020/7/29
 */
public class MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }

    public TreeNode mirrorTreeV2(TreeNode root) {
        if(root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>() {{ add(root); }};
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.left != null) {
                stack.add(node.left);
            }
            if(node.right != null) {
                stack.add(node.right);
            }
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }

    public TreeNode mirrorTreeV3(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            TreeNode tmp = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = tmp;
        }
        return root;
    }
}
