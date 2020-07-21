package tree;

import common.TreeNode;

/**
 * 类说明: 节点与其祖先之间的最大差值
 *
 * @author zengpeng
 */
public class MaxAncestorDiff {

    int max = 0;
    int val;
    public int maxAncestorDiff(TreeNode root) {
        if(root == null){
            return max;
        }
        val = root.val;


        diguiAncestorDiff(root);
        maxAncestorDiff(root.left);
        maxAncestorDiff(root.right);

        return max;
    }

    public void diguiAncestorDiff(TreeNode root){
        if(root == null){
            return;
        }

        max = Math.max(Math.abs(root.val - val),max);
        diguiAncestorDiff(root.left);
        diguiAncestorDiff(root.right);

    }
}
