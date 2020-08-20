package com.nokia.example.leetcode.tree;

import com.nokia.example.leetcode.entity.NTreeNode;
import com.nokia.example.leetcode.entity.TreeNode;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author by YingLong on 2020/7/27
 */
public class TreeTraversal {

    /**
     * 剑指 Offer 55 - I
     * 二叉树的深度
     */
    public int maxDepthV1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepthV1(root.left), maxDepthV1(root.right)) + 1;
    }

    /**
     * 剑指 Offer 55 - I
     * 二叉树的深度
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
     * 543
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


    /**
     * 606
     * 根据二叉树创建字符串
     *
     * @param root
     * @return
     */
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        String result = root.val + "";
        if (root.left == null && root.right == null) {
            return result;
        }
        result += "(" + tree2str(root.left) + ")";
        if (root.right != null) {
            result += "(" + tree2str(root.right) + ")";
        }
        return result;
    }

    /**
     * 993
     * 二叉树的堂兄弟节点
     *
     * @param root
     * @param x
     * @param y
     * @return
     */
    public static boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            int xIndex = -1, yIndex = -1;
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                if (node.val == x) {
                    xIndex = i;
                }
                if (node.val == y) {
                    yIndex = i;
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if (yIndex == -1 || xIndex == -1) {
                continue;
            }
            if (Math.abs(yIndex - xIndex) > 1 || Math.max(xIndex, yIndex) % 2 == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 559
     * N叉树的最大深度
     *
     * @param root
     * @return
     */
    public int maxDepth(NTreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;
        for (NTreeNode node : root.nodes) {
            maxDepth = Math.max(maxDepth(node), maxDepth);
        }
        return maxDepth + 1;
    }

    /**
     * 1145
     * 二叉树着色游戏
     *
     * @param root
     * @param n
     * @param x
     * @return
     */
    int leftNum = 0, rightNum = 0;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        backorder1145(root, x);
        int half = n / 2;
        return leftNum > half || rightNum > half || leftNum + rightNum < half;
    }

    public int backorder1145(TreeNode root, int x) {
        if (root == null) {
            return 0;
        }
        int left = backorder1145(root.left, x);
        int right = backorder1145(root.right, x);
        if (root.val == x) {
            leftNum = left;
            rightNum = right;
        }
        return left + right + 1;
    }

    /**
     * 面试题 04.10
     * 检查子树
     *
     * @param t1
     * @param t2
     * @return
     */
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return false;
        }
        return isSameTree(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    public boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }

    /**
     * 222
     * 完全二叉树的节点个数
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left + right + 1;
    }

    /**
     * 1448
     * 统计二叉树中好节点的数目
     *
     * @param root
     * @return
     */
    public int count = 0;

    public int goodNodes(TreeNode root) {
        traversal1448(root, Integer.MIN_VALUE);
        return count;
    }

    public void traversal1448(TreeNode root, int max) {
        if (root == null) {
            return;
        }
        if (root.val >= max) {
            max = root.val;
            count++;
        }
        traversal1448(root.left, max);
        traversal1448(root.right, max);
    }

    /**
     * 1110
     * 删点成林
     *
     * @param root
     * @param to_delete
     * @return
     */
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> nodeList = new ArrayList<>();
        if (root == null) {
            return nodeList;
        }
        List<Integer> deleteList = new ArrayList<>();
        for (int val : to_delete) {
            deleteList.add(val);
        }
        if (!deleteList.contains(root.val)) {
            nodeList.add(root);
        }
        nodeList.addAll(delSubNodes(root, null, deleteList, null));
        return nodeList;
    }


    public List<TreeNode> delSubNodes(TreeNode root, TreeNode parent, List<Integer> deleteList, Boolean isLeft) {
        List<TreeNode> nodeList = new ArrayList<>();
        if (root == null) {
            return nodeList;
        }
        nodeList.addAll(delSubNodes(root.left, root, deleteList, true));
        nodeList.addAll(delSubNodes(root.right, root, deleteList, false));
        if (deleteList.contains(root.val)) {
            if (root.left != null) {
                nodeList.add(root.left);
            }
            if (root.right != null) {
                nodeList.add(root.right);
            }
            if (isLeft != null) {
                if (isLeft) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        }
        return nodeList;
    }

    public List<TreeNode> delNodesV2(TreeNode root, int[] to_delete) {
        List<TreeNode> nodeList = new ArrayList<>();
        List<Integer> deleteList = new ArrayList<>();
        for (int val : to_delete) {
            deleteList.add(val);
        }
        delSubNodesV2(root, nodeList, deleteList, false);
        return nodeList;
    }

    public boolean delSubNodesV2(TreeNode root, List<TreeNode> nodeList, List<Integer> deleteList, boolean parentExists) {
        boolean del;
        if (root == null) {
            return false;
        }
        del = deleteList.contains(root.val);
        if (delSubNodesV2(root.left, nodeList, deleteList, !del)) {
            root.left = null;
        }
        if (delSubNodesV2(root.right, nodeList, deleteList, !del)) {
            root.right = null;
        }
        if (!del && !parentExists) {
            nodeList.add(root);
        }
        return del;
    }

    /**
     * 654
     * 最大二叉树
     *
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return maximumBinaryTreeDfs(nums, 0, nums.length);
    }

    public TreeNode maximumBinaryTreeDfs(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) {
            return null;
        }
        int maxIndex = getMaxIndex(nums, leftIndex, rightIndex);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = maximumBinaryTreeDfs(nums, leftIndex, maxIndex);
        root.right = maximumBinaryTreeDfs(nums, maxIndex + 1, rightIndex);
        return root;
    }

    private int getMaxIndex(int[] nums, int leftIndex, int rightIndex) {
        int maxIndex = leftIndex;
        for (int i = leftIndex; i < rightIndex; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /**
     * 1315
     * 祖父节点值为偶数的节点和
     *
     * @param root
     * @return
     */
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = sumEvenGrandparent(root.left);
        int right = sumEvenGrandparent(root.right);
        int result = right + left;
        if (root.val % 2 == 0) {
            if (root.left != null) {
                result += root.left.left != null ? root.left.left.val : 0;
                result += root.left.right != null ? root.left.right.val : 0;
            }
            if (root.right != null) {
                result += root.right.left != null ? root.right.left.val : 0;
                result += root.right.right != null ? root.right.right.val : 0;
            }
        }
        return result;
    }

    public int sumEvenGrandparentV2(TreeNode root) {
        return sumEvenGrandparentV2Dfs(root, 1, 1);
    }

    public int sumEvenGrandparentV2Dfs(TreeNode root, int gpVal, int pVal) {
        if (root == null) {
            return 0;
        }

        int left = sumEvenGrandparentV2Dfs(root.left, pVal, root.val);
        int right = sumEvenGrandparentV2Dfs(root.right, pVal, root.val);
        return gpVal % 2 == 0 ? root.val + left + right : right + left;
    }

    /**
     * 1104
     * 二叉树寻路
     *
     * @param label
     * @return
     */
    public List<Integer> pathInZigZagTree(int label) {
        int level = (int) (Math.log(label) / Math.log(2));
        List<Integer> result = new ArrayList<>(level);
        while (label > 1) {
            result.add(label);
            label = (int) (3 * Math.pow(2, --level) - label / 2 - 1);
        }
        result.add(1);
        Collections.reverse(result);
        return result;
    }

    /**
     * 1123
     * 最深叶节点的最近公共祖先
     *
     * @param root
     * @return
     */
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left > right) {
            return lcaDeepestLeaves(root.left);
        }
        if (left < right) {
            return lcaDeepestLeaves(root.right);
        }
        return root;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
