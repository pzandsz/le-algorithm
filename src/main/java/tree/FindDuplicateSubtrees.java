package tree;

import common.TreeNode;

import java.util.*;

/**
 * 类说明:652.寻找重复的子树
 * 序列化二叉树。
 *
 *
 *    1
 *   / \
 *  2   3
 *     / \
 *    4   5
 * 例如上面这棵树序列化结果为 1,2,#,#,3,4,#,#,5,#,#。每棵不同子树的序列化结果都是唯一的。
 *
 *
 * @author zengpeng
 */
public class FindDuplicateSubtrees {

    HashMap<String,Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> resList = new ArrayList<>();

        if(root == null){
            return resList;
        }

        if(checkTreeNode(root)){
            resList.add(root);
        }
        resList.addAll(findDuplicateSubtrees(root.left));
        resList.addAll(findDuplicateSubtrees(root.right));

        return resList;
    }

    public boolean checkTreeNode(TreeNode node){
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(node == null){
            return false;
        }
        String str = "";
        queue.addLast(node);
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.removeFirst();
            if(treeNode == null){
                str = str + "#";
            }else {
                str = str + treeNode.val;
                queue.addLast(treeNode.left);
                queue.addLast(treeNode.right);
            }

        }
        Integer integer = map.get(str);
        if(integer == null){
            integer = 0;
        }
        if(integer == 1){
            map.put(str,integer+1);
            return true;
        }
        map.put(str,integer+1);
        return false;
    }

    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();
        queue.addLast(null);

        System.out.println(queue.isEmpty());
        System.out.println(queue.removeFirst());
    }
}
