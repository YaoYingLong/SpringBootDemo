package com.nokia.example.leetcode.tree;

import com.nokia.example.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by YingLong on 2020/7/30
 */
public class SearchTree {
    /**
     * 面试题 17.12
     * BiNode
     * <p>
     * 897
     * 递增顺序查找树
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

    /**
     * 剑指 Offer 68 - I
     * 二叉搜索树的最近公共祖先
     * <p>
     * 235
     * 二叉搜索树的最近公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

    /**
     * 剑指 Offer 68 - I
     * 二叉搜索树的最近公共祖先
     * <p>
     * 235
     * 二叉搜索树的最近公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
        // 保证 p.val < q.val
        if (p.val > q.val) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        while (root != null) {
            // p,q 都在 root 的右子树中
            if (root.val < p.val) {
                // 遍历至右子节点
                root = root.right;
                // p,q 都在 root 的左子树中
            } else if (root.val > q.val) {
                // 遍历至左子节点
                root = root.left;
            } else {
                break;
            }
        }
        return root;
    }

    /**
     * 剑指 Offer 54
     * 二叉搜索树的第k大节点
     *
     * @param root
     * @param k
     * @return
     */
    public int kth = 1;

    public int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        int left = kthLargest(root.right, k);
        if (left != -1) {
            return left;
        }
        if (k == kth++) {
            return root.val;
        }
        return kthLargest(root.left, k);
    }

    /**
     * 653
     * 两数之和 IV - 输入 BST
     *
     * @param root
     * @param k
     * @return
     */
    public List<Integer> differ = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        boolean left = findTarget(root.left, k);
        if (left) {
            return true;
        }
        if (differ.contains(k - root.val)) {
            return true;
        }
        differ.add(root.val);
        return findTarget(root.right, k);
    }

    /**
     * 700
     * 二叉搜索树中的搜索
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (val < root.val) {
            TreeNode left = searchBST(root.left, val);
            if (left != null) {
                return left;
            }
        } else {
            return searchBST(root.right, val);
        }
        return null;
    }

    /**
     * 938
     * 二叉搜索树的范围和
     *
     * @param root
     * @param L
     * @param R
     * @return
     */
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        int left = rangeSumBST(root.left, L, R);
        int right = rangeSumBST(root.right, L, R);
        if (root.val >= L && root.val <= R) {
            return root.val + left + right;
        }
        return left + right;
    }

    /**
     * 783
     * 二叉搜索树节点最小距离
     * <p>
     * 530
     * 二叉搜索树的最小绝对差
     *
     * @param root
     * @return
     */
    public int minDiff = Integer.MAX_VALUE;
    public Integer beforeNodeVal;

    public int minDiffInBST(TreeNode root) {
        minDiffInBSTTrav(root);
        return minDiff;
    }

    public void minDiffInBSTTrav(TreeNode root) {
        if (root == null) {
            return;
        }
        minDiffInBSTTrav(root.left);
        if (beforeNodeVal != null) {
            minDiff = Math.min(minDiff, root.val - beforeNodeVal);
        }
        beforeNodeVal = root.val;
        minDiffInBSTTrav(root.right);
    }

    /**
     * 501
     * 二叉搜索树中的众数
     *
     * @param root
     * @return
     */
    public int freq = 0;
    public int curFreq = 0;
    public Integer before;
    public int[] ans = new int[0];

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return ans;
        }
        findModeTrav(root);
        return ans;
    }

    public void findModeTrav(TreeNode root) {
        if (root == null) {
            return;
        }
        findModeTrav(root.left);
        if (before == null || before != root.val) {
            curFreq = 1;
            before = root.val;
        } else {
            curFreq++;
        }
        if (curFreq > freq) {
            freq = curFreq;
            ans = new int[]{before};
        } else if (freq == curFreq && freq != 0) {
            int[] tmp = new int[ans.length + 1];
            System.arraycopy(ans, 0, tmp, 0, ans.length);
            tmp[ans.length] = before;
            ans = tmp;
        }
        findModeTrav(root.right);
    }

    /**
     * 669
     * 修剪二叉搜索树
     *
     * @param root
     * @param L
     * @param R
     * @return
     */
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        if (root.val < L) {
            return trimBST(root.right, L, R);
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    /**
     * 230
     * 二叉搜索树中第K小的元素
     *
     * @param root
     * @param k
     * @return
     */
    public int currentTh = 1;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        int left = kthSmallest(root.left, k);
        if (left != -1) {
            return left;
        }
        if (k == currentTh++) {
            return root.val;
        }
        return kthSmallest(root.right, k);
    }

}
