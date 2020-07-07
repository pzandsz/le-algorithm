package tree;

import common.TreeNode;

/**
 * 类说明: 检查平衡性
 * 当前节点不存在右子节点 且左子节点存在子节点 false
 * 当前节点不存在左子节点 且右子节点存在子节点 false
 * 不行
 *
 *      1
 *    2    2
 *  3  3  N  N
 * 4 4
 *
 * 获得每个叶子结点对应的层数
 *
 * 对题目理解不足带来的坑:不能获得每个叶子节点的层数后求最大相差的原因是，平衡树要求的是每个节点下的两颗子树深度相差小于且等于1
 * 例如:[1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5]
 * 对二叉树进行递归动作,
 * @author zengpeng
 */
public class CheckBalanced {

    private boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return flag;
    }

    private int dfs(TreeNode n){
        if(n == null || !flag) {
            return 0;
        }
        int leftDepth = dfs(n.left)+1;
        int rightDepth = dfs(n.right)+1;
        if(Math.abs(leftDepth-rightDepth) > 1) {
            flag = false;
        }
        return Math.max(leftDepth,rightDepth);
    }


}
