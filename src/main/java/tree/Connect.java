package tree;

import common.Node;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 类说明:填充每个节点的右侧节点指针
 *
 * 思路，对树进行广度优先遍历，将同一层的树节点连接起来
 *
 * @author zengpeng
 */
public class Connect {

    public Node connect(Node root) {
        if(root == null){
            return root;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);
        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            connectNext(queue);
            while (size > 0){
                Node node = queue.removeFirst();
                if(node.left != null){
                    queue.addLast(node.left);
                }
                if(node.right != null){
                    queue.addLast(node.right);
                }
                size--;
            }
            level++;

        }


        return root;
    }

    public void connectNext(LinkedList<Node> queue){
        for(int i=0;i<queue.size();i++){
            if(i == queue.size()-1){
                queue.get(i).next = null;
            }else {
                queue.get(i).next = queue.get(i+1);
            }
        }
    }

    public static void main(String[] args) {
        Connect connect = new Connect();
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node.left=node2;
        node.right=node3;

        Node connect1 = connect.connect(node);
        System.out.println(connect1.left.next.val);
    }
}
