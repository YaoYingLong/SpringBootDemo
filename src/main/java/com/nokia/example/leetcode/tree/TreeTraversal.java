package com.nokia.example.leetcode.tree;

import com.nokia.example.leetcode.entity.TreeNode;

import java.util.*;

/**
 * @author by YingLong on 2020/7/27
 */
public class TreeTraversal {
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

    /**
     * 计算二叉树的深度
     */
    public int maxDepthV1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepthV1(root.left), maxDepthV1(root.right)) + 1;
    }

    /**
     * 计算二叉树的深度
     */
    public int maxDepthV2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int maxDepth = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            maxDepth++;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
        }
        return maxDepth;
    }

    /**
     * 二叉树的直径
     */
    int diameter = 0;

    public int diameter(TreeNode root) {
        depth(root);
        return diameter;
    }

    public int depth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = depth(treeNode.left);
        int right = depth(treeNode.right);
        diameter = Math.max(left + right, diameter);
        return Math.max(left, right) + 1;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                levelList.add(treeNode.val);
            }
            resultList.add(levelList);
        }
        return resultList;
    }


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                levelList.add(treeNode.val);
            }
            resultList.add(0, levelList);
        }
        return resultList;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            return true;
        }
        boolean isPathSum = hasPathSum(root.left, sum);
        if (isPathSum) {
            return true;
        }

        isPathSum = hasPathSum(root.right, sum);
        if (isPathSum) {
            return true;
        }
        return false;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode == null) {
                    levelList.add(null);
                } else {
                    queue.offer(treeNode.left);
                    queue.offer(treeNode.right);
                    levelList.add(treeNode.val);
                }
            }
            int levelLen = levelList.size();
            if (levelLen == 1) {
                continue;
            }
            if (levelLen % 2 != 0) {
                return false;
            }
            for (int i = 0; i < levelLen / 2; i++) {
                if (!Objects.equals(levelList.get(i), levelList.get(levelLen - i - 1))) {
                    return false;
                }
            }
        }
        return true;
    }
}
