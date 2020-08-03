package com.nokia.example.leetcode.tree;

import com.nokia.example.leetcode.entity.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author by YingLong on 2020/7/31
 */
public class TreeBaseTraversal {
    /**
     * 前序遍历
     */
    public void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    /**
     * 深度优先遍历——前序非递归遍历
     */
    public void preOrderDfs(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tree = stack.pop();
            System.out.println(tree);
            if (tree.right != null) {
                stack.push(tree.right);
            }
            if (tree.left != null) {
                stack.push(tree.left);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.left);
        System.out.println(treeNode);
        inOrder(treeNode.right);
    }

    /**
     * 深度优先遍历——中序非递归遍历
     */
    public void inOrderDfs(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode currentNode = root;
        while (currentNode != null && !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            System.out.print(currentNode);
            currentNode = currentNode.right;
        }
    }

    /**
     * 后序遍历
     */
    public void backOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        backOrder(treeNode.left);
        backOrder(treeNode.right);
        System.out.println(treeNode);
    }

    /**
     * 深度优先遍历——后序非递归遍历
     */
    public void backOrderDfs(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode currentNode = root;
        TreeNode right = null;
        while (currentNode != null && !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            while (currentNode.right == null || currentNode.right == right) {
                System.out.print(currentNode);
                right = currentNode;
                if (stack.isEmpty()) {
                    return;
                }
                currentNode = stack.pop();
            }
            stack.push(currentNode);
            currentNode = currentNode.right;
        }
    }

    /**
     * 层序遍历—广度优先遍历
     */
    public void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tree = queue.poll();
            if (tree.left != null) {
                queue.offer(tree.left);
            }
            if (tree.right != null) {
                queue.offer(tree.right);
            }
            System.out.println(tree);
        }
    }
}
