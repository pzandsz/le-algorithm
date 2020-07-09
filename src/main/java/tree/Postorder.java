package tree;

import common.NTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 类说明:590.N叉树的后序遍历
 * 参照二叉树的后序遍历
 *
 * @author zengpeng
 */
public class Postorder {
    ArrayList<Integer> res = new ArrayList<Integer>();
    public List<Integer> postorder(NTreeNode root) {
        if(root == null){
            return new ArrayList<Integer>();
        }

        for(int i=0;i<root.children.size();i++){
            postorder(root.children.get(i));
        }
        res.add(root.val);
        return res;
    }
}
