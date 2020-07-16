package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 类说明:1104.二叉树寻路
 * 正常顺序
 *           1
 *      2          3
 *  4     5     6    7
 * 8 9 10 11 12 13 14 15
 *
 * 输入15
 * 15/2=7
 * 7/2=3
 * 3/2=1
 * 位运算
 * 若顺序排序，得到的路径是 1 -> 3 -> 7 -> 14
 * 根据题意排序后
 * 若label在奇数层 则偶数层 后(层数-1=N) N位异或0
 * 若label在偶数层，则奇数层后(层数-1=N) N位异或0 （第一层除外）
 * @author zengpeng
 */
public class PathInZigZagTree {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> list = new LinkedList<>();
        int level = 32;
        int min = 1 << (level - 1);
        // 计算当前节点所在的层
        for (; (min & label) != min; level--) {
            min = 1 << (level - 2);
        }
        for (; level > 1; level--, min >>= 1) {
            list.add(0, label);
            // 当前节点所在层的最大值
            int max = (min << 1) - 1;
            // 计算当前节点的父节点的值
            if ((level & 1) == 0) {
                // 偶数层：父节点的值=父节点所在的层的最小值+父节点在所在层的索引位置
                label = (min >> 1) + ((max - label) >> 1);
            } else {
                // 奇数层：父节点的值=父节点所在的层的最大值-父节点在所在层的索引位置
                label = (max >> 1) - ((label - min) >> 1);
            }
        }
        list.add(0, 1);
        return list;

    }

    public static void main(String[] args) {
        PathInZigZagTree tree = new PathInZigZagTree();
        List<Integer> integers = tree.pathInZigZagTree(14);
        integers.forEach(val->{
            System.out.println(val);
        });
    }
}
