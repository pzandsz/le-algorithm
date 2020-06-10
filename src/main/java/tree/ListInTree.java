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
        if(root == null){
            return false;
        }
        boolean result = false;

        if(root.val == head.val){
            if(head.next == null){
                return true;
            }
            result = diguiTrue(root.left,head.next) || diguiTrue(root.right,head.next);
            if(result){
                return result;
            }
        }

        result = digui(root.left,head)||digui(root.right,head);
        return result;

    }

    public static boolean diguiTrue(TreeNode nextTree,ListNode nextList){
        if(nextTree == null){
            return false;
        }
        if(nextList.val == nextTree.val){
            if(nextList.next == null){
                return true;
            }

            return diguiTrue(nextTree.left,nextList.next) || diguiTrue(nextTree.right,nextList.next);
        }
        return false;
    }
}
