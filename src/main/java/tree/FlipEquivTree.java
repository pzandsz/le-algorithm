package tree;

import common.TreeNode;

import java.util.*;

/**
 * 类说明: 951.翻转等价二叉树
 * 思路：翻转只能翻转同一层级的节点，无法做到跨层级的翻转
 * 将二叉树根据层级拆分为 level->list的map,只要同一层级的节点的值相同即可
 *  0
 * 3 1
 *    2
 *
 *   0
 *  3 1
 * 2
 * 此路不通
 *
 * 思路
 *
 * 如果二叉树 root1，root2 根节点值相等，那么只需要检查他们的孩子是不是相等就可以了。
 *
 * 算法
 *
 * 存在三种情况：
 *
 * 如果 root1 或者 root2 是 null，那么只有在他们都为 null 的情况下这两个二叉树才等价。
 * 如果 root1，root2 的值不相等，那这两个二叉树的一定不等价。
 * 如果以上条件都不满足，也就是当 root1 和 root2 的值相等的情况下，需要继续判断 root1 的孩子节点是不是跟 root2 的孩子节点相当。因为可以做翻转操作，所以这里有两种情况需要去判断。

 * @author zengpeng
 */
public class FlipEquivTree {

            public boolean flipEquiv(TreeNode root1, TreeNode root2) {
                if (root1 == root2) {
                    return true;
                }
                if (root1 == null || root2 == null || root1.val != root2.val) {
                    return false;
                }

                return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
                        flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
            }


}
