package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 类说明:894.所有可能的满二叉树
 *      左节点添加子树，右节点不添加
 *      左节点不添加子树，右节点添加
 * @author zengpeng
 */
public class AllPossibleFBT {
    public List<TreeNode> allPossibleFBT(int N) {
        //N为偶数不可能满二叉树
        if ((N&1) == 0) {
            return new ArrayList<>(0);
        }
        List<TreeNode> list =new ArrayList<>();
        //N为1返回当前节点
        if (N==1) {
            list.add(new TreeNode(0));
            return list;
        }
        //N的值应减一，因为去掉了根节点
        --N;
        //i为N重分给左节点的节点数，每次加2因为每次向下分配都要多两个节点
        for (int i=1;i<N;i+=2){
            //这里list存着分配i个节点后的左节点的所有情况list
            List<TreeNode> left=allPossibleFBT(i);
            List<TreeNode> right=allPossibleFBT(N-i);
            for (TreeNode nodeL:left){
                //双重循环，分别把左右节点的各种情况赋予根节点的左右节点，并存储
                for (TreeNode nodeR:right){
                    TreeNode root=new TreeNode(0);
                    root.left=nodeL;
                    root.right=nodeR;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
