package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 类说明:998.最大二叉树II,在654的基础上，插入一个节点
 *  思路,
 *  先中序遍历构建数组nums[]
 *  再数组最末端加入val
 *  重新构建Tree
 * @author zengpeng
 */
public class InsertIntoMaxTreeII {

    ArrayList<Integer> rec=new ArrayList<>();

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        LinkedList<TreeNode> stack=new LinkedList<>();
        TreeNode treeNode=root;
        while (treeNode!=null)
        {
            stack.addLast(treeNode);
            treeNode=treeNode.left;

        }
        while (!stack.isEmpty())//中序遍历还原
        {
            TreeNode temp=stack.removeLast();
            rec.add(temp.val);
            if(temp.right!=null)
            {
                TreeNode right=temp.right;
                while (right!=null)
                {
                    stack.addLast(right);
                    right=right.left;

                }
            }

        }
        rec.add(val);
        int [] res=new int[rec.size()];
        for (int i=0;i<rec.size();i++) {
            res[i] = rec.get(i);
        }
        return constructMaximumBinaryTree(res);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }

        int maxIndex = getMaxIndex(nums);
        int[] leftNums = new int[maxIndex];
        int[] rightNums = new int[nums.length-maxIndex-1];

        System.arraycopy(nums,0,leftNums,0,maxIndex);
        System.arraycopy(nums,maxIndex+1,rightNums,0,nums.length-maxIndex-1);

        TreeNode node = new TreeNode();
        node.val=nums[maxIndex];
        node.left = constructMaximumBinaryTree(leftNums);
        node.right = constructMaximumBinaryTree(rightNums);

        return node;
    }

    /**
     * 返回最大值对应的数组下标
     * @param datas
     * @return
     */
    public int getMaxIndex(int[] datas){
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for(int i=0 ; i<datas.length ; i++){
            if(datas[i] >= max){
                max = datas[i];
                maxIndex = i;
            }
        }


        return maxIndex;
    }



}
