package dynamic;

import common.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 类说明: 337 打家劫舍III
 * 错误思路:获取每层节点值之和，因为只有直连才会影响，分层的方法忽略了左右子树之间也不直连的情况
 *
 * dp公式 dp[i]=Max(dp[i-1],dp[i-2]+sum(i))
 * 其中dp[i]中的i表示二叉树的层数,sum(i)表示第i层节点值之和
 *
 * 思路:
 * 递归
 *    2
 *  3   4
 * 5   5
 *
 * 每个节点可选择偷或者不偷两种状态，根据题目意思，相连节点不能一起偷
 *
 * 当前节点选择偷时，那么两个孩子节点就不能选择偷了
 * 当前节点选择不偷时，两个孩子节点只需要拿最多的钱出来就行(两个孩子节点偷不偷没关系)
 * 我们使用一个大小为 2 的数组来表示 int[] res = new int[2] 0 代表不偷，1 代表偷
 * 任何一个节点能偷到的最大钱的状态可以定义为
 *
 * 当前节点选择不偷：当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
 * 当前节点选择偷：当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 +
 *                                         右孩子选择不偷时能得到的钱 + 当前节点的钱数
 * @author zengpeng
 */
public class Rob {
    public int rob(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }

    public int[] robInternal(TreeNode root) {
        if (root == null){
            return new int[2];
        }
        int[] result = new int[2];

        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;

        return result;
    }

}
