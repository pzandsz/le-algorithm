package tree;

import common.TreeNode;

/**
 * 类说明: 404.左叶子之和
 *
 *      1
 *     / \
 *    2  3
 *  /  \
 * 4   5
 * @author zengpeng
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;

        if(root == null){
            return sum;
        }

        if(root.left != null && root.left.left == null && root.left.right == null){
            sum = sum + root.left.val;
        }

        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
