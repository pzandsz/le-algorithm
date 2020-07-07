package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 类说明:BFS算法，层序遍历
 *
 * @author 曾鹏
 */
public class LevelSort {

    private static LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

    /**
     * 广度优先搜索
     */
    public static List<List<Integer>> bfs(TreeNode root){

        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root); // 添加起点

        while (!q.isEmpty()) {
            int curSize = q.size(); // 实时更新当前队列长度
            LinkedList<Integer> subList = new LinkedList<Integer>();
            for (int i = 0; i < curSize; i++) {
                TreeNode curr = q.poll();
                if (curr != null) {
                    subList.add(curr.val);
                    if (curr.left != null) {
                        q.offer(curr.left);
                    }
                    if (curr.right != null) {
                        q.offer(curr.right);
                    }
                }
            }
            result.add(subList);
        }
        return result;

//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        if(root == null){
//            return result;
//        }
//        queue.addLast(root);
//        List<Integer> list = new ArrayList<Integer>();
//        list.add(root.val);
//        result.add(list);
//
//        while (!queue.isEmpty()){
//            TreeNode treeNode = queue.removeFirst();
//            System.out.println(treeNode.val);
//
//            if(treeNode.left != null){
//                queue.addLast(treeNode.left);
//            }
//
//            if(treeNode.right != null){
//                queue.addLast(treeNode.right);
//            }
//        }

//        return result;
    }
}
