package tree;

import common.TreeNode;

import java.util.LinkedList;

/**
 * 类说明: 剑指offer 序列化和反序列话二叉树
 * 对树进行广度遍历
 * @author zengpeng
 */
public class Codec {

    private LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

    /**
     * 序列化二叉树
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        String res="[";
        if(root == null){
            return "[]";
        }
        queue.addLast(root);
        while (queue != null){
            TreeNode currentNode = queue.removeFirst();
            String tmp = currentNode == null ?  "null" : currentNode.val+"";

            res = res + tmp + ",";
            queue.addLast(currentNode.left);
            queue.addLast(currentNode.right);
        }
        res = res + "]";
        return res;
    }

    /**
     * 反序列化二叉树
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        String dataTmp = data.replace("[","");
        dataTmp=dataTmp.replace("]","");

        String[] split = dataTmp.split(",");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }

        return null;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        codec.deserialize("[1,2,3,null,null,4,5]");
    }
}
