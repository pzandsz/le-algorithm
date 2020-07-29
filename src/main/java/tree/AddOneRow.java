package tree;

import common.TreeNode;

/**
 * 类说明:623在二叉树中添加一行
 *
 * @author zengpeng
 */
public class AddOneRow {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null){
            return root;
        }
        if(d == 1) {
            TreeNode rootNew = new TreeNode(v);
            rootNew.left = root;
            return rootNew;
        }
        digui(root,v,d);
        return root;
    }

    public void digui(TreeNode root, int v, int d) {
        if (root == null){
            return ;
        }

        if(d-1 == 1){
            TreeNode left = new TreeNode(v);
            TreeNode right = new TreeNode(v);
            left.left = root.left;
            right.right = root.right;
            root.left = left;
            root.right = right;
            return;

        }

        d--;
        digui(root.left,v,d);
        digui(root.right,v,d);
    }
}
