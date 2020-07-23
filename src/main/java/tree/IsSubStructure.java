package tree;

import common.TreeNode;

import java.util.LinkedList;

/**
 * 类说明: 剑指offer 26 树的子结构
 *
 * @author zengpeng
 */
public class IsSubStructure {
    /**
     * 判断B是不是A的子结构
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null && B == null){
            return true;
        }
        if(A == null){
            return false;
        }
        if(B == null){
            return false;
        }

        if(judge(A,B)){
            return true;
        }

        return isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }


    public boolean judge(TreeNode a, TreeNode b){
        if(a == null && b == null){
            return true;
        }
        if(a == null){
            return false;
        }
        if(b == null){
            return true;
        }


        if(a.val == b.val){
            return judge(a.left,b.left) && judge(a.right,b.right);
        }

        return false;
    }
}
