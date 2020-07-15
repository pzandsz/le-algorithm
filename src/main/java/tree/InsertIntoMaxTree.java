package tree;

import common.TreeNode;

import java.util.Arrays;

/**
 * 类说明: 654 最大二叉树
 *      二叉树的根是数组中的最大元素。
 *      左子树是通过数组中最大值左边部分构造出的最大二叉树。
 *      右子树是通过数组中最大值右边部分构造出的最大二叉树。
 *
 * [3,2,1,6,0,5]
 * 找到数组中最大的值并设置根结点，将其左边部分递归构建左子树，右边部分递归调用右子树
 * @author zengpeng
 */
public class InsertIntoMaxTree {
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
