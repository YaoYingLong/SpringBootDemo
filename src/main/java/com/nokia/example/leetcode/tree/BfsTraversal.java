package com.nokia.example.leetcode.tree;

import com.nokia.example.leetcode.entity.TreeNode;

import java.util.*;

/**
 * @author by YingLong on 2020/7/31
 */
public class BfsTraversal {

    /**
     * 872
     * 叶子相似的树
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> treeOneLeafList = new ArrayList<>();
        List<Integer> treeTwoLeafList = new ArrayList<>();
        getLeafs(root1, treeOneLeafList);
        getLeafs(root2, treeTwoLeafList);
        return treeOneLeafList.equals(treeTwoLeafList);
    }

    public void getLeafs(TreeNode root, List<Integer> resultList) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            resultList.add(root.val);
        }
        getLeafs(root.left, resultList);
        getLeafs(root.right, resultList);
    }

    /**
     * 637
     * 二叉树的层平均值
     *
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Double> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            long levelSum = 0;
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            resultList.add(levelSum * 1.0 / len);
        }
        return resultList;
    }

    /**
     * 二叉树的层次遍历
     *
     * @param root
     * @return
     */
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


    /**
     * 107
     * 二叉树的层次遍历 II
     *
     * @param root
     * @return
     */
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

    /**
     * 剑指 Offer 32 - I
     * 从上到下打印二叉树
     *
     * @param root
     * @return
     */
    public int[] levelOrderV2(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> resList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                resList.add(node.val);
            }
        }
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    /**
     * 剑指 Offer 32 - III
     * 从上到下打印二叉树 III
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderV3(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelTh = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (levelTh % 2 == 0) {
                    subList.add(node.val);
                } else {
                    subList.add(0, node.val);
                }
            }
            resultList.add(subList);
            levelTh++;
        }
        return resultList;
    }

    /**
     * 623
     * 在二叉树中增加一行
     *
     * @param root
     * @param v
     * @param d
     * @return
     */
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode nodeV = new TreeNode(v);
            nodeV.left = root;
            return nodeV;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelNum = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (levelNum == d - 1) {
                    TreeNode nodeVLeft = new TreeNode(v);
                    nodeVLeft.left = node.left;
                    node.left = nodeVLeft;
                    TreeNode nodeVRight = new TreeNode(v);
                    nodeVRight.right = node.right;
                    node.right = nodeVRight;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (levelNum == d - 1) {
                return root;
            }
            levelNum++;
        }
        return root;
    }

    /**
     * 623
     * 在二叉树中增加一行
     *
     * @param root
     * @param v
     * @param d
     * @return
     */
    public TreeNode addOneRowV2(TreeNode t, int v, int d) {
        if (d == 1) {
            TreeNode n = new TreeNode(v);
            n.left = t;
            return n;
        }
        insert(v, t, 1, d);
        return t;
    }

    public void insert(int val, TreeNode node, int depth, int n) {
        if (node == null) {
            return;
        }
        if (depth == n - 1) {
            TreeNode t = node.left;
            node.left = new TreeNode(val);
            node.left.left = t;
            t = node.right;
            node.right = new TreeNode(val);
            node.right.right = t;
        } else {
            insert(val, node.left, depth + 1, n);
            insert(val, node.right, depth + 1, n);
        }
    }

    /**
     * 863
     * 二叉树中所有距离为 K 的结点
     *
     * @param root
     * @param target
     * @param K
     * @return
     */
    public Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if (root == null) {
            return new ArrayList<>();
        }
        parent(root, null);

        Set<TreeNode> containSet = new HashSet<>();
        containSet.add(target);
        containSet.add(null);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        int depth = 0;
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (depth == K) {
                    result.add(node.val);
                }
                if (!containSet.contains(node.left)) {
                    containSet.add(node.left);
                    queue.offer(node.left);
                }
                if (!containSet.contains(node.right)) {
                    containSet.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode parent = parentMap.get(node);
                if (!containSet.contains(parent)) {
                    containSet.add(parent);
                    queue.offer(parent);
                }
            }
            if (depth == K) {
                return result;
            }
            depth++;
        }
        return result;
    }

    public void parent(TreeNode node, TreeNode parentNode) {
        if (node != null) {
            parentMap.put(node, parentNode);
            parent(node.left, node);
            parent(node.right, node);
        }
    }
}
