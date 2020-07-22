package tree;

import common.TreeNode;

/**
 * 类说明:最小深度
 *
 * @author zengpeng
 */
public class MinDepth {

    int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        minDepthDi(root,1);
        return min;
    }


    public void minDepthDi(TreeNode node,int level){
        if(node == null){
            min = Math.min(level,min);
            return;
        }
        minDepthDi(node.left,level+1);
        minDepthDi(node.right,level+1);

    }
}
