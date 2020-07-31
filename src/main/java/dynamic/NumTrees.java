package dynamic;

import java.util.HashMap;

/**
 * 类说明: 96 不同的二叉树
 *
 * 划分子问题：
 *      令G(n)表示 n个节点能够构造的二叉搜索树的个数
 *      令节点0为根节点，其左子树的个数是0，右子树的个数是n-1 G(0)*G(n-1)
 *      令节点1为根节点，其左子树的个数是1，右子树的个数是n-2 G(1)*G(n-2)
 *      .
 *      .
 *      .
 *      令节点n为根节点，其左子树的个数是n-1，右子树节点是0 G(n-1)*G(0)
 *
 * 则
 *  G(n) = G(0)*G(n-1)+G(1)*G(n-2)+...+G(n-1)*G(0)
 *  要知道G(n),就需要知道G(0),G(1),...,G(n-1)
 *  要知道G(n-1),就需要知道G(0),G(1),...,G(n-2)
 * @author zengpeng
 */
public class NumTrees {

    HashMap<Integer,Integer> cache = new HashMap<>();
    public int numTrees(int n){
        if(n < 1){
            return 1;
        }
        cache.put(1,1);
        int sum = 0;
        for(int i=0;i<n;i++){
            Integer integer = cache.get(i);
            Integer integer1 = cache.get(n - 1 - i);
            if( null == integer && null != integer1){
                sum = sum + numTrees(i) * integer1;
                continue;
            }
            if( null != integer && null == integer1){
                sum = sum + numTrees(n-1-i) * integer;
                continue;
            }
            if( null != integer && null != integer1){
                sum = sum + integer * integer1;
                continue;
            }
            sum = sum + numTrees(i) * numTrees(n - 1 - i);
        }

        cache.put(n,sum);
        return sum;
    }


    public static void main(String[] args) {
        NumTrees numTrees = new NumTrees();
        System.out.println(numTrees.numTrees(4));
    }
}
