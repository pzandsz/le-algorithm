package tree;

import common.TreeNode;

import java.util.LinkedList;

/**
 * 类说明: 222. 完全二叉树的节点个数
 *
 * @author zengpeng
 */
public class CountNodes {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int sum = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.removeFirst();
            if(node == null){
                continue;
            }
            sum++;
            queue.addLast(node.left);
            queue.addLast(node.right);

        }

        return sum;
    }
}
