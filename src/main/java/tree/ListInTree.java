package tree;

import common.ListNode;
import common.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * 类说明:1367.二叉树中的列表
 *
 * @author 曾鹏
 */
public class ListInTree {
    public static void main(String[] args) {

    }

    public static boolean digui(TreeNode root, ListNode head){
        if(root.val == head.val){
            return diguiTrue(root.left,head.next) || diguiTrue(root.right,head.next);

        }else {
            digui(root.left,head);
            digui(root.right,head);
        }

        return false;
    }

    public static boolean diguiTrue(TreeNode nextTree,ListNode nextList){
        if(nextTree == null && nextList == null){
            return true;
        }
        if(nextList == null || nextTree == null){
            return false;
        }
        if(nextList.val == nextTree.val){
            return diguiTrue(nextTree.left,nextList.next) || diguiTrue(nextTree.right,nextList.next);
        }
        return false;
    }
}
