package com.nokia.example.leetcode.tree;

import com.nokia.example.leetcode.entity.TreeNode;

import java.util.*;

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
     * <p>
     * 面试题 04.08
     * 首个共同祖先
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

    /**
     * 894
     * 所有可能的满二叉树
     *
     * @param N
     * @return
     */
    public Map<Integer, List<TreeNode>> cache = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int N) {
        if (cache.containsKey(N)) {
            return cache.get(N);
        }
        List<TreeNode> nNodeList = new ArrayList<>();
        if (N % 2 != 1) {
            return nNodeList;
        }
        if (N == 1) {
            TreeNode node = new TreeNode(0);
            nNodeList.add(node);
        } else {
            for (int x = 1; x < N; x++) {
                int y = N - x - 1;
                List<TreeNode> leftNodeList = allPossibleFBT(x);
                List<TreeNode> rightNodeList = allPossibleFBT(y);
                for (TreeNode leftNode : leftNodeList) {
                    for (TreeNode rightNode : rightNodeList) {
                        TreeNode node = new TreeNode(0);
                        node.left = leftNode;
                        node.right = rightNode;
                        nNodeList.add(node);
                    }
                }
            }
        }
        cache.put(N, nNodeList);
        return nNodeList;
    }

    /**
     * 814
     * 二叉树剪枝
     *
     * @param root
     * @return
     */
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = pruneTree(root.left);
        TreeNode right = pruneTree(root.right);
        if (left == null) {
            root.left = null;
        }
        if (right == null) {
            root.right = null;
        }
        if (root.val == 0 && left == null && right == null) {
            return null;
        }
        return root;
    }

    /**
     * 1325
     * 删除给定值的叶子节点
     *
     * @param root
     * @param target
     * @return
     */
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }

    /**
     * 1379
     * 找出克隆二叉树中的相同节点
     *
     * @param original
     * @param cloned
     * @param target
     * @return
     */
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned == null || target == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = cloned;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            TreeNode right = null;
            while (node.right == null || node.right == right) {
                if (node.val == target.val) {
                    return node;
                }
                right = node;
                if (stack.isEmpty()) {
                    return null;
                }
                node = stack.pop();
            }
            stack.push(node);
            node = node.right;
        }
        return null;
    }
}
