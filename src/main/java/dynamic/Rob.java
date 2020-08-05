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
 * @author zengpeng
 */
public class Rob {
    public int rob(TreeNode root) {
      return 0;
    }



//    public int rob(TreeNode root) {
//
//        if(root == null){
//            return 0;
//        }
//        //第一步，获取每层节点值之和
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        Map<Integer,Integer> map = new HashMap<>();
//        queue.addLast(root);
//        int size=0;
//        int level=0;
//        while (!queue.isEmpty()){
//            if(size == 0){
//                size = queue.size();
//                level++;
//            }
//            TreeNode node = queue.removeFirst();
//            if(node==null){
//                size--;
//                continue;
//            }
//            if(map.get(level) == null){
//                map.put(level,node.val);
//            }else {
//                map.put(level,node.val + map.get(level));
//            }
//            queue.addLast(node.left);
//            queue.addLast(node.right);
//            size--;
//
//        }
//        //第二步，计算最优解
//
//        int[] dp = new int[level];
//        for(int i=1;i<level;i++){
//            if(i==1){
//                dp[i] = map.get(i);
//                continue;
//            }
//            if(i==2){
//                dp[i] = Math.max(map.get(i),dp[i-1]);
//                continue;
//            }
//
//            dp[i]=Math.max(dp[i-1],dp[i-2]+map.get(i));
//        }
//
//        return dp[level-1];
//    }
}
