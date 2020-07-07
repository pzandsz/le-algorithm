package tree;

import common.TreeNode;

import java.util.LinkedList;

/**
 * 类说明: 173.二叉搜索树迭代器
 *
 * @author zengpeng
 */
public class BSTIterator {

    private LinkedList<Integer> iterator = new LinkedList<Integer>();
    private Integer currentIndex = 0;

    public BSTIterator(TreeNode root) {
        middleIterator(root);
    }

    /**
     * 中序遍历
     * @param root
     */
    public void middleIterator(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            iterator.add(root.val);
            return;
        }
        middleIterator(root.left);
        iterator.add(root.val);
        middleIterator(root.right);

    }

    public int next() {
        if(iterator.size() == 0){
            return 0;
        }
        int result = iterator.get(currentIndex);
        currentIndex++;
        return result;
    }


    public boolean hasNext() {
        if(currentIndex >= iterator.size()){
            return false;
        }
        return true;
    }
}
