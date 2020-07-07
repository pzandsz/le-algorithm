package tree;

import common.TreeNode;

/**
 * 类说明:124 二叉树中的最大路径和
 *
 * @author zengpeng
 */
public class MaxPathNum {

    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return res;
    }

    /**
     *    1
     *  2   -1
     * 3 5
     * @param root
     * @return
     */
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax  = Math.max(0, dfs(root.left));
        int rightMax = Math.max(0, dfs(root.right));
        res = Math.max(res, root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }


}
