package tree;

import common.TreeNode;

/**
 * 类说明: 面试题68 - I. 二叉搜索树的最近公共祖先
 *
 * 对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先 )
 *                6
 *         2          8
 *     0       4    7   9
 *           3  5
 *
 *  题目中存在一个隐形的条件：二叉搜索树
 *  当p,q均大于当前节点时，递归右子树
 *  当p,q均小于当前节点时，递归左子树
 *  当p,q无法递归同一个节点时，返回当前节点
 * @author zengpeng
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left,p,q);
        }

        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
}
