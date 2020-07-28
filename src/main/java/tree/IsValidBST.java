package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 类说明:98 验证二叉树搜索
 *
 * @author zengpeng
 */
public class IsValidBST {

    List<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        bianli(root);

        boolean flag1 = true;
        //数组是否为升序
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i) == Math.min(list.get(i), list.get(i + 1))) {
                flag1 = true;
                if(list.get(i).intValue() == list.get(i+1).intValue()){
                    return false;
                }
            } else {
                return false;
            }
        }
        return flag1;
    }

    public void bianli(TreeNode root) {
        if(root == null){
            return ;
        }
        bianli(root.left);
        list.add(root.val);
        bianli(root.right);
    }
}
