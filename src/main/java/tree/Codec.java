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
        while (queue != null && !queue.isEmpty()){
            TreeNode currentNode = queue.removeFirst();

            String tmp = currentNode == null ?  "null" : currentNode.val+"";

            res = res + tmp + ",";
            if(currentNode == null){
                continue;
            }
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
        if(dataTmp.trim().equals("")){
            return null;
        }

        LinkedList<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        String[] array = dataTmp.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(array[0]));
        nodeQueue.addLast(root);
        int i=1;
        int len = array.length;
        while (nodeQueue != null && !nodeQueue.isEmpty()){
            TreeNode currentNode = nodeQueue.removeFirst();
            if(i < len && array[i].equals("null")){
                currentNode.left = null;
            }else if(i < len){
                currentNode.left = new TreeNode(Integer.parseInt(array[i]));
                nodeQueue.addLast(currentNode.left);
            }

            if(i+1 < len && array[i+1].equals("null")){
                currentNode.right = null;
            }else if(i+1 < len){
                currentNode.right = new TreeNode(Integer.parseInt(array[i+1]));
                nodeQueue.addLast(currentNode.right);
            }

            i = i+2;

        }

        return root;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode deserialize = codec.deserialize("[1,2,3,null,null,4,5]");
        String serialize = codec.serialize(deserialize);
        System.out.println(serialize);

    }
}
