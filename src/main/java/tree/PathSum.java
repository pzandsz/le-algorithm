package tree;

import common.TreeNode;

/**
 * 类说明:437.路径总和
 *
 * @author zengpeng
 */
public class PathSum {

    volatile int res = 0;
    public int pathSum(TreeNode root, int sum) {

        if(root == null){
            return 0;
        }
        pathSumDigui(root,sum);
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        return res;
    }

    public void pathSumDigui(TreeNode root, int sum) {
        if(root == null){
            return ;
        }
        if(root.val == sum){
            res++;
        }
        pathSumDigui(root.left,sum-root.val);
        pathSumDigui(root.right,sum-root.val);
    }
}
